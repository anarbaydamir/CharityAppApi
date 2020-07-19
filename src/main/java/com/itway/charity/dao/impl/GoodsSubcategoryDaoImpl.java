/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itway.charity.dao.impl;

import com.itway.charity.dao.inter.GoodsSubcategoryDaoInter;
import com.itway.charity.entity.GoodsSubcategory;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author anarbaydamirov
 */
@Repository(value="goodsSubcategoryDao")
public class GoodsSubcategoryDaoImpl implements GoodsSubcategoryDaoInter {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<GoodsSubcategory> getAll() {
        Query query = entityManager.createQuery("Select gsc from GoodsSubcategory gsc",GoodsSubcategoryDaoImpl.class);
        List<GoodsSubcategory> goodsSubcategoryList = query.getResultList();
        return goodsSubcategoryList;
    }

    @Override
    public GoodsSubcategory getById(int id) {
        GoodsSubcategory goodsSubcategory = entityManager.find(GoodsSubcategory.class, id);
        return goodsSubcategory;
    }

    @Override
    public Integer insert(GoodsSubcategory goodsSubcategory) {
        try{
            entityManager.persist(goodsSubcategory);
            entityManager.flush();
            
            return goodsSubcategory.getId();
        }
        catch(Exception ex){
            return -1;
        }
    }

    @Override
    public Boolean update(GoodsSubcategory goodsSubcategory) {
        try{
            entityManager.merge(goodsSubcategory);
            return true;
        }
        catch(Exception ex){
           return false; 
        }
    }

    @Override
    public Boolean delete(int id) {
        try{
            GoodsSubcategory goodsSubcategory = entityManager.find(GoodsSubcategory.class, id);
            entityManager.remove(goodsSubcategory);
            return true;
        }
        catch(Exception ex){
            return false;
        }
    }      
}
