/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itway.charity.service.impl;

import com.itway.charity.dao.inter.CrudDaoInter;
import com.itway.charity.entity.GoodsCategory;
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
@Service(value = "goodsCategoryService")
@Transactional
public class GoodsCategoryServiceImpl implements CrudServiceInter<GoodsCategory> {

    @Autowired
    @Qualifier("goodsCategoryDao")
    private CrudDaoInter<GoodsCategory> crudDaoInter;
    
    @Override
    public List<GoodsCategory> getAll() {
        return crudDaoInter.getAll();
    }

    @Override
    public GoodsCategory getById(int id) {
        return crudDaoInter.getById(id);
    }

    @Override
    public Integer insert(GoodsCategory goodsCategory) {
        return crudDaoInter.insert(goodsCategory);
    }

    @Override
    public Boolean update(GoodsCategory goodsCategory) {
        return crudDaoInter.update(goodsCategory);
    }

    @Override
    public Boolean delete(int id) {
        return crudDaoInter.delete(id);
    }
    
}
