package com.itway.charity.dao.inter;

import com.itway.charity.entity.PlacedGoodsPhotos;

import java.util.List;

public interface PlacedGoodsPhotosDaoInter {
    List<PlacedGoodsPhotos> getAll();

    PlacedGoodsPhotos getById(int id);

    Integer insert(PlacedGoodsPhotos placedGoodsPhotos);

    Boolean update(PlacedGoodsPhotos placedGoodsPhotos);

    Boolean delete(int id);
}
