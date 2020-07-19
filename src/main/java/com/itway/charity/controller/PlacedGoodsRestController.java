package com.itway.charity.controller;

import com.itway.charity.dao.inter.*;
import com.itway.charity.dto.PlacedGoodsDto;
import com.itway.charity.dto.ResponseDto;
import com.itway.charity.entity.*;
import com.itway.charity.service.inter.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.ArrayList;
import java.util.List;

@RestController
public class PlacedGoodsRestController {

    @Autowired
    private PlacedGoodsServiceInter placedGoodsServiceInter;

    @Autowired
    private UsersServiceInter usersServiceInter;

    @Autowired
    private GoodsCategoryServiceInter goodsCategoryServiceInter;

    @Autowired
    private GoodsSubcategoryServiceInter goodsSubcategoryServiceInter;

    @Autowired
    private CitiesServiceInter citiesServiceInter;

    @GetMapping("placedGoods")
    public ResponseEntity getAll(){
        try{
            List<PlacedGoods> placedGoodsList = placedGoodsServiceInter.getAll();
            List<PlacedGoodsDto> placedGoodsDtoList = new ArrayList<>();

            for (int i=0;i<placedGoodsList.size();i++){
                PlacedGoods placedGoods = placedGoodsList.get(i);
                placedGoodsDtoList.add(new PlacedGoodsDto(placedGoods));
            }
            return ResponseEntity.ok(new ResponseDto("ok",placedGoodsDtoList));
        }
        catch (Exception ex){
            return ResponseEntity.ok(new ResponseDto(404,"not found",null));
        }
    }

    @GetMapping("placedGoods/new")
    public ResponseEntity newPlacedGoods(){
        try{
            List<PlacedGoods> placedGoodsList = placedGoodsServiceInter.getNew();
            List<PlacedGoodsDto> placedGoodsDtoList = new ArrayList<>();

            for (int i=0;i<placedGoodsList.size();i++){
                PlacedGoods placedGoods = placedGoodsList.get(i);
                placedGoodsDtoList.add(new PlacedGoodsDto(placedGoods));
            }
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto("ok",placedGoodsDtoList));
        }
        catch (Exception ex){
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(404,"not found",null));
        }
    }

    @GetMapping("placedGoods/closed")
    public ResponseEntity closedPlacedGoods(){
        try {
            List<PlacedGoods> placedGoodsList = placedGoodsServiceInter.getClosed();
            List<PlacedGoodsDto> placedGoodsDtoList = new ArrayList<>();

            for (int i=0;i<placedGoodsList.size();i++){
                PlacedGoods placedGoods = placedGoodsList.get(i);
                placedGoodsDtoList.add(new PlacedGoodsDto(placedGoods));
            }
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto("ok",placedGoodsDtoList));
        }
        catch (Exception ex){
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(404,"not found",null));
        }
    }

    @GetMapping("placedGoods/{id}")
    public ResponseEntity getById(@PathVariable(value = "id") int id){
        try{
            PlacedGoods placedGoods = placedGoodsServiceInter.getById(id);
            PlacedGoodsDto placedGoodsDto = new PlacedGoodsDto(placedGoods);

            return ResponseEntity.ok(new ResponseDto("ok",placedGoodsDto));
        }
        catch (Exception ex){
            return ResponseEntity.ok(new ResponseDto(404,"Placed Goods Not Found",null));
        }
    }

    @PostMapping("placedGoods/add")
    public ResponseEntity addPlacedGoods(@RequestBody PlacedGoodsDto placedGoodsDto) {
        try {
            PlacedGoods placedGoods = initializePlacedGoodsForInsert(placedGoodsDto);
            int id = placedGoodsServiceInter.insert(placedGoods);
            if (id != -1)
                return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto("ok", null));
            else
                return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(404, "error occured while inserting", null));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(404, "error occured", null));
        }
    }

    @PostMapping("placedGoods/close")
    public ResponseEntity closePlacedGoods(@RequestParam("id") Integer id){
        try{
            PlacedGoods placedGoods = placedGoodsServiceInter.getById(id);
            if (placedGoods != null){
                placedGoods.setGoodsStatus((short)1);
                placedGoodsServiceInter.update(placedGoods);
                return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto("ok",null));
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDto(404,"Placed Goods not found",null));
        }
        catch (Exception ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDto(400,"bad request",null));
        }
    }

    private PlacedGoods initializePlacedGoodsForInsert(PlacedGoodsDto placedGoodsDto){
        PlacedGoods placedGoods = new PlacedGoods();
        placedGoods.setGoodsTitle(placedGoodsDto.getGoodsTitle());
        placedGoods.setGoodsDescription(placedGoodsDto.getGoodsDescription());
        placedGoods.setGoodsAddress(placedGoodsDto.getGoodsAddress());
        Users users = usersServiceInter.getById(placedGoodsDto.getGoodsOwnerId()); //get Users object
        placedGoods.setGoodsOwnerId(users);
        GoodsCategory goodsCategory = goodsCategoryServiceInter.getById(placedGoodsDto.getGoodsCategoryId()); //get GoodsCategoryObject
        placedGoods.setGoodsCategoryId(goodsCategory);
        GoodsSubcategory goodsSubcategory = goodsSubcategoryServiceInter.getById(placedGoodsDto.getGoodsSubcategoryId());
        placedGoods.setGoodsSubcategoryId(goodsSubcategory);
        placedGoods.setGoodsOwnerPhone(placedGoodsDto.getGoodsOwnerPhone());
        Cities cities = citiesServiceInter.getById(placedGoodsDto.getGoodsOwnerCityId());
        placedGoods.setGoodsOwnerCity(cities);
        placedGoods.setGoodsStatus((short)0);

        return placedGoods;
    }
}
