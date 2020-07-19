/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itway.charity.service.impl;

import com.itway.charity.dao.inter.SearchingGoodsDaoInter;
import com.itway.charity.entity.SearchingGoods;

import java.util.List;

import com.itway.charity.service.inter.SearchingGoodsServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author anarbaydamirov
 */
@Service(value = "searchingGoodsService")
@Transactional
public class SearchingGoodsServiceImpl implements SearchingGoodsServiceInter {

    @Autowired
    @Qualifier("searchingGoodsDao")
    private SearchingGoodsDaoInter searchingGoodsDaoInter;
    
    @Override
    public List<SearchingGoods> getAll() {
        return searchingGoodsDaoInter.getAll();
    }

    @Override
    public List<SearchingGoods> getNew() {
        return searchingGoodsDaoInter.getNew();
    }

    @Override
    public List<SearchingGoods> getClosed() {
        return searchingGoodsDaoInter.getClosed();
    }

    @Override
    public SearchingGoods getById(int id) {
        return searchingGoodsDaoInter.getById(id);
    }

    @Override
    public Integer insert(SearchingGoods searchingGoods) {
        return searchingGoodsDaoInter.insert(searchingGoods);
    }

    @Override
    public Boolean update(SearchingGoods searchingGoods) {
        return searchingGoodsDaoInter.update(searchingGoods);
    }

    @Override
    public Boolean delete(int id) {
        return searchingGoodsDaoInter.delete(id);
    }
    
}
