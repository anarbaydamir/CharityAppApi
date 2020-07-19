package com.itway.charity.dao.impl;

import com.itway.charity.dao.inter.SearchingGoodsDaoInter;
import com.itway.charity.entity.SearchingGoods;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository(value = "searchingGoodsDao")
public class SearchingGoodsDaoImpl implements SearchingGoodsDaoInter {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<SearchingGoods> getAll() {
        Query query = entityManager.createQuery("select sg from SearchingGoods sg",SearchingGoods.class);
        List<SearchingGoods> searchingGoodsList = query.getResultList();
        return searchingGoodsList;
    }

    @Override
    public List<SearchingGoods> getNew() {
        Query query = entityManager.createQuery("select sg from SearchingGoods sg where sg.goodsStatus=0",SearchingGoods.class);
        List<SearchingGoods> searchingGoodsList = query.getResultList();
        return searchingGoodsList;
    }

    @Override
    public List<SearchingGoods> getClosed() {
        Query query = entityManager.createQuery("select sg from SearchingGoods sg where sg.goodsStatus=1",SearchingGoods.class);
        List<SearchingGoods> searchingGoodsList = query.getResultList();
        return searchingGoodsList;
    }

    @Override
    public SearchingGoods getById(int id) {
        SearchingGoods searchingGoods = entityManager.find(SearchingGoods.class,id);
        return searchingGoods;
    }

    @Override
    public Integer insert(SearchingGoods searchingGoods) {
        try{
            entityManager.persist(searchingGoods);
            entityManager.flush();
            return searchingGoods.getId();
        }
        catch (Exception ex){
            return -1;
        }
    }

    @Override
    public Boolean update(SearchingGoods searchingGoods) {
        try{
            entityManager.merge(searchingGoods);
            return true;
        }
        catch (Exception ex){
            return false;
        }
    }

    @Override
    public Boolean delete(int id) {
        try{
            SearchingGoods searchingGoods = entityManager.find(SearchingGoods.class,id);
            entityManager.remove(searchingGoods);
            return true;
        }
        catch (Exception ex){
            return false;
        }
    }
}
