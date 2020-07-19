package com.itway.charity.dto;

import com.itway.charity.entity.PlacedGoods;
import com.itway.charity.entity.SearchingGoods;
import com.itway.charity.entity.Users;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UsersDto {
    private Integer id;
    private String name;
    private String mail;
    private String password;
    private Date loginDate;
    private String phoneNumber;
    private Short userActive;
    private String userKey;
    private String userToken;

    public UsersDto() {
    }

    public UsersDto (Users users){
        this.id=users.getId();
        this.name=users.getName();
        this.mail=users.getMail();
        this.password=users.getPassword();
        this.loginDate=users.getLoginDate();
        this.phoneNumber=users.getPhoneNumber();
        this.userActive=users.getUserActive();
        this.userKey=users.getUserKey();
        this.userToken=users.getUserToken();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Short getUserActive() {
        return userActive;
    }

    public void setUserActive(Short userActive) {
        this.userActive = userActive;
    }

    public String getUserKey() {
        return userKey;
    }

    public void setUserKey(String userKey) {
        this.userKey = userKey;
    }

    public String getUserToken() {
        return userToken;
    }

    public void setUserToken(String userToken) {
        this.userToken = userToken;
    }
}
