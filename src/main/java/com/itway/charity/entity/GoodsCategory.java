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
@Table(name = "goods_category")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GoodsCategory.findAll", query = "SELECT g FROM GoodsCategory g"),
    @NamedQuery(name = "GoodsCategory.findById", query = "SELECT g FROM GoodsCategory g WHERE g.id = :id"),
    @NamedQuery(name = "GoodsCategory.findByName", query = "SELECT g FROM GoodsCategory g WHERE g.name = :name")})
public class GoodsCategory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categoryId")
    private List<GoodsSubcategory> goodsSubcategoryList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "goodsCategoryId")
    private List<PlacedGoods> placedGoodsList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "goodsCategoryId")
    private List<SearchingGoods> searchingGoodsList;

    public GoodsCategory() {
    }

    public GoodsCategory(Integer id) {
        this.id = id;
    }

    public GoodsCategory(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public List<GoodsSubcategory> getGoodsSubcategoryList() {
        return goodsSubcategoryList;
    }

    public void setGoodsSubcategoryList(List<GoodsSubcategory> goodsSubcategoryList) {
        this.goodsSubcategoryList = goodsSubcategoryList;
    }

    @XmlTransient
    public List<PlacedGoods> getPlacedGoodsList() {
        return placedGoodsList;
    }

    public void setPlacedGoodsList(List<PlacedGoods> placedGoodsList) {
        this.placedGoodsList = placedGoodsList;
    }

    @XmlTransient
    public List<SearchingGoods> getSearchingGoodsList() {
        return searchingGoodsList;
    }

    public void setSearchingGoodsList(List<SearchingGoods> searchingGoodsList) {
        this.searchingGoodsList = searchingGoodsList;
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
        if (!(object instanceof GoodsCategory)) {
            return false;
        }
        GoodsCategory other = (GoodsCategory) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.itway.charity.entity.GoodsCategory[ id=" + id + " ]";
    }
    
}
