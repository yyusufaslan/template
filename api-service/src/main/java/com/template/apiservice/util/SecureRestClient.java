package com.template.apiservice.util;


import java.util.HashMap;
import java.util.Map;

import com.template.apiservice.exception.CallServiceException;
import com.template.apiservice.exception.UnauthorizedException;
import lombok.Data;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;


@Data
public class SecureRestClient extends RestClient {
  RestTemplate restTemplate;
  TokenService tokenService;
  HashMap<String, String> keyCloakProperties;
  RestClientExceptionHandler errorHandler;

  public SecureRestClient(HashMap<String, String> keyCloakProperties) {
    this.keyCloakProperties = keyCloakProperties;
    this.tokenService = new TokenService(keyCloakProperties);
    this.errorHandler = new RestClientExceptionHandler();
    this.restTemplate = new RestTemplate();
    this.restTemplate.setErrorHandler(errorHandler);

    HttpComponentsClientHttpRequestFactory requestFactory =
        new HttpComponentsClientHttpRequestFactory();
    requestFactory.setConnectTimeout(1000000);
    requestFactory.setReadTimeout(1000000);
    this.restTemplate.setRequestFactory(requestFactory);
  }

  /** puts keycloak token into HttpHeaders */
  public <T, K> K securePost(String url, T body, Class<K> clazz) {
    return secureMethod(url, body, clazz, HttpMethod.POST);
  }

  /** puts keycloak token into HttpHeaders */
  public <T, K> K securePatch(String url, T body, Class<K> clazz) {
    return secureMethod(url, body, clazz, HttpMethod.PATCH);
  }

  private <T> HttpEntity<T> getHttpEntity(T body) {
    String token = tokenService.getToken();
    HttpHeaders httpHeaders = new HttpHeaders();
    httpHeaders.set("Content-Type", MediaType.APPLICATION_JSON_UTF8_VALUE);
    httpHeaders.set("Accept", MediaType.APPLICATION_JSON_UTF8_VALUE);
    httpHeaders.set("Authorization", "bearer " + token);
    return new HttpEntity<>(body, httpHeaders);
  }

  /** puts keycloak token into HttpHeaders */
  public <T, K> K securePut(String url, T body, Class<K> clazz) {
    return secureMethod(url, body, clazz, HttpMethod.PUT);
  }

  /** puts keycloak token into HttpHeaders */
  public <T, K> K secureDelete(String url, T body, Class<K> clazz) {
    return secureMethod(url, body, clazz, HttpMethod.DELETE);
  }

  public <T, K> K secureMethod(String url, T body, Class<K> clazz, HttpMethod httpMethod) {
    HttpHeaders httpHeaders = prepareSecureHeaders();
    HttpEntity<T> httpEntity = new HttpEntity<>(body, httpHeaders);
    UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url);
    ResponseEntity<K> response;

