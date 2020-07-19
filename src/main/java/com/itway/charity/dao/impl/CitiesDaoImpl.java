/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itway.charity.dao.impl;

import com.itway.charity.dao.inter.CitiesDaoInter;
import com.itway.charity.entity.Cities;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author anarbaydamirov
 */
@Repository(value="citiesDao")
public class CitiesDaoImpl implements CitiesDaoInter {

    @PersistenceContext
    EntityManager entityManager;
    
    @Override
    public List<Cities> getAll() {
        Query query = entityManager.createQuery("Select c from Cities c", Cities.class);
        List<Cities> citiesList = query.getResultList();
        
        return citiesList;
    }

    @Override
    public Cities getById(int id) {
        Cities cities = entityManager.find(Cities.class, id);
        return cities;
    }

    @Override
    public Integer insert(Cities cities) {
        try{
            entityManager.persist(cities);
            entityManager.flush();
            return cities.getId();
        }
            catch(Exception ex){
            return -1;
        }
    }

    @Override
    public Boolean update(Cities cities) {
       try{
           entityManager.merge(cities); 
           return true;
       }
       catch(Exception ex){
           return false;
       }
       
    }

    @Override
    public Boolean delete(int id) {
        try{
            Cities cities = entityManager.find(Cities.class, id);
            entityManager.remove(cities);
            return true;
        }
        catch(Exception ex){
            return false;
        }
    }
    
}
