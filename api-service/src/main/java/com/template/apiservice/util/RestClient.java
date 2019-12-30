package com.template.apiservice.util;


import java.util.Collections;
import java.util.Map;

import com.template.apiservice.exception.CallServiceException;
import com.template.apiservice.exception.NoDataFoundException;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

public class RestClient {

  RestTemplate restTemplate;
  RestClientExceptionHandler errorHandler;

  public RestClient() {

    this.restTemplate = new RestTemplate();
    this.errorHandler = new RestClientExceptionHandler();
    this.restTemplate.setErrorHandler(errorHandler);
    HttpComponentsClientHttpRequestFactory requestFactory =
        new HttpComponentsClientHttpRequestFactory();
    requestFactory.setConnectTimeout(1000000);
    requestFactory.setReadTimeout(1000000);
    BufferingClientHttpRequestFactory bufferingClientHttpRequestFactory =
        new BufferingClientHttpRequestFactory(requestFactory);
    this.restTemplate.setRequestFactory(bufferingClientHttpRequestFactory);
  }

  public <T> T get(String url, Class<T> responseType) {
    try {
      return restTemplate.getForObject(url, responseType);
    } catch (NoDataFoundException e) {
      return null;
    }
  }

  public <T> T get(String url, Class<T> responseType, Map<String, String> queryParams) {
    try {
      return restTemplate.getForObject(url, responseType, queryParams);
    } catch (NoDataFoundException e) {
      return null;
    }
  }

  public <K> K get(
      String url,
      Class<K> responseType,
      Map<String, String> queryParams,
      Map<String, String> headerParams) {
    HttpMethod httpMethod = HttpMethod.GET;
    HttpHeaders httpHeaders = setHeaders(headerParams);
    HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<>(httpHeaders);

    UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url);

    if (!CollectionUtils.isEmpty(queryParams)) {
      for (Map.Entry<String, String> entry : queryParams.entrySet()) {
        builder.queryParam(entry.getKey(), entry.getValue());
      }
    }

    ResponseEntity<K> response = exchange(responseType, httpEntity, builder, httpMethod);

    if (response.getStatusCode().is4xxClientError()) {
      throw new CallServiceException("Service is not working properly!");
    }

    return response.getBody();
  }

  public <T, K> K patch(String url, T body, Class<K> responseType) {
    try {
      return restTemplate.patchForObject(url, body, responseType);
    } catch (Exception e) {
      // log.error("Unsuccessful service call. URL: " + url, e);
      throw new CallServiceException("Can not call " + url + " -- \nError Detail:" + e.toString());
    }
  }

  public void delete(String url) {
    try {
      restTemplate.delete(url);
      ;
    } catch (Exception e) {
      throw new CallServiceException("Can not call " + url + " -- \nError Detail:" + e.toString());
    }
  }

  public <T, K> K post(String url, T body, Class<K> responseType) {
    try {
      UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url);
      HttpEntity<T> httpEntity = new HttpEntity<>(body);
      ResponseEntity<K> response = exchange(responseType, httpEntity, builder, HttpMethod.POST);
      return response.getBody();
    } catch (Exception e) {
      // log.error("Unsuccessful service call. URL: " + url, e);
      throw new CallServiceException("Can not call " + url + " -- \nError Detail:" + e.toString());
    }
  }

  public <T, K> K post(
      String url, Class<K> responseType, T body, Map<String, String> headerParams) {
    HttpMethod httpMethod = HttpMethod.POST;
    try {
      HttpHeaders httpHeaders = setHeaders(headerParams);
      HttpEntity<T> httpEntity = new HttpEntity<>(body, httpHeaders);

      UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url);

      ResponseEntity<K> response = exchange(responseType, httpEntity, builder, httpMethod);

      return response.getBody();
    } catch (Exception e) {
      throw new CallServiceException("Can not call " + url + " -- \nError Detail:" + e.toString());
    }
  }

  public <T, K> K put(String url, Class<K> responseType, T body, Map<String, String> headerParams) {
    HttpMethod httpMethod = HttpMethod.PUT;
    try {
      HttpHeaders httpHeaders = setHeaders(headerParams);
      HttpEntity<T> httpEntity = new HttpEntity<>(body, httpHeaders);

      UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url);

      ResponseEntity<K> response = exchange(responseType, httpEntity, builder, httpMethod);

      return response.getBody();
    } catch (Exception e) {
      throw new CallServiceException("Can not call " + url + " -- \nError Detail:" + e.toString());
    }
  }

  protected HttpHeaders setHeaders(Map<String, String> headerParams) {
    HttpHeaders httpHeaders = new HttpHeaders();
    if (!CollectionUtils.isEmpty(headerParams)) {
      for (Map.Entry<String, String> entry : headerParams.entrySet()) {
        httpHeaders.set(entry.getKey(), entry.getValue());
      }
    }
    return httpHeaders;
  }

  protected <K> ResponseEntity<K> exchange(
      Class<K> responseType,
      HttpEntity httpEntity,
      UriComponentsBuilder builder,
      HttpMethod httpMethod) {
    try {
      ResponseEntity<K> response =
          restTemplate.exchange(
              builder.build().toUriString(), httpMethod, httpEntity, responseType);
      return response;
    } catch (NoDataFoundException e) {
      if (httpMethod.equals(HttpMethod.GET)) {
        return null;
      } else {
        throw e;
      }
    }
  }

  protected <K> ResponseEntity<K> exchange(
      ParameterizedTypeReference<K> responseType,
      HttpEntity httpEntity,
      UriComponentsBuilder builder,
      HttpMethod httpMethod) {
    try {
      ResponseEntity<K> response =
          restTemplate.exchange(
              builder.build().toUriString(), httpMethod, httpEntity, responseType);
      return response;
    } catch (NoDataFoundException e) {
      if (httpMethod.equals(HttpMethod.GET)) {
        return null;
      } else {
        throw e;
      }
    }
  }

  public void setInterceptor(ClientHttpRequestInterceptor logInterceptor) {
    restTemplate.setInterceptors(Collections.singletonList(logInterceptor));
  }
}

