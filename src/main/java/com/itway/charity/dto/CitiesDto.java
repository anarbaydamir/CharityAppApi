package com.itway.charity.dto;

import com.itway.charity.entity.Cities;
import com.itway.charity.entity.PlacedGoods;
import com.itway.charity.entity.SearchingGoods;

import java.util.ArrayList;
import java.util.List;

public class CitiesDto {
    private Integer id;
    private String name;

    public CitiesDto (){

    }
    public CitiesDto(Cities cities){
        this.id=cities.getId();
        this.name=cities.getName();
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
