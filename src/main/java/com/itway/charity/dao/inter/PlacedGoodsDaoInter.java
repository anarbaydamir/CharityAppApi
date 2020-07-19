package com.itway.charity.dao.inter;

import com.itway.charity.entity.PlacedGoods;

import java.util.List;

public interface PlacedGoodsDaoInter {
    List<PlacedGoods> getAll();

    List<PlacedGoods> getNew();

    List<PlacedGoods> getClosed();

    PlacedGoods getById(int id);

    Integer insert(PlacedGoods placedGoods);

    Boolean update(PlacedGoods placedGoods);

    Boolean delete(int id);
}
