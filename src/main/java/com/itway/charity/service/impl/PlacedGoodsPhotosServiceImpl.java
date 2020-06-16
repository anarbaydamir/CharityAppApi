/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itway.charity.service.impl;

import com.itway.charity.dao.inter.CrudDaoInter;
import com.itway.charity.entity.PlacedGoodsPhotos;
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
@Service(value = "placedGoodsPhotosService")
@Transactional
public class PlacedGoodsPhotosServiceImpl implements CrudServiceInter<PlacedGoodsPhotos> {

    @Autowired
    @Qualifier("placedGoodsPhotosDao")
    private CrudDaoInter<PlacedGoodsPhotos> crudDaoInter;
    
    @Override
    public List<PlacedGoodsPhotos> getAll() {
        return crudDaoInter.getAll();
    }

    @Override
    public PlacedGoodsPhotos getById(int id) {
        return crudDaoInter.getById(id);
    }

    @Override
    public Integer insert(PlacedGoodsPhotos placedGoodsPhotos) {
        return crudDaoInter.insert(placedGoodsPhotos);
    }

    @Override
    public Boolean update(PlacedGoodsPhotos placedGoodsPhotos) {
        return crudDaoInter.update(placedGoodsPhotos);
    }

    @Override
    public Boolean delete(int id) {
        return crudDaoInter.delete(id);
    }
    
}
