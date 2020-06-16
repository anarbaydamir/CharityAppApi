/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itway.charity.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author anarbaydamirov
 */
@Entity
@Table(name = "placed_goods_photos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PlacedGoodsPhotos.findAll", query = "SELECT p FROM PlacedGoodsPhotos p"),
    @NamedQuery(name = "PlacedGoodsPhotos.findById", query = "SELECT p FROM PlacedGoodsPhotos p WHERE p.id = :id"),
    @NamedQuery(name = "PlacedGoodsPhotos.findByPhotoUrl", query = "SELECT p FROM PlacedGoodsPhotos p WHERE p.photoUrl = :photoUrl")})
public class PlacedGoodsPhotos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "photo_url")
    private String photoUrl;
    @JoinColumn(name = "placed_goods_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private PlacedGoods placedGoodsId;

    public PlacedGoodsPhotos() {
    }

    public PlacedGoodsPhotos(Integer id) {
        this.id = id;
    }

    public PlacedGoodsPhotos(Integer id, String photoUrl) {
        this.id = id;
        this.photoUrl = photoUrl;
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

    public PlacedGoods getPlacedGoodsId() {
        return placedGoodsId;
    }

    public void setPlacedGoodsId(PlacedGoods placedGoodsId) {
        this.placedGoodsId = placedGoodsId;
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
        if (!(object instanceof PlacedGoodsPhotos)) {
            return false;
        }
        PlacedGoodsPhotos other = (PlacedGoodsPhotos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.itway.charity.entity.PlacedGoodsPhotos[ id=" + id + " ]";
    }
    
}
