package com.itway.charity.dto;

import com.itway.charity.entity.SearchingGoods;
import com.itway.charity.entity.SearchingGoodsPhotos;

import java.util.ArrayList;
import java.util.List;

public class SearchingGoodsDto {
    private Integer id;
    private String goodsTitle;
    private String goodsDescription;
    private String searchingGoodsAddress;
    private String searchingUserPhone;
    private Short goodsStatus;
    private List<SearchingGoodsPhotosDto> searchingGoodsPhotosDtoList;
    private Integer citiesId;
    private Integer goodsCategoryId;
    private Integer goodsSubcategoryId;
    private Integer searchingUserId;
    private CitiesDto citiesDto;
    private GoodsCategoryDto goodsCategoryDto;
    private GoodsSubcategoryDto goodsSubcategoryDto;
    private UsersDto searchingUserDto;

    public SearchingGoodsDto(){

    }

    public SearchingGoodsDto(SearchingGoods searchingGoods){
        this.id=searchingGoods.getId();
        this.goodsTitle=searchingGoods.getGoodsTitle();
        this.goodsDescription=searchingGoods.getGoodDescription();
        this.searchingGoodsAddress=searchingGoods.getSearchingGoodsAddress();
        this.searchingUserPhone=searchingGoods.getSearchingUserPhone();
        this.goodsStatus=searchingGoods.getGoodsStatus();
        this.citiesDto=new CitiesDto(searchingGoods.getSearchingGoodsCity());
        this.goodsCategoryDto=new GoodsCategoryDto(searchingGoods.getGoodsCategoryId());
        this.goodsSubcategoryDto=new GoodsSubcategoryDto(searchingGoods.getGoodsSubcategoryId());
        this.searchingUserDto=new UsersDto(searchingGoods.getSearchingUserId());

        List<SearchingGoodsPhotos> searchingGoodsPhotosList = searchingGoods.getSearchingGoodsPhotosList();
        List<SearchingGoodsPhotosDto> sList = new ArrayList<>();

        for (int i=0;i<searchingGoodsPhotosList.size();i++){
            SearchingGoodsPhotosDto searchingGoodsPhotosDto = new SearchingGoodsPhotosDto(searchingGoodsPhotosList.get(i));
            sList.add(searchingGoodsPhotosDto);
        }

        this.searchingGoodsPhotosDtoList = sList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getSearchingGoodsAddress() {
        return searchingGoodsAddress;
    }

    public void setSearchingGoodsAddress(String searchingGoodsAddress) {
        this.searchingGoodsAddress = searchingGoodsAddress;
    }

    public String getSearchingUserPhone() {
        return searchingUserPhone;
    }

    public void setSearchingUserPhone(String searchingUserPhone) {
        this.searchingUserPhone = searchingUserPhone;
    }

    public Short getGoodsStatus() {
        return goodsStatus;
    }

    public void setGoodsStatus(Short goodsStatus) {
        this.goodsStatus = goodsStatus;
    }

    public List<SearchingGoodsPhotosDto> getSearchingGoodsPhotosDtoList() {
        return searchingGoodsPhotosDtoList;
    }

    public void setSearchingGoodsPhotosDtoList(List<SearchingGoodsPhotosDto> searchingGoodsPhotosDtoList) {
        this.searchingGoodsPhotosDtoList = searchingGoodsPhotosDtoList;
    }

    public CitiesDto getCitiesDto() {
        return citiesDto;
    }

    public void setCitiesDto(CitiesDto citiesDto) {
        this.citiesDto = citiesDto;
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

    public UsersDto getSearchingUserDto() {
        return searchingUserDto;
    }

    public void setSearchingUserDto(UsersDto searchingUserDto) {
        this.searchingUserDto = searchingUserDto;
    }

    public Integer getCitiesId() {
        return citiesId;
    }

    public void setCitiesId(Integer citiesId) {
        this.citiesId = citiesId;
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

    public Integer getSearchingUserId() {
        return searchingUserId;
    }

    public void setSearchingUserId(Integer searchingUserId) {
        this.searchingUserId = searchingUserId;
    }
}
