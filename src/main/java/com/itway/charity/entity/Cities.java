/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itway.charity.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
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
@Table(name = "cities")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cities.findAll", query = "SELECT c FROM Cities c"),
    @NamedQuery(name = "Cities.findById", query = "SELECT c FROM Cities c WHERE c.id = :id"),
    @NamedQuery(name = "Cities.findByName", query = "SELECT c FROM Cities c WHERE c.name = :name")})
public class Cities implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "goodsOwnerCity")
    private List<PlacedGoods> placedGoodsList;
    @OneToMany(mappedBy = "searchingGoodsCity")
    private List<SearchingGoods> searchingGoodsList;

    public Cities() {
    }

    public Cities(Integer id) {
        this.id = id;
    }

    public Cities(Integer id, String name) {
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
        if (!(object instanceof Cities)) {
            return false;
        }
        Cities other = (Cities) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.itway.charity.entity.Cities[ id=" + id + " ]";
    }
    
}
