/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itway.charity.service.impl;

import com.itway.charity.dao.inter.UsersDaoInter;
import com.itway.charity.entity.Users;

import java.util.List;

import com.itway.charity.service.inter.UsersServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author anarbaydamirov
 */
@Service(value = "usersService")
@Transactional
public class UsersServiceImpl implements UsersServiceInter {

    @Autowired
    @Qualifier("usersDao")
    private UsersDaoInter usersDaoInter;
    
    @Override
    public List<Users> getAll() {
        return usersDaoInter.getAll();
    }

    @Override
    public Users getById(int id) {
        return usersDaoInter.getById(id);
    }

    @Override
    public Users getByMailAndPassword(String mail, String password) {
        return usersDaoInter.getByMailAndPassword(mail,password);
    }

    @Override
    public Users getByMailPasswordAndKey(String mail, String password, String userKey) {
        return usersDaoInter.getByMailPasswordAndKey(mail,password,userKey);
    }

    @Override
    public Integer insert(Users users) {
        return usersDaoInter.insert(users);
    }

    @Override
    public Boolean update(Users users) {
        return usersDaoInter.update(users);
    }

    @Override
    public Boolean delete(int id) {
        return usersDaoInter.delete(id);
    }
    
}
