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
@Table(name = "placed_goods")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PlacedGoods.findAll", query = "SELECT p FROM PlacedGoods p"),
    @NamedQuery(name = "PlacedGoods.findById", query = "SELECT p FROM PlacedGoods p WHERE p.id = :id"),
    @NamedQuery(name = "PlacedGoods.findByGoodsTitle", query = "SELECT p FROM PlacedGoods p WHERE p.goodsTitle = :goodsTitle"),
    @NamedQuery(name = "PlacedGoods.findByGoodsAddress", query = "SELECT p FROM PlacedGoods p WHERE p.goodsAddress = :goodsAddress"),
    @NamedQuery(name = "PlacedGoods.findByGoodsOwnerPhone", query = "SELECT p FROM PlacedGoods p WHERE p.goodsOwnerPhone = :goodsOwnerPhone"),
    @NamedQuery(name = "PlacedGoods.findByGoodsStatus", query = "SELECT p FROM PlacedGoods p WHERE p.goodsStatus = :goodsStatus")})
public class PlacedGoods implements Serializable {

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
    @Column(name = "goods_description")
    private String goodsDescription;
    @Column(name = "goods_address")
    private String goodsAddress;
    @Column(name = "goods_owner_phone")
    private String goodsOwnerPhone;
    @Basic(optional = false)
    @Column(name = "goods_status")
    private short goodsStatus;
    @JoinColumn(name = "goods_owner_city", referencedColumnName = "id")
    @ManyToOne
    private Cities goodsOwnerCity;
    @JoinColumn(name = "goods_category_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GoodsCategory goodsCategoryId;
    @JoinColumn(name = "goods_subcategory_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GoodsSubcategory goodsSubcategoryId;
    @JoinColumn(name = "goods_owner_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Users goodsOwnerId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "placedGoodsId")
    private List<PlacedGoodsPhotos> placedGoodsPhotosList;

    public PlacedGoods() {
    }

    public PlacedGoods(Integer id) {
        this.id = id;
    }

    public PlacedGoods(Integer id, String goodsTitle, short goodsStatus) {
        this.id = id;
        this.goodsTitle = goodsTitle;
        this.goodsStatus = goodsStatus;
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

    public short getGoodsStatus() {
        return goodsStatus;
    }

    public void setGoodsStatus(short goodsStatus) {
        this.goodsStatus = goodsStatus;
    }

    public Cities getGoodsOwnerCity() {
        return goodsOwnerCity;
    }

    public void setGoodsOwnerCity(Cities goodsOwnerCity) {
        this.goodsOwnerCity = goodsOwnerCity;
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

    public Users getGoodsOwnerId() {
        return goodsOwnerId;
    }

    public void setGoodsOwnerId(Users goodsOwnerId) {
        this.goodsOwnerId = goodsOwnerId;
    }

    @XmlTransient
    public List<PlacedGoodsPhotos> getPlacedGoodsPhotosList() {
        return placedGoodsPhotosList;
    }

    public void setPlacedGoodsPhotosList(List<PlacedGoodsPhotos> placedGoodsPhotosList) {
        this.placedGoodsPhotosList = placedGoodsPhotosList;
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
        if (!(object instanceof PlacedGoods)) {
            return false;
        }
        PlacedGoods other = (PlacedGoods) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.itway.charity.entity.PlacedGoods[ id=" + id + " ]";
    }
    
}
