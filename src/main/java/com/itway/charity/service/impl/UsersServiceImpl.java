/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itway.charity.service.impl;

import com.itway.charity.dao.inter.CrudDaoInter;
import com.itway.charity.entity.Users;
import com.itway.charity.service.inter.CrudServiceInter;
import java.util.List;
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
public class UsersServiceImpl implements CrudServiceInter<Users> {

    @Autowired
    @Qualifier("usersDao")
    private CrudDaoInter<Users> crudDaoInter;
    
    @Override
    public List<Users> getAll() {
        return crudDaoInter.getAll();
    }

    @Override
    public Users getById(int id) {
        return crudDaoInter.getById(id);
    }

    @Override
    public Integer insert(Users users) {
        return crudDaoInter.insert(users);
    }

    @Override
    public Boolean update(Users users) {
        return crudDaoInter.update(users);
    }

    @Override
    public Boolean delete(int id) {
        return crudDaoInter.delete(id);
    }
    
}
