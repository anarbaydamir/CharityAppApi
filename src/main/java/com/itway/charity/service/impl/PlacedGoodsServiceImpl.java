/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itway.charity.service.impl;

import com.itway.charity.dao.inter.CrudDaoInter;
import com.itway.charity.entity.PlacedGoods;
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
@Service(value = "placedGoodsService")
@Transactional
public class PlacedGoodsServiceImpl implements CrudServiceInter<PlacedGoods> {

    @Autowired
    @Qualifier("placedGoodsDao")
    private CrudDaoInter<PlacedGoods> crudDaoInter;
    
    @Override
    public List<PlacedGoods> getAll() {
        return crudDaoInter.getAll();
    }

    @Override
    public PlacedGoods getById(int id) {
        return crudDaoInter.getById(id);
    }

    @Override
    public Integer insert(PlacedGoods placedGoods) {
        return crudDaoInter.insert(placedGoods);
    }

    @Override
    public Boolean update(PlacedGoods placedGoods) {
        return crudDaoInter.update(placedGoods);
    }

    @Override
    public Boolean delete(int id) {
        return crudDaoInter.delete(id);
    }
    
}
