package com.template.apiservice.util;

import lombok.Data;

import java.util.HashMap;

@Data
public class KeyCloakConfiguration {
  private String realm;
  private String clientId;
  private String serverUrl;
  private String username;
  private String password;
  private String clientSecret;
  private String grantType;

  public KeyCloakConfiguration(HashMap<String, String> properties) {
    this.realm = properties.get("realm");
    this.serverUrl = properties.get("server");
    this.clientSecret = properties.get("clientSecret");
    this.clientId = properties.get("clientId");
    this.grantType = properties.get("grantType");
    this.username = properties.get("username");
    this.password = properties.get("password");
  }
}
