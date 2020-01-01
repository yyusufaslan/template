package com.template.postservice.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/post")
public class PostResource {


  @GetMapping(value = "/getUserById")
  public String getUserById(){
    return "user";
  }


}
