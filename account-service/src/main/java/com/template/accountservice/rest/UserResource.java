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

  @GetMapping(value = "/getActiveUserById")
  public User getActiveUserById(@PathVariable("userId")UUID id){
    return userService.getActiveUserById(id);
  }

  @GetMapping(value = "/getActiveUsers")
  public List<User> getActiveUsers(@PathVariable("userId")UUID id){
    return userService.getActiveUsers();
  }

  @PostMapping(value = "/update-user")
  public User updateUserProfile(User user){
    return userService.updateUser(user);
  }

  @PostMapping(value = "/delete-user")
  public void deleteUser(User user){
    userService.deleteUser(user.id);
  }



}
