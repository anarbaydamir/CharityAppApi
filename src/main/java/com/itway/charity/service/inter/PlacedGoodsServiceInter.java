package com.itway.charity.service.inter;

import com.itway.charity.entity.PlacedGoods;

import java.util.List;

public interface PlacedGoodsServiceInter {
    List<PlacedGoods> getAll();

    List<PlacedGoods> getNew();

    List<PlacedGoods> getClosed();

    PlacedGoods getById(int id);

    Integer insert(PlacedGoods placedGoods);

    Boolean update(PlacedGoods placedGoods);

    Boolean delete(int id);
}
