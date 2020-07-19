package com.itway.charity.dao.inter;

import com.itway.charity.entity.Users;

import java.util.List;

public interface UsersDaoInter {
    List<Users> getAll();

    Users getById(int id);

    Users getByMailAndPassword(String mail,String password);

    Users getByMailPasswordAndKey(String mail,String password,String userKey);

    Integer insert(Users users);

    Boolean update(Users users);

    Boolean delete(int id);
}
