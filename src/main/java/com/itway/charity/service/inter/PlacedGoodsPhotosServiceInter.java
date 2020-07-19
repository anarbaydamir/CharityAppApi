package com.itway.charity.service.inter;

import com.itway.charity.entity.PlacedGoodsPhotos;

import java.util.List;

public interface PlacedGoodsPhotosServiceInter {
    List<PlacedGoodsPhotos> getAll();

    PlacedGoodsPhotos getById(int id);

    Integer insert(PlacedGoodsPhotos placedGoodsPhotos);

    Boolean update(PlacedGoodsPhotos placedGoodsPhotos);

    Boolean delete(int id);
}
