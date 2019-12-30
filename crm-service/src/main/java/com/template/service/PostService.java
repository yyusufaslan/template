package com.template.service;

import com.template.Post;
import com.template.repository.PostRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Data
@Service
public class PostService{

  @Autowired
  PostRepository postRepository;

  public Optional<Post> getPostById(String id){
    return postRepository.findById(id);
  }


}
