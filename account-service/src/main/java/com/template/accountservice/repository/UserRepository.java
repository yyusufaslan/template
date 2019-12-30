package com.template.accountservice.repository;

import com.template.accountservice.model.User;
import com.template.accountservice.model.UserStatus;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface UserRepository extends MongoRepository<User, UUID> {

  User findByIdAndStatusActive(UUID id);

  List<User> getUserByStatus(UserStatus userStatus);


}
