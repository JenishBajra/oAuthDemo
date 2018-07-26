package com.example.oauth2demo.service;

import com.example.oauth2demo.model.UserModel;

import java.util.List;

public interface UserService {

    UserModel saveUser(UserModel userModel);

    void deleteUser(int userId);

    List<UserModel> getAllUser();

    UserModel getUserById(int userId);
}