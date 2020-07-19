package com.itway.charity.dao.impl;

import com.itway.charity.dao.inter.UsersDaoInter;
import com.itway.charity.entity.Users;
import org.apache.catalina.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository(value = "usersDao")
public class UsersDaoImpl implements UsersDaoInter {

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
    public Users getByMailAndPassword(String mail, String password) {
        try{
            TypedQuery<Users> query = entityManager.createQuery("select u from Users u where u.mail=:mail and u.password=:password",Users.class);
            query.setParameter("mail",mail);
            query.setParameter("password",password);
            Users users=query.getSingleResult();

            return users;
        }
        catch (Exception ex){
            return null;
        }
    }

    @Override
    public Users getByMailPasswordAndKey(String mail, String password, String userKey) {
        try{
            TypedQuery<Users> query = entityManager.createQuery("select u from Users u where u.mail=:mail and u.password=:password and u.userKey=:userKey",Users.class);
            query.setParameter("mail",mail);
            query.setParameter("password",password);
            query.setParameter("userKey",userKey);
            Users users = query.getSingleResult();

            return users;
        }
        catch (Exception ex){
            return null;
        }
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
