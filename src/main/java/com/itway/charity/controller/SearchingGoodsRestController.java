package com.itway.charity.controller;


import com.itway.charity.dto.ResponseDto;
import com.itway.charity.dto.SearchingGoodsDto;
import com.itway.charity.entity.*;
import com.itway.charity.service.inter.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SearchingGoodsRestController {

    @Autowired
    private SearchingGoodsServiceInter searchingGoodsServiceInter;

    @Autowired
    private UsersServiceInter usersServiceInter;

    @Autowired
    private GoodsCategoryServiceInter goodsCategoryServiceInter;

    @Autowired
    private GoodsSubcategoryServiceInter goodsSubcategoryServiceInter;

    @Autowired
    private CitiesServiceInter citiesServiceInter;

    @GetMapping("searchingGoods")
    public ResponseEntity getAll() {
        try {
            List<SearchingGoods> searchingGoodsList = searchingGoodsServiceInter.getAll();
            List<SearchingGoodsDto> searchingGoodsDtoList = new ArrayList<>();

            for (int i = 0; i < searchingGoodsList.size(); i++) {
                SearchingGoods searchingGoods = searchingGoodsList.get(i);
                searchingGoodsDtoList.add(new SearchingGoodsDto(searchingGoods));
            }
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto("ok", searchingGoodsDtoList));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDto(404, "not found", null));
        }
    }

    @GetMapping("searchingGoods/new")
    public ResponseEntity newSearchingGoods() {
        try {
            List<SearchingGoods> searchingGoodsList = searchingGoodsServiceInter.getNew();
            List<SearchingGoodsDto> searchingGoodsDtoList = new ArrayList<>();

            for (int i = 0; i < searchingGoodsList.size(); i++) {
                SearchingGoods searchingGoods = searchingGoodsList.get(i);
                searchingGoodsDtoList.add(new SearchingGoodsDto(searchingGoods));
            }
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto("ok", searchingGoodsDtoList));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDto(404, "not found", null));
        }
    }

    @GetMapping("searchingGoods/closed")
    public ResponseEntity closedSearchingGoods() {
        try {
            List<SearchingGoods> searchingGoodsList = searchingGoodsServiceInter.getClosed();
            List<SearchingGoodsDto> searchingGoodsDtoList = new ArrayList<>();

            for (int i = 0; i < searchingGoodsList.size(); i++) {
                SearchingGoods searchingGoods = searchingGoodsList.get(i);
                searchingGoodsDtoList.add(new SearchingGoodsDto(searchingGoods));
            }
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto("ok", searchingGoodsDtoList));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDto(404, "not found", null));
        }
    }

    @PostMapping("searchingGoods/add")
    public ResponseEntity addSearchingGoods(@RequestBody SearchingGoodsDto searchingGoodsDto) {
        try {
            SearchingGoods searchingGoods = initializeSearchingGoodsForAdd(searchingGoodsDto);
            int id = searchingGoodsServiceInter.insert(searchingGoods);
            if (id != -1) {
                return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto("ok", null));
            } else {
                return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(404, "error occured while inserting", null));
            }
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDto(400, "bad request", null));
        }
    }

    @PostMapping("searchingGoods/close")
    public ResponseEntity closeSearchingGoods(@RequestParam(value = "id") Integer id) {
        try {
            SearchingGoods searchingGoods = searchingGoodsServiceInter.getById(id);
            if (searchingGoods != null) {
                searchingGoods.setGoodsStatus((short) 1);
                searchingGoodsServiceInter.update(searchingGoods);
                return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto("ok", null));
            } else
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDto(404, "searching goods not found", null));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDto(400, "bad request", null));
        }
    }

    private SearchingGoods initializeSearchingGoodsForAdd(SearchingGoodsDto searchingGoodsDto) {
        Users users = usersServiceInter.getById(searchingGoodsDto.getSearchingUserId());
        GoodsCategory goodsCategory = goodsCategoryServiceInter.getById(searchingGoodsDto.getGoodsCategoryId());
        GoodsSubcategory goodsSubcategory = goodsSubcategoryServiceInter.getById(searchingGoodsDto.getGoodsSubcategoryId());
        Cities cities = citiesServiceInter.getById(searchingGoodsDto.getCitiesId());

        SearchingGoods searchingGoods = new SearchingGoods();
        searchingGoods.setGoodsTitle(searchingGoodsDto.getGoodsTitle());
        searchingGoods.setGoodDescription(searchingGoodsDto.getGoodsDescription());
        searchingGoods.setSearchingUserId(users);
        searchingGoods.setSearchingGoodsAddress(searchingGoodsDto.getSearchingGoodsAddress());
        searchingGoods.setGoodsCategoryId(goodsCategory);
        searchingGoods.setGoodsSubcategoryId(goodsSubcategory);
        searchingGoods.setSearchingUserPhone(searchingGoodsDto.getSearchingUserPhone());
        searchingGoods.setSearchingGoodsCity(cities);
        searchingGoods.setGoodsStatus((short) 0);

        return searchingGoods;
    }

}