    try {
      response = exchange(clazz, httpEntity, builder, httpMethod);
      if (response == null) return null;
      // GET request'i sonucunda kayıt gelmezse 404 gelmeli ve null dönülmeli, POST'TA hata
      // almalıyız
      if (httpMethod.equals(HttpMethod.GET) && response.getStatusCode() == HttpStatus.NOT_FOUND) {
        return null;
      }
    } catch (UnauthorizedException une) {
      String token = tokenService.refreshToken();
      httpHeaders.set("Authorization", "bearer " + token);
      httpEntity = new HttpEntity<>(body, httpHeaders);
      response = exchange(clazz, httpEntity, builder, httpMethod);
    } catch (Exception e) {
      // log.error("Unsuccessful service call. URL: " + url, e);
      throw new CallServiceException("Can not call " + url + ".Reason " + e.toString());
    }
    return response.getBody();
  }

  public <T, K> K secureMethod(
      String url, T body, ParameterizedTypeReference<K> responseType, HttpMethod httpMethod) {
    HttpHeaders httpHeaders = prepareSecureHeaders();
    HttpEntity<T> httpEntity = new HttpEntity<>(body, httpHeaders);
    UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url);
    ResponseEntity<K> response;

    try {
      response = exchange(responseType, httpEntity, builder, httpMethod);
      if (response == null) return null;
      // GET request'i sonucunda kayıt gelmezse 404 gelmeli ve null dönülmeli, POST'TA hata
      // almalıyız
      if (httpMethod.equals(HttpMethod.GET) && response.getStatusCode() == HttpStatus.NOT_FOUND) {
        return null;
      }
    } catch (UnauthorizedException une) {
      String token = tokenService.refreshToken();
      httpHeaders.set("Authorization", "bearer " + token);
      httpEntity = new HttpEntity<>(body, httpHeaders);
      response = exchange(responseType, httpEntity, builder, httpMethod);
    } catch (Exception e) {
      // log.error("Unsuccessful service call. URL: " + url, e);
      throw new CallServiceException("Can not call " + url + ".Reason " + e.toString());
    }
    return response.getBody();
  }

  public <K> K secureGet(String url, Class<K> responseType, Map<String, String> queryParams) {
    HttpMethod httpMethod = HttpMethod.GET;
    HttpHeaders httpHeaders = prepareSecureHeaders();
    HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<>(httpHeaders);

    UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url);

    if (!CollectionUtils.isEmpty(queryParams)) {
      for (String key : queryParams.keySet()) {
        builder.queryParam(key, queryParams.get(key));
      }
    }

    ResponseEntity<K> response;
    try {
      response = exchange(responseType, httpEntity, builder, httpMethod);
    } catch (UnauthorizedException une) {
      String token = tokenService.refreshToken();
      httpHeaders.set("Authorization", "bearer " + token);
      httpEntity = new HttpEntity<>(httpHeaders);
      response = exchange(responseType, httpEntity, builder, httpMethod);
    }
    if (response == null) {
      return null;
    }
    // GET request'i sonucunda kayıt gelmezse 404 gelmeli ve null dönülmeli
    if (response.getStatusCode() == HttpStatus.NOT_FOUND) {
      return null;
    }

    return response.getBody();
  }

  public <K> K secureGet(
      String url, ParameterizedTypeReference<K> responseType, Map<String, String> queryParams) {
    HttpMethod httpMethod = HttpMethod.GET;
    HttpHeaders httpHeaders = prepareSecureHeaders();
    HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<>(httpHeaders);

    UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url);

    if (!CollectionUtils.isEmpty(queryParams)) {
      for (String key : queryParams.keySet()) {
        builder.queryParam(key, queryParams.get(key));
      }
    }

    ResponseEntity<K> response;
    try {
      response = exchange(responseType, httpEntity, builder, httpMethod);
    } catch (UnauthorizedException une) {
      String token = tokenService.refreshToken();
      httpHeaders.set("Authorization", "bearer " + token);
      httpEntity = new HttpEntity<>(httpHeaders);
      response = exchange(responseType, httpEntity, builder, httpMethod);
    }
    if (response == null) {
      return null;
    }
    // GET request'i sonucunda kayıt gelmezse 404 gelmeli ve null dönülmeli
    if (response.getStatusCode() == HttpStatus.NOT_FOUND) {
      return null;
    }

    return response.getBody();
  }

  public <K> K secureGet(String url, Class<K> responseType) {
    HttpMethod httpMethod = HttpMethod.GET;
    HttpHeaders httpHeaders = prepareSecureHeaders();
    HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<>(httpHeaders);

    UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url);

    ResponseEntity<K> response = null;
    try {
      response = exchange(responseType, httpEntity, builder, httpMethod);
    } catch (UnauthorizedException une) {
      String token = tokenService.refreshToken();
      httpHeaders.set("Authorization", "bearer " + token);
      httpEntity = new HttpEntity<>(httpHeaders);
      response = exchange(responseType, httpEntity, builder, httpMethod);
    }

    if (response == null) {
      return null;
    }
    // GET request'i sonucunda kayıt gelmezse 404 gelmeli ve null dönülmeli
    if (response.getStatusCode() == HttpStatus.NOT_FOUND) {
      return null;
    }
    return response.getBody();
  }

  private HttpHeaders prepareSecureHeaders() {
    String token = tokenService.getToken();
    HttpHeaders httpHeaders = new HttpHeaders();
    httpHeaders.set("Content-Type", MediaType.APPLICATION_JSON_UTF8_VALUE);
    httpHeaders.set("Accept", MediaType.APPLICATION_JSON_UTF8_VALUE);
    httpHeaders.set("Authorization", "bearer " + token);
    return httpHeaders;
  }
}

