package com.itway.charity.service.inter;

import com.itway.charity.entity.Users;
import org.apache.catalina.User;

import java.util.List;

public interface UsersServiceInter {
    List<Users> getAll();

    Users getById(int id);

    Users getByMailAndPassword(String mail,String password);

    Users getByMailPasswordAndKey(String mail,String password,String userKey);

    Integer insert(Users users);

    Boolean update(Users users);

    Boolean delete(int id);
}
