package com.itway.charity.dto;

import com.itway.charity.entity.GoodsCategory;
import com.itway.charity.entity.GoodsSubcategory;
import com.itway.charity.entity.PlacedGoods;
import com.itway.charity.entity.SearchingGoods;

import java.util.ArrayList;
import java.util.List;

public class GoodsCategoryDto {
    private Integer id;
    private String name;
    private List<GoodsSubcategoryDto> goodsSubcategoryDtoList;

    public GoodsCategoryDto(){

    }

    public GoodsCategoryDto(GoodsCategory goodsCategory){

        this.id=goodsCategory.getId();
        this.name=goodsCategory.getName();

        List<GoodsSubcategory> goodsSubcategoryList = goodsCategory.getGoodsSubcategoryList();
        List<GoodsSubcategoryDto> gList = new ArrayList<>();

        for (int i=0;i<goodsSubcategoryList.size();i++){
            GoodsSubcategoryDto goodsSubcategoryDto = new GoodsSubcategoryDto(goodsSubcategoryList.get(i));
            gList.add(goodsSubcategoryDto);
        }

        this.goodsSubcategoryDtoList=gList;
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

    public List<GoodsSubcategoryDto> getGoodsSubcategoryDtoList() {
        return goodsSubcategoryDtoList;
    }

    public void setGoodsSubcategoryDtoList(List<GoodsSubcategoryDto> goodsSubcategoryDtoList) {
        this.goodsSubcategoryDtoList = goodsSubcategoryDtoList;
    }
}
