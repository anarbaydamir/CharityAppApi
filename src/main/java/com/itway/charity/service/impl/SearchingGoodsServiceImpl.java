/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itway.charity.service.impl;

import com.itway.charity.dao.inter.CrudDaoInter;
import com.itway.charity.entity.SearchingGoods;
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
@Service(value = "searchingGoodsService")
@Transactional
public class SearchingGoodsServiceImpl implements CrudServiceInter<SearchingGoods> {

    @Autowired
    @Qualifier("searchingGoodsDao")
    private CrudDaoInter<SearchingGoods> crudDaoInter;
    
    @Override
    public List<SearchingGoods> getAll() {
        return crudDaoInter.getAll();
    }

    @Override
    public SearchingGoods getById(int id) {
        return crudDaoInter.getById(id);
    }

    @Override
    public Integer insert(SearchingGoods searchingGoods) {
        return crudDaoInter.insert(searchingGoods);
    }

    @Override
    public Boolean update(SearchingGoods searchingGoods) {
        return crudDaoInter.update(searchingGoods);
    }

    @Override
    public Boolean delete(int id) {
        return crudDaoInter.delete(id);
    }
    
}
