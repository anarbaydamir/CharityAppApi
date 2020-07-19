package com.itway.charity.controller;

import com.itway.charity.dao.inter.GoodsSubcategoryDaoInter;
import com.itway.charity.dto.GoodsSubcategoryDto;
import com.itway.charity.dto.ResponseDto;
import com.itway.charity.entity.GoodsSubcategory;
import com.itway.charity.service.inter.GoodsSubcategoryServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class GoodsSubCategoryRestController {

    @Autowired
    private GoodsSubcategoryServiceInter goodsSubcategoryServiceInter;

    @GetMapping(value = "goodSubcategory")
    public ResponseEntity getAll(){
        try{
            List<GoodsSubcategory> goodsSubcategoryList = goodsSubcategoryServiceInter.getAll();
            List<GoodsSubcategoryDto> goodsSubcategoryDtoList = new ArrayList<>();

            for (int i=0;i<goodsSubcategoryList.size();i++){
                GoodsSubcategory goodsSubcategory = goodsSubcategoryList.get(i);
                goodsSubcategoryDtoList.add(new GoodsSubcategoryDto(goodsSubcategory));
            }
            return ResponseEntity.ok(new ResponseDto("ok",goodsSubcategoryDtoList));
        }
        catch (Exception ex){
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(404,"error",null));
        }
    }
}
