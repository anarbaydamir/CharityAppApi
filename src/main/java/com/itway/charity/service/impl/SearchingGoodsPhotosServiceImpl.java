/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itway.charity.service.impl;

import com.itway.charity.dao.inter.SearchingGoodsPhotosDaoInter;
import com.itway.charity.entity.SearchingGoodsPhotos;

import java.util.List;

import com.itway.charity.service.inter.SearchingGoodsPhotosServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author anarbaydamirov
 */
@Service
@Transactional
public class SearchingGoodsPhotosServiceImpl implements SearchingGoodsPhotosServiceInter {

    @Autowired
    @Qualifier("searchingGoodsPhotosDao")
    private SearchingGoodsPhotosDaoInter searchingGoodsPhotosDaoInter;
    
    @Override
    public List<SearchingGoodsPhotos> getAll() {
        return searchingGoodsPhotosDaoInter.getAll();
    }

    @Override
    public SearchingGoodsPhotos getById(int id) {
        return searchingGoodsPhotosDaoInter.getById(id);
    }

    @Override
    public Integer insert(SearchingGoodsPhotos searchingGoodsPhotos) {
        return searchingGoodsPhotosDaoInter.insert(searchingGoodsPhotos);
    }

    @Override
    public Boolean update(SearchingGoodsPhotos searchingGoodsPhotos) {
        return searchingGoodsPhotosDaoInter.update(searchingGoodsPhotos);
    }

    @Override
    public Boolean delete(int id) {
        return searchingGoodsPhotosDaoInter.delete(id);
    }
    
}
