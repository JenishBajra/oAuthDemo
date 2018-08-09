package com.example.oauth2demo.controller;

import com.example.oauth2demo.model.UserModel;
import com.example.oauth2demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @Autowired
    ConsumerTokenServices tokenServices;

    @RequestMapping(value= "/create", method = RequestMethod.POST)
    public UserModel saveUser(@RequestBody UserModel userModel){
        userModel.setPassword(passwordEncoder.encode(userModel.getPassword()));
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


    @RequestMapping(value = "/logout/{tokenId}", method = RequestMethod.POST)
    public String revokeToken(@PathVariable String tokenId){
        tokenServices.revokeToken(tokenId);
        return tokenId;
    }




}