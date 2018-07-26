package com.example.oauth2demo.repository;

import com.example.oauth2demo.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Integer>{

    UserModel findByUserName(String userName);
}