package com.itway.charity.dao.inter;

import com.itway.charity.entity.GoodsCategory;

import java.util.List;

public interface GoodsCategoryDaoInter {
    List<GoodsCategory> getAll();

    GoodsCategory getById(int id);

    Integer insert(GoodsCategory goodsCategory);

    Boolean update(GoodsCategory goodsCategory);

    Boolean delete(int id);
}
