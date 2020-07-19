/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itway.charity.dao.impl;

import com.itway.charity.dao.inter.PlacedGoodsDaoInter;
import com.itway.charity.entity.PlacedGoods;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author anarbaydamirov
 */
@Repository(value="placedGoodsDao")
public class PlacedGoodsDaoImpl implements PlacedGoodsDaoInter {

    @PersistenceContext
    EntityManager entityManager;
    
    @Override
    public List<PlacedGoods> getAll() {
        Query query = entityManager.createQuery("Select pg from PlacedGoods pg",PlacedGoods.class);
        List<PlacedGoods> placedGoodsList = query.getResultList();
        
        return placedGoodsList;
    }

    @Override
    public List<PlacedGoods> getNew() {
        Query query = entityManager.createQuery("select pg from PlacedGoods pg where pg.goodsStatus=0",PlacedGoods.class);
        List<PlacedGoods> placedGoodsList = query.getResultList();

        return placedGoodsList;
    }

    @Override
    public List<PlacedGoods> getClosed() {
        Query query = entityManager.createQuery("select pg from PlacedGoods pg where pg.goodsStatus=1",PlacedGoods.class);
        List<PlacedGoods> placedGoodsList = query.getResultList();

        return placedGoodsList;
    }

    @Override
    public PlacedGoods getById(int id) {
        PlacedGoods placedGoods = entityManager.find(PlacedGoods.class, id);
        return placedGoods;
    }

    @Override
    public Integer insert(PlacedGoods placedGoods) {
        try{
            entityManager.persist(placedGoods);
            entityManager.flush();
            return placedGoods.getId();
        }
        catch(Exception ex){
            return -1;
        }
    }

    @Override
    public Boolean update(PlacedGoods placedGoods) {
        try{
            entityManager.merge(placedGoods);
            return true;
        }
        catch(Exception ex){
            return false;
        }
    }

    @Override
    public Boolean delete(int id) {
        try{
            PlacedGoods placedGoods = entityManager.find(PlacedGoods.class, id);
            entityManager.remove(placedGoods);
            return true;
        }
        catch(Exception ex){
            return false;
        }
    }
    
}
