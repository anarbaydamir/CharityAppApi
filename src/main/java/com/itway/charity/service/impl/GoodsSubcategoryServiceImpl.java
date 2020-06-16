/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itway.charity.service.impl;

import com.itway.charity.dao.inter.CrudDaoInter;
import com.itway.charity.entity.GoodsSubcategory;
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
@Service(value = "goodsSubcategoryService")
@Transactional
public class GoodsSubcategoryServiceImpl implements CrudServiceInter<GoodsSubcategory> {

    @Autowired
    @Qualifier("goodsSubcategoryDao")
    private CrudDaoInter<GoodsSubcategory> crudDaoInter;
    
    @Override
    public List<GoodsSubcategory> getAll() {
        return crudDaoInter.getAll();
    }

    @Override
    public GoodsSubcategory getById(int id) {
        return crudDaoInter.getById(id);
    }

    @Override
    public Integer insert(GoodsSubcategory goodsSubcategory) {
        return crudDaoInter.insert(goodsSubcategory);
    }

    @Override
    public Boolean update(GoodsSubcategory goodsSubcategory) {
        return crudDaoInter.update(goodsSubcategory);
    }

    @Override
    public Boolean delete(int id) {
        return crudDaoInter.delete(id);
    }
    
}
