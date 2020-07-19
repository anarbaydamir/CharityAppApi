package com.itway.charity.dto;

import com.itway.charity.entity.PlacedGoodsPhotos;

public class PlacedGoodsPhotosDto {
    private Integer id;
    private String photoUrl;
    private Integer placedGoodsId;

    public PlacedGoodsPhotosDto(){

    }
    public PlacedGoodsPhotosDto(PlacedGoodsPhotos placedGoodsPhotos){
        this.id=placedGoodsPhotos.getId();
        this.photoUrl=placedGoodsPhotos.getPhotoUrl();
        this.placedGoodsId = placedGoodsPhotos.getPlacedGoodsId().getId();
    }

    public PlacedGoodsPhotosDto(Integer id,String photoUrl,Integer placedGoodsId){
        this.id=id;
        this.photoUrl=photoUrl;
        this.placedGoodsId=placedGoodsId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public Integer getPlacedGoodsId() {
        return placedGoodsId;
    }

    public void setPlacedGoodsId(Integer placedGoodsId) {
        this.placedGoodsId = placedGoodsId;
    }
}
