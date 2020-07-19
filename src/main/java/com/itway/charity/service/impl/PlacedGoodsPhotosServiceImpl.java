/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itway.charity.service.impl;

import com.itway.charity.dao.inter.PlacedGoodsPhotosDaoInter;
import com.itway.charity.entity.PlacedGoodsPhotos;

import java.util.List;

import com.itway.charity.service.inter.PlacedGoodsPhotosServiceInter;
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
public class PlacedGoodsPhotosServiceImpl implements PlacedGoodsPhotosServiceInter {

    @Autowired
    @Qualifier("placedGoodsPhotosDao")
    private PlacedGoodsPhotosDaoInter placedGoodsPhotosDaoInter;
    
    @Override
    public List<PlacedGoodsPhotos> getAll() {
        return placedGoodsPhotosDaoInter.getAll();
    }

    @Override
    public PlacedGoodsPhotos getById(int id) {
        return placedGoodsPhotosDaoInter.getById(id);
    }

    @Override
    public Integer insert(PlacedGoodsPhotos placedGoodsPhotos) {
        return placedGoodsPhotosDaoInter.insert(placedGoodsPhotos);
    }

    @Override
    public Boolean update(PlacedGoodsPhotos placedGoodsPhotos) {
        return placedGoodsPhotosDaoInter.update(placedGoodsPhotos);
    }

    @Override
    public Boolean delete(int id) {
        return placedGoodsPhotosDaoInter.delete(id);
    }
    
}
