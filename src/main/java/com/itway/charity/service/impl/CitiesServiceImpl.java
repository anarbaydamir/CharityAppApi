/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itway.charity.service.impl;

import com.itway.charity.dao.inter.CrudDaoInter;
import com.itway.charity.entity.Cities;
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
@Service(value = "citiesService")
@Transactional
public class CitiesServiceImpl implements CrudServiceInter<Cities>{

    @Autowired
    @Qualifier("citiesDao")
    private CrudDaoInter<Cities> crudDaoInter;
    
    @Override
    public List<Cities> getAll() {
        return (List)crudDaoInter.getAll();
    }

    @Override
    public Cities getById(int id) {
        return crudDaoInter.getById(id);
    }

    @Override
    public Integer insert(Cities cities) {
        return crudDaoInter.insert(cities);
    }

    @Override
    public Boolean update(Cities cities) {
        return crudDaoInter.update(cities);
    }

    @Override
    public Boolean delete(int id) {
        return crudDaoInter.delete(id);
    }
    
}
