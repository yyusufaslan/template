package com.template.accountservice.repository;

import com.template.accountservice.model.User;
import com.template.accountservice.model.UserStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends CrudRepository<User, UUID> {

  User findByIdAndStatusActive(UUID id);

  List<User> getUserByStatus(UserStatus userStatus);

  User findById(String id);

  void deleteById(UUID id);

}
