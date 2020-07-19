package com.itway.charity.service.inter;

import com.itway.charity.entity.SearchingGoodsPhotos;

import java.util.List;

public interface SearchingGoodsPhotosServiceInter {
    List<SearchingGoodsPhotos> getAll();

    SearchingGoodsPhotos getById(int id);

    Integer insert(SearchingGoodsPhotos searchingGoodsPhotos);

    Boolean update(SearchingGoodsPhotos searchingGoodsPhotos);

    Boolean delete(int id);
}
