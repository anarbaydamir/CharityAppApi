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
@Table(name = "goods_subcategory")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GoodsSubcategory.findAll", query = "SELECT g FROM GoodsSubcategory g"),
    @NamedQuery(name = "GoodsSubcategory.findById", query = "SELECT g FROM GoodsSubcategory g WHERE g.id = :id"),
    @NamedQuery(name = "GoodsSubcategory.findByName", query = "SELECT g FROM GoodsSubcategory g WHERE g.name = :name")})
public class GoodsSubcategory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GoodsCategory categoryId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "goodsSubcategoryId")
    private List<PlacedGoods> placedGoodsList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "goodsSubcategoryId")
    private List<SearchingGoods> searchingGoodsList;

    public GoodsSubcategory() {
    }

    public GoodsSubcategory(Integer id) {
        this.id = id;
    }

    public GoodsSubcategory(Integer id, String name) {
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

    public GoodsCategory getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(GoodsCategory categoryId) {
        this.categoryId = categoryId;
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
        if (!(object instanceof GoodsSubcategory)) {
            return false;
        }
        GoodsSubcategory other = (GoodsSubcategory) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.itway.charity.entity.GoodsSubcategory[ id=" + id + " ]";
    }
    
}
