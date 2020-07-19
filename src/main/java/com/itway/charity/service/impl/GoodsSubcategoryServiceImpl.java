/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itway.charity.service.impl;

import com.itway.charity.dao.inter.GoodsSubcategoryDaoInter;
import com.itway.charity.entity.GoodsSubcategory;

import java.util.List;

import com.itway.charity.service.inter.GoodsSubcategoryServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author anarbaydamirov
 */
@Service(value = "goodsSubcategoryService")
@Transactional
public class GoodsSubcategoryServiceImpl implements GoodsSubcategoryServiceInter {

    @Autowired
    @Qualifier("goodsSubcategoryDao")
    private GoodsSubcategoryDaoInter goodsSubcategoryDaoInter;
    
    @Override
    public List<GoodsSubcategory> getAll() {
        return goodsSubcategoryDaoInter.getAll();
    }

    @Override
    public GoodsSubcategory getById(int id) {
        return goodsSubcategoryDaoInter.getById(id);
    }

    @Override
    public Integer insert(GoodsSubcategory goodsSubcategory) {
        return goodsSubcategoryDaoInter.insert(goodsSubcategory);
    }

    @Override
    public Boolean update(GoodsSubcategory goodsSubcategory) {
        return goodsSubcategoryDaoInter.update(goodsSubcategory);
    }

    @Override
    public Boolean delete(int id) {
        return goodsSubcategoryDaoInter.delete(id);
    }
    
}
