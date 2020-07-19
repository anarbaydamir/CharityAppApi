package com.itway.charity.controller;

import com.itway.charity.dto.GoodsCategoryDto;
import com.itway.charity.dto.ResponseDto;
import com.itway.charity.entity.GoodsCategory;
import com.itway.charity.service.inter.GoodsCategoryServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class GoodsCategoryRestController {
    @Autowired
    private GoodsCategoryServiceInter goodsCategoryServiceInter;

    @GetMapping(value = "goodsCategory")
    public ResponseEntity getAll(){
        try {
            List<GoodsCategory> goodsCategoryList = goodsCategoryServiceInter.getAll();
            List<GoodsCategoryDto> goodsCategoryDtoList = new ArrayList<>();

            for (int i = 0;i<goodsCategoryList.size();i++){
                GoodsCategory goodsCategory = goodsCategoryList.get(i);
                goodsCategoryDtoList.add(new GoodsCategoryDto(goodsCategory));
            }
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto("ok",goodsCategoryDtoList));
        }
        catch (Exception ex){
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(404,"error",null));
        }
    }
}
