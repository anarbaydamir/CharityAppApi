package com.itway.charity.dao.inter;

import com.itway.charity.entity.GoodsSubcategory;

import java.util.List;

public interface GoodsSubcategoryDaoInter {
    List<GoodsSubcategory> getAll();

    GoodsSubcategory getById(int id);

    Integer insert(GoodsSubcategory goodsSubcategory);

    Boolean update(GoodsSubcategory goodsSubcategory);

    Boolean delete(int id);
}
