package com.example.oauth2demo.service;

import com.example.oauth2demo.model.UserModel;
import com.example.oauth2demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.OAuth2Request;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;

@Service(value = "userService")
public class UserServiceImpl implements UserDetailsService, UserService {

    @Autowired
    UserRepository userRepository;

    /*@Autowired
    OAuth2Authentication oAuth2Authentication;*/

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
       /* OAuth2Request request = oAuth2Authentication.getOAuth2Request();
        System.out.println("The scope is : "+ request.getScope());*/

        UserModel user = userRepository.findByUserName(userName);
        if(user == null){
            throw  new UsernameNotFoundException("Invalid Username or password");
        }
        System.out.println("The userName is "+userName);
        System.out.println("The authoritires are "+getAuthority());
        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), getAuthority());
    }

    private List getAuthority(){
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
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