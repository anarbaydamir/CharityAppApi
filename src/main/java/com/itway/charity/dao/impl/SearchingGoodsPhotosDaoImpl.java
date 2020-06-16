/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itway.charity.dao.impl;

import com.itway.charity.dao.inter.CrudDaoInter;
import com.itway.charity.entity.SearchingGoods;
import com.itway.charity.entity.SearchingGoodsPhotos;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author anarbaydamirov
 */
@Repository(value="searchingGoodsPhotosDao")
public class SearchingGoodsPhotosDaoImpl implements CrudDaoInter<SearchingGoodsPhotos>{

    @PersistenceContext
    EntityManager entityManager;
    
    @Override
    public List<SearchingGoodsPhotos> getAll() {
        Query query = entityManager.createQuery("Select s from SearchingGoodsPhotos s",SearchingGoodsPhotos.class);
        List<SearchingGoodsPhotos> searchingGoodsPhotosList = query.getResultList();
        return searchingGoodsPhotosList;
    }

    @Override
    public SearchingGoodsPhotos getById(int id) {
        SearchingGoodsPhotos searchingGoodsPhotos = entityManager.find(SearchingGoodsPhotos.class, id);
        return searchingGoodsPhotos;
    }

    @Override
    public Integer insert(SearchingGoodsPhotos searchingGoodsPhotos) {
        try{
            entityManager.persist(searchingGoodsPhotos);
            entityManager.flush();
            return searchingGoodsPhotos.getId();
        }
        catch(Exception ex){
            return -1;
        }
    }

    @Override
    public Boolean update(SearchingGoodsPhotos searchingGoodsPhotos) {
        try{
            entityManager.merge(searchingGoodsPhotos);
            return true;
        }
        catch(Exception ex){
            return false;
        }
    }

    @Override
    public Boolean delete(int id) {
        try{
            SearchingGoodsPhotos searchingGoodsPhotos = entityManager.find(SearchingGoodsPhotos.class,id);
            entityManager.remove(searchingGoodsPhotos);
            return true;
        }
        catch (Exception ex){
            return false;
        }
    }
    
}
