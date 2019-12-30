package com.template.apiservice.util;

import com.template.apiservice.exception.CallServiceException;
import com.template.apiservice.exception.NoDataFoundException;
import com.template.apiservice.exception.UnauthorizedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RestClientExceptionHandler implements ResponseErrorHandler {

  @Override
  public boolean hasError(ClientHttpResponse response) throws IOException {
    if (response.getStatusCode().is5xxServerError()) {
      return true;
    } else if (response.getStatusCode().equals(HttpStatus.BAD_REQUEST)) {
      return true;
    } else if (response.getStatusCode().equals(HttpStatus.UNAUTHORIZED)) {
      return true;
    } else if (response.getStatusCode().equals(HttpStatus.OK)) {
      return false;
    } else if (response.getStatusCode().equals(HttpStatus.CREATED)) {
      return false;
    }
    return !response.getStatusCode().is2xxSuccessful();
  }

  @Override
  public void handleError(ClientHttpResponse response) throws IOException {
    String exceptionMessage = response.getStatusCode().toString() + " " + getResponseBody(response);
    if (response.getStatusCode().equals(HttpStatus.NOT_FOUND)) {
      throw new NoDataFoundException(exceptionMessage);
    } else if (response.getStatusCode().equals(HttpStatus.UNAUTHORIZED)) {
      throw new UnauthorizedException(exceptionMessage);
    } else {
      throw new CallServiceException(exceptionMessage);
    }
  }

  private String getResponseBody(ClientHttpResponse response) throws IOException {
    StringBuilder inputStringBuilder = new StringBuilder();
    BufferedReader bufferedReader =
        new BufferedReader(new InputStreamReader(response.getBody(), "UTF-8"));
    String line = bufferedReader.readLine();
    while (line != null) {
      inputStringBuilder.append(line);
      inputStringBuilder.append('\n');
      line = bufferedReader.readLine();
    }
    return inputStringBuilder.toString();
  }
}
