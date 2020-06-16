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
@Table(name = "searching_goods_photos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SearchingGoodsPhotos.findAll", query = "SELECT s FROM SearchingGoodsPhotos s"),
    @NamedQuery(name = "SearchingGoodsPhotos.findById", query = "SELECT s FROM SearchingGoodsPhotos s WHERE s.id = :id"),
    @NamedQuery(name = "SearchingGoodsPhotos.findByPhotoUrl", query = "SELECT s FROM SearchingGoodsPhotos s WHERE s.photoUrl = :photoUrl")})
public class SearchingGoodsPhotos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "photo_url")
    private String photoUrl;
    @JoinColumn(name = "searching_goods_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SearchingGoods searchingGoodsId;

    public SearchingGoodsPhotos() {
    }

    public SearchingGoodsPhotos(Integer id) {
        this.id = id;
    }

    public SearchingGoodsPhotos(Integer id, String photoUrl) {
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

    public SearchingGoods getSearchingGoodsId() {
        return searchingGoodsId;
    }

    public void setSearchingGoodsId(SearchingGoods searchingGoodsId) {
        this.searchingGoodsId = searchingGoodsId;
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
        if (!(object instanceof SearchingGoodsPhotos)) {
            return false;
        }
        SearchingGoodsPhotos other = (SearchingGoodsPhotos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.itway.charity.entity.SearchingGoodsPhotos[ id=" + id + " ]";
    }
    
}
