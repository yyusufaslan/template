package com.template.rest;

import com.template.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/post")
public class Post {

  @Autowired
  PostService postService;
  @RequestMapping(
      method = RequestMethod.GET,
      value = "/")
  public Optional<com.template.Post> getById(@RequestParam("id") String id) {

    return postService.getPostById(id);
  }


}
