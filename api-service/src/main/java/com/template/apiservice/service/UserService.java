package com.template.apiservice.service;

import com.template.apiservice.util.SecureRestClient;
import com.template.model.user.User;

public class UserService {

  SecureRestClient secureRestClient;
  String userServiceUrl;

  public UserService(String userServiceUrl) {
    this.userServiceUrl = userServiceUrl;
  }

  public User getUserById(String id){
    String url = userServiceUrl + "/getUserById" +id;
    return secureRestClient.secureGet(url,User.class);
  }





}
