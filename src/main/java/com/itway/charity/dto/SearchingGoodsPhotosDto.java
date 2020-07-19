package com.itway.charity.dto;

import com.itway.charity.entity.SearchingGoodsPhotos;

public class SearchingGoodsPhotosDto {
    private Integer id;
    private String photoUrl;
    private Integer searchingGoodsId;

    public SearchingGoodsPhotosDto(){

    }

    public SearchingGoodsPhotosDto(SearchingGoodsPhotos searchingGoodsPhotos){
        this.id=searchingGoodsPhotos.getId();
        this.photoUrl=searchingGoodsPhotos.getPhotoUrl();
    }

    public SearchingGoodsPhotosDto(Integer id,String photoUrl,Integer searchingGoodsId){
        this.id=id;
        this.photoUrl=photoUrl;
        this.searchingGoodsId=searchingGoodsId;
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

    public Integer getSearchingGoodsId() {
        return searchingGoodsId;
    }

    public void setSearchingGoodsId(Integer searchingGoodsId) {
        this.searchingGoodsId = searchingGoodsId;
    }
}
