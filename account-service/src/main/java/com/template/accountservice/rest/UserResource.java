package com.template.accountservice.rest;

import com.template.accountservice.model.User;
import com.template.accountservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping("/rest/user")
public class UserResource {

  @Autowired
  UserService userService;

  @GetMapping(value = "/getUserById")
  public User getUserById(@PathVariable("userId")UUID id){
    return userService.getUserById(id);
  }

  @GetMapping(value = "/getActiveUsers")
  public List<User> getActiveUsers(@PathVariable("userId")UUID id){
    return userService.getActiveUsers();
  }

}
