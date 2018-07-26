package com.example.oauth2demo.controller;

import com.example.oauth2demo.model.UserModel;
import com.example.oauth2demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value= "/create", method = RequestMethod.POST)
    public UserModel saveUser(@RequestBody UserModel userModel){
        return userService.saveUser(userModel);
    }

    @RequestMapping(value= "/getAll", method = RequestMethod.GET)
    public List listUsers(){
        return userService.getAllUser();
    }

    @RequestMapping(value= "/delete/{id}", method = RequestMethod.DELETE)
    public String deleteUsers(@RequestParam int id){
        userService.deleteUser(id);
        return "success";
    }


}