/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itway.charity.service.impl;

import com.itway.charity.dao.inter.CrudDaoInter;
import com.itway.charity.entity.SearchingGoodsPhotos;
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
@Service
@Transactional("searchingGoodsPhotosService")
public class SearchingGoodsPhotosServiceImpl implements CrudServiceInter<SearchingGoodsPhotos>{

    @Autowired
    @Qualifier("searchingGoodsPhotosDao")
    private CrudDaoInter<SearchingGoodsPhotos> crudDaoInter;
    
    @Override
    public List<SearchingGoodsPhotos> getAll() {
        return crudDaoInter.getAll();
    }

    @Override
    public SearchingGoodsPhotos getById(int id) {
        return crudDaoInter.getById(id);
    }

    @Override
    public Integer insert(SearchingGoodsPhotos searchingGoodsPhotos) {
        return crudDaoInter.insert(searchingGoodsPhotos);
    }

    @Override
    public Boolean update(SearchingGoodsPhotos searchingGoodsPhotos) {
        return crudDaoInter.update(searchingGoodsPhotos);
    }

    @Override
    public Boolean delete(int id) {
        return crudDaoInter.delete(id);
    }
    
}
