package com.example.oauth2demo.model;

import javax.persistence.*;

@Entity
@Table(name= "user")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="user_id")
    private int userId;

    @Column(name="user_name")
    private String userName;

    @Column(name="password")
    private String password;

    @Column(name="salary")
    private int salary;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}