/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itway.charity.service.impl;

import com.itway.charity.dao.inter.PlacedGoodsDaoInter;
import com.itway.charity.entity.PlacedGoods;

import java.util.List;

import com.itway.charity.service.inter.PlacedGoodsServiceInter;
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
public class PlacedGoodsServiceImpl implements PlacedGoodsServiceInter {

    @Autowired
    @Qualifier("placedGoodsDao")
    private PlacedGoodsDaoInter placedGoodsDaoInter;
    
    @Override
    public List<PlacedGoods> getAll() {
        return placedGoodsDaoInter.getAll();
    }

    @Override
    public List<PlacedGoods> getNew() {
        return placedGoodsDaoInter.getNew();
    }

    @Override
    public List<PlacedGoods> getClosed() {
        return placedGoodsDaoInter.getClosed();
    }

    @Override
    public PlacedGoods getById(int id) {
        return placedGoodsDaoInter.getById(id);
    }

    @Override
    public Integer insert(PlacedGoods placedGoods) {
        return placedGoodsDaoInter.insert(placedGoods);
    }

    @Override
    public Boolean update(PlacedGoods placedGoods) {
        return placedGoodsDaoInter.update(placedGoods);
    }

    @Override
    public Boolean delete(int id) {
        return placedGoodsDaoInter.delete(id);
    }
    
}
