package com.itway.charity.dao.inter;

import com.itway.charity.entity.SearchingGoods;

import java.util.List;

public interface SearchingGoodsDaoInter {
    List<SearchingGoods> getAll();

    List<SearchingGoods> getNew();

    List<SearchingGoods> getClosed();

    SearchingGoods getById(int id);

    Integer insert(SearchingGoods searchingGoods);

    Boolean update(SearchingGoods searchingGoods);

    Boolean delete(int id);
}
