/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itway.charity.dao.impl;

import com.itway.charity.dao.inter.GoodsCategoryDaoInter;
import com.itway.charity.entity.GoodsCategory;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author anarbaydamirov
 */
@Repository(value="goodsCategoryDao")
public class GoodsCategoryDaoImpl implements GoodsCategoryDaoInter {
    
    @PersistenceContext
    EntityManager entityManager;
    
    @Override
    public List<GoodsCategory> getAll() {
        Query query = entityManager.createQuery("select gc from GoodsCategory gc",GoodsCategory.class);
        List<GoodsCategory> goodsCategoryList = query.getResultList();
        
        return goodsCategoryList;
    }

    @Override
    public GoodsCategory getById(int id) {
        GoodsCategory goodsCategory = entityManager.find(GoodsCategory.class, id);
        return goodsCategory;
    }

    @Override
    public Integer insert(GoodsCategory goodsCategory) {
        try{
            entityManager.persist(goodsCategory);
            entityManager.flush();
            return goodsCategory.getId();
        }
        catch(Exception ex){
            return -1;
        }
    }

    @Override
    public Boolean update(GoodsCategory goodsCategory) {
        try{
            entityManager.merge(goodsCategory);
            return true;
        }
        catch(Exception ex){
            return false;
        }
    }

    @Override
    public Boolean delete(int id) {
        try{
            GoodsCategory goodsCategory = entityManager.find(GoodsCategory.class, id);
            entityManager.remove(goodsCategory);
            return true;
        }
        catch(Exception ex){
            return false;
        }
    }
    
}
