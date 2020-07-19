/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itway.charity.service.impl;

import com.itway.charity.dao.inter.CitiesDaoInter;
import com.itway.charity.entity.Cities;

import java.util.List;

import com.itway.charity.service.inter.CitiesServiceInter;
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
public class CitiesServiceImpl implements CitiesServiceInter {

    @Autowired
    @Qualifier("citiesDao")
    private CitiesDaoInter citiesDaoInter;
    
    @Override
    public List<Cities> getAll() {
        return (List)citiesDaoInter.getAll();
    }

    @Override
    public Cities getById(int id) {
        return citiesDaoInter.getById(id);
    }

    @Override
    public Integer insert(Cities cities) {
        return citiesDaoInter.insert(cities);
    }

    @Override
    public Boolean update(Cities cities) {
        return citiesDaoInter.update(cities);
    }

    @Override
    public Boolean delete(int id) {
        return citiesDaoInter.delete(id);
    }
    
}
