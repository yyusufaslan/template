package com.template.apiservice.util;

import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.Map;

public class TokenService {

  private String token;
  private RestTemplate restTemplate;
  private KeyCloakConfiguration keycloakConfiguration;

  public TokenService(HashMap<String, String> keycloakProperties) {
    this.restTemplate = new RestTemplate();
    this.keycloakConfiguration = new KeyCloakConfiguration(keycloakProperties);
  }

  public String getToken() {
    if (this.token == null) {
      refreshToken();
    }
    return token;
  }

  public String refreshToken() {
    String tokenUrl =
        keycloakConfiguration.getServerUrl()
            + "/realms/"
            + keycloakConfiguration.getRealm()
            + "/protocol/openid-connect/token";

    HttpHeaders httpHeaders = new HttpHeaders();
    httpHeaders.set("Content-Type", MediaType.APPLICATION_FORM_URLENCODED_VALUE);
    httpHeaders.set("Accept", MediaType.APPLICATION_JSON_UTF8_VALUE);

    MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
    map.add("client_id", keycloakConfiguration.getClientId());
    map.add("client_secret", keycloakConfiguration.getClientSecret());
    map.add("grant_type", keycloakConfiguration.getGrantType());
    if (keycloakConfiguration.getGrantType().equals("password")) {
      map.add("username", keycloakConfiguration.getUsername());
      map.add("password", keycloakConfiguration.getPassword());
    }

    HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity<>(map, httpHeaders);

    UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(tokenUrl);

    ResponseEntity<Map> response =
        restTemplate.exchange(builder.toUriString(), HttpMethod.POST, httpEntity, Map.class);

    Map resultMap = response.getBody();
    Object object = resultMap.get("access_token");
    setToken(object.toString());
    return getToken();
  }

  private void setToken(String token) {
    this.token = token;
  }
}
