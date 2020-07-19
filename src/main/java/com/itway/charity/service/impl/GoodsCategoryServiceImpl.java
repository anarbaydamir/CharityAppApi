/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itway.charity.service.impl;

import com.itway.charity.dao.inter.GoodsCategoryDaoInter;
import com.itway.charity.entity.GoodsCategory;

import java.util.List;

import com.itway.charity.service.inter.GoodsCategoryServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author anarbaydamirov
 */
@Service(value = "goodsCategoryService")
@Transactional
public class GoodsCategoryServiceImpl implements GoodsCategoryServiceInter {

    @Autowired
    @Qualifier("goodsCategoryDao")
    private GoodsCategoryDaoInter goodsCategoryDaoInter;
    
    @Override
    public List<GoodsCategory> getAll() {
        return goodsCategoryDaoInter.getAll();
    }

    @Override
    public GoodsCategory getById(int id) {
        return goodsCategoryDaoInter.getById(id);
    }

    @Override
    public Integer insert(GoodsCategory goodsCategory) {
        return goodsCategoryDaoInter.insert(goodsCategory);
    }

    @Override
    public Boolean update(GoodsCategory goodsCategory) {
        return goodsCategoryDaoInter.update(goodsCategory);
    }

    @Override
    public Boolean delete(int id) {
        return goodsCategoryDaoInter.delete(id);
    }
    
}
