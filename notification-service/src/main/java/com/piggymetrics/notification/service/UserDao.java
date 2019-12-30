package com.piggymetrics.notification.service;

import com.template.apiservice.service.UserService;
import com.template.model.user.User;
import org.springframework.beans.factory.annotation.Autowired;

public class UserDao {

  UserService userService;

  public User getUserById() {
    return userService.getUserById("1");
  }

}
