package com.template.accountservice.service;

import com.template.accountservice.model.User;
import com.template.accountservice.model.UserStatus;
import com.template.accountservice.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class UserService{

  @Autowired UserRepository userRepository;

  public List<User> getActiveUsers(){
    return userRepository.getUserByStatus(UserStatus.ACTIVE);
  }

  public User getUserById(UUID id){
    return userRepository.findByIdAndStatusActive(id);
  }

}
