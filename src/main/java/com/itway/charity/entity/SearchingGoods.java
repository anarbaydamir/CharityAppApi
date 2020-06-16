/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itway.charity.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author anarbaydamirov
 */
@Entity
@Table(name = "searching_goods")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SearchingGoods.findAll", query = "SELECT s FROM SearchingGoods s"),
    @NamedQuery(name = "SearchingGoods.findById", query = "SELECT s FROM SearchingGoods s WHERE s.id = :id"),
    @NamedQuery(name = "SearchingGoods.findByGoodsTitle", query = "SELECT s FROM SearchingGoods s WHERE s.goodsTitle = :goodsTitle"),
    @NamedQuery(name = "SearchingGoods.findBySearchingGoodsAddress", query = "SELECT s FROM SearchingGoods s WHERE s.searchingGoodsAddress = :searchingGoodsAddress"),
    @NamedQuery(name = "SearchingGoods.findBySearchingUserPhone", query = "SELECT s FROM SearchingGoods s WHERE s.searchingUserPhone = :searchingUserPhone"),
    @NamedQuery(name = "SearchingGoods.findByGoodsStatus", query = "SELECT s FROM SearchingGoods s WHERE s.goodsStatus = :goodsStatus")})
public class SearchingGoods implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "goods_title")
    private String goodsTitle;
    @Lob
    @Column(name = "good_description")
    private String goodDescription;
    @Column(name = "searching_goods_address")
    private String searchingGoodsAddress;
    @Column(name = "searching_user_phone")
    private String searchingUserPhone;
    @Column(name = "goods_status")
    private Short goodsStatus;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "searchingGoodsId")
    private List<SearchingGoodsPhotos> searchingGoodsPhotosList;
    @JoinColumn(name = "searching_goods_city", referencedColumnName = "id")
    @ManyToOne
    private Cities searchingGoodsCity;
    @JoinColumn(name = "goods_category_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GoodsCategory goodsCategoryId;
    @JoinColumn(name = "goods_subcategory_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GoodsSubcategory goodsSubcategoryId;
    @JoinColumn(name = "searching_user_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Users searchingUserId;

    public SearchingGoods() {
    }

    public SearchingGoods(Integer id) {
        this.id = id;
    }

    public SearchingGoods(Integer id, String goodsTitle) {
        this.id = id;
        this.goodsTitle = goodsTitle;
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

    public String getGoodDescription() {
        return goodDescription;
    }

    public void setGoodDescription(String goodDescription) {
        this.goodDescription = goodDescription;
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

    @XmlTransient
    public List<SearchingGoodsPhotos> getSearchingGoodsPhotosList() {
        return searchingGoodsPhotosList;
    }

    public void setSearchingGoodsPhotosList(List<SearchingGoodsPhotos> searchingGoodsPhotosList) {
        this.searchingGoodsPhotosList = searchingGoodsPhotosList;
    }

    public Cities getSearchingGoodsCity() {
        return searchingGoodsCity;
    }

    public void setSearchingGoodsCity(Cities searchingGoodsCity) {
        this.searchingGoodsCity = searchingGoodsCity;
    }

    public GoodsCategory getGoodsCategoryId() {
        return goodsCategoryId;
    }

    public void setGoodsCategoryId(GoodsCategory goodsCategoryId) {
        this.goodsCategoryId = goodsCategoryId;
    }

    public GoodsSubcategory getGoodsSubcategoryId() {
        return goodsSubcategoryId;
    }

    public void setGoodsSubcategoryId(GoodsSubcategory goodsSubcategoryId) {
        this.goodsSubcategoryId = goodsSubcategoryId;
    }

    public Users getSearchingUserId() {
        return searchingUserId;
    }

    public void setSearchingUserId(Users searchingUserId) {
        this.searchingUserId = searchingUserId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SearchingGoods)) {
            return false;
        }
        SearchingGoods other = (SearchingGoods) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.itway.charity.entity.SearchingGoods[ id=" + id + " ]";
    }
    
}
