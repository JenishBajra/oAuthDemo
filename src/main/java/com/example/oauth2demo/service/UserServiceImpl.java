package com.example.oauth2demo.service;

import com.example.oauth2demo.model.UserModel;
import com.example.oauth2demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;

@Service(value = "userService")
public class UserServiceImpl implements UserDetailsService, UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        UserModel user = userRepository.findByUserName(userName);
        if(user == null){
            throw  new UsernameNotFoundException("Invalid Username or password");
        }
        return new User(user.getUserName(), user.getPassword() , getAuthority());
    }

    private List getAuthority(){
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
    }

    @Override
    public UserModel saveUser(UserModel userModel) {
        return userRepository.save(userModel);
    }

    @Override
    public void deleteUser(int userId) {
        userRepository.delete(userId);
    }

    @Override
    public List<UserModel> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public UserModel getUserById(int userId) {
        return userRepository.findOne(userId);
    }
}