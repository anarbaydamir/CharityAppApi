package com.itway.charity.dto;

import com.itway.charity.entity.PlacedGoods;
import com.itway.charity.entity.PlacedGoodsPhotos;

import java.util.ArrayList;
import java.util.List;

public class PlacedGoodsDto {
    private int id;
    private String goodsTitle;
    private String goodsDescription;
    private String goodsAddress;
    private String goodsOwnerPhone;
    private Short goodsStatus;
    private Integer goodsOwnerCityId;
    private Integer goodsCategoryId;
    private Integer goodsSubcategoryId;
    private Integer goodsOwnerId;
    private CitiesDto goodsOwnerCityDto;
    private GoodsCategoryDto goodsCategoryDto;
    private GoodsSubcategoryDto goodsSubcategoryDto;
    private UsersDto goodsOwnerDto;
    private List<PlacedGoodsPhotosDto> placedGoodsPhotosDtoList;

    public PlacedGoodsDto(){

    }
    public PlacedGoodsDto(PlacedGoods placedGoods){
        this.id=placedGoods.getId();
        this.goodsTitle=placedGoods.getGoodsTitle();
        this.goodsDescription=placedGoods.getGoodsDescription();
        this.goodsAddress=placedGoods.getGoodsAddress();
        this.goodsOwnerPhone=placedGoods.getGoodsOwnerPhone();
        this.goodsStatus=placedGoods.getGoodsStatus();
        this.goodsOwnerCityDto=new CitiesDto(placedGoods.getGoodsOwnerCity());
        this.goodsCategoryDto=new GoodsCategoryDto(placedGoods.getGoodsCategoryId());
        this.goodsSubcategoryDto=new GoodsSubcategoryDto(placedGoods.getGoodsSubcategoryId());
        this.goodsOwnerDto=new UsersDto(placedGoods.getGoodsOwnerId());

        List<PlacedGoodsPhotos> placedGoodsPhotosList = placedGoods.getPlacedGoodsPhotosList();
        List<PlacedGoodsPhotosDto> pList = new ArrayList<>();

        for (int i=0;i<placedGoodsPhotosList.size();i++){
            PlacedGoodsPhotosDto placedGoodsPhotosDto = new PlacedGoodsPhotosDto(placedGoodsPhotosList.get(i));
            pList.add(placedGoodsPhotosDto);
        }
        this.placedGoodsPhotosDtoList=pList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGoodsTitle() {
        return goodsTitle;
    }

    public void setGoodsTitle(String goodsTitle) {
        this.goodsTitle = goodsTitle;
    }

    public String getGoodsDescription() {
        return goodsDescription;
    }

    public void setGoodsDescription(String goodsDescription) {
        this.goodsDescription = goodsDescription;
    }

    public String getGoodsAddress() {
        return goodsAddress;
    }

    public void setGoodsAddress(String goodsAddress) {
        this.goodsAddress = goodsAddress;
    }

    public String getGoodsOwnerPhone() {
        return goodsOwnerPhone;
    }

    public void setGoodsOwnerPhone(String goodsOwnerPhone) {
        this.goodsOwnerPhone = goodsOwnerPhone;
    }

    public Short getGoodsStatus() {
        return goodsStatus;
    }

    public void setGoodsStatus(Short goodsStatus) {
        this.goodsStatus = goodsStatus;
    }

    public CitiesDto getGoodsOwnerCityDto() {
        return goodsOwnerCityDto;
    }

    public void setGoodsOwnerCityDto(CitiesDto goodsOwnerCityDto) {
        this.goodsOwnerCityDto = goodsOwnerCityDto;
    }

    public GoodsCategoryDto getGoodsCategoryDto() {
        return goodsCategoryDto;
    }

    public void setGoodsCategoryDto(GoodsCategoryDto goodsCategoryDto) {
        this.goodsCategoryDto = goodsCategoryDto;
    }

    public GoodsSubcategoryDto getGoodsSubcategoryDto() {
        return goodsSubcategoryDto;
    }

    public void setGoodsSubcategoryDto(GoodsSubcategoryDto goodsSubcategoryDto) {
        this.goodsSubcategoryDto = goodsSubcategoryDto;
    }

    public UsersDto getGoodsOwnerDto() {
        return goodsOwnerDto;
    }

    public void setGoodsOwnerDto(UsersDto goodsOwnerDto) {
        this.goodsOwnerDto = goodsOwnerDto;
    }

    public List<PlacedGoodsPhotosDto> getPlacedGoodsPhotosDtoList() {
        return placedGoodsPhotosDtoList;
    }

    public void setPlacedGoodsPhotosDtoList(List<PlacedGoodsPhotosDto> placedGoodsPhotosDtoList) {
        this.placedGoodsPhotosDtoList = placedGoodsPhotosDtoList;
    }

    public Integer getGoodsOwnerCityId() {
        return goodsOwnerCityId;
    }

    public void setGoodsOwnerCityId(Integer goodsOwnerCityId) {
        this.goodsOwnerCityId = goodsOwnerCityId;
    }

    public Integer getGoodsCategoryId() {
        return goodsCategoryId;
    }

    public void setGoodsCategoryId(Integer goodsCategoryId) {
        this.goodsCategoryId = goodsCategoryId;
    }

    public Integer getGoodsSubcategoryId() {
        return goodsSubcategoryId;
    }

    public void setGoodsSubcategoryId(Integer goodsSubcategoryId) {
        this.goodsSubcategoryId = goodsSubcategoryId;
    }

    public Integer getGoodsOwnerId() {
        return goodsOwnerId;
    }

    public void setGoodsOwnerId(Integer goodsOwnerId) {
        this.goodsOwnerId = goodsOwnerId;
    }
}
