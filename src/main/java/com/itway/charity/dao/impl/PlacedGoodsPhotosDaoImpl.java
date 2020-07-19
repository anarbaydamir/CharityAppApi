/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itway.charity.dao.impl;

import com.itway.charity.dao.inter.PlacedGoodsPhotosDaoInter;
import com.itway.charity.entity.PlacedGoodsPhotos;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author anarbaydamirov
 */
@Repository(value="placedGoodsPhotosDao")
public class PlacedGoodsPhotosDaoImpl implements PlacedGoodsPhotosDaoInter {

    @PersistenceContext
    EntityManager entityManager;
    
    @Override
    public List<PlacedGoodsPhotos> getAll() {
        Query query = entityManager.createQuery("Select pgp from PlacedGoodsPhotos pgp",PlacedGoodsPhotos.class);
        List<PlacedGoodsPhotos> placedGoodsPhotosList = query.getResultList();
        
        return placedGoodsPhotosList;
    }

    @Override
    public PlacedGoodsPhotos getById(int id) {
        PlacedGoodsPhotos placedGoodsPhotos = entityManager.find(PlacedGoodsPhotos.class, id);
        return placedGoodsPhotos;
    }

    @Override
    public Integer insert(PlacedGoodsPhotos placedGoodsPhotos) {
        try{
            entityManager.persist(placedGoodsPhotos);
            entityManager.flush();
            return placedGoodsPhotos.getId();
        }
        catch(Exception ex){
            return -1;
        }
    }

    @Override
    public Boolean update(PlacedGoodsPhotos placedGoodsPhotos) {
        try{
            entityManager.merge(placedGoodsPhotos);
            return true;
        }
        catch(Exception ex){
            return false;
        }
    }

    @Override
    public Boolean delete(int id) {
        try{
            PlacedGoodsPhotos placedGoodsPhotos = entityManager.find(PlacedGoodsPhotos.class, id);
            entityManager.remove(placedGoodsPhotos);
            return true;
        }
        catch(Exception ex){
            return false;
        }
    }
    
}
