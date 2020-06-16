package com.itway.charity.dao.impl;

import com.itway.charity.dao.inter.CrudDaoInter;
import com.itway.charity.entity.Users;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository(value = "usersDao")
public class UsersDaoImpl implements CrudDaoInter<Users> {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Users> getAll() {
        Query query = entityManager.createQuery("select u from Users u",Users.class);
        List<Users> usersList = query.getResultList();

        return usersList;
    }

    @Override
    public Users getById(int id) {
        Users users = entityManager.find(Users.class,id);
        return users;
    }

    @Override
    public Integer insert(Users users) {
        try{
            entityManager.persist(users);
            entityManager.flush();
            return users.getId();
        }
        catch (Exception ex){
            return -1;
        }
    }

    @Override
    public Boolean update(Users users) {
        try{
            entityManager.merge(users);
            return true;
        }
        catch (Exception ex){
            return false;
        }
    }

    @Override
    public Boolean delete(int id) {
        try{
            Users users = entityManager.find(Users.class,id);
            entityManager.remove(users);
            return true;
        }
        catch (Exception ex){
            return false;
        }
    }
}
