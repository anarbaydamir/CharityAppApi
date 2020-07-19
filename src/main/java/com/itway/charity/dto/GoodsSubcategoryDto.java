package com.itway.charity.dto;

import com.itway.charity.entity.GoodsSubcategory;
import com.itway.charity.entity.PlacedGoods;
import com.itway.charity.entity.SearchingGoods;

import java.util.ArrayList;
import java.util.List;

public class GoodsSubcategoryDto {
    private Integer id;
    private String name;

    public GoodsSubcategoryDto(){

    }

    public GoodsSubcategoryDto(GoodsSubcategory goodsSubcategory){

        this.id=goodsSubcategory.getId();
        this.name=goodsSubcategory.getName();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
