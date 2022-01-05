/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cemilan.cemilan;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author annis
 */
@Entity
@Table(name = "datacemilan")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Datacemilan.findAll", query = "SELECT d FROM Datacemilan d"),
    @NamedQuery(name = "Datacemilan.findById", query = "SELECT d FROM Datacemilan d WHERE d.id = :id"),
    @NamedQuery(name = "Datacemilan.findByProduk", query = "SELECT d FROM Datacemilan d WHERE d.produk = :produk"),
    @NamedQuery(name = "Datacemilan.findByHarga", query = "SELECT d FROM Datacemilan d WHERE d.harga = :harga"),
    @NamedQuery(name = "Datacemilan.findByJumlah", query = "SELECT d FROM Datacemilan d WHERE d.jumlah = :jumlah")})
public class Datacemilan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "produk")
    private String produk;
    @Column(name = "harga")
    private String harga;
    @Column(name = "jumlah")
    private Integer jumlah;

    public Datacemilan() {
    }

    public Datacemilan(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProduk() {
        return produk;
    }

    public void setProduk(String produk) {
        this.produk = produk;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public Integer getJumlah() {
        return jumlah;
    }

    public void setJumlah(Integer jumlah) {
        this.jumlah = jumlah;
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
        if (!(object instanceof Datacemilan)) {
            return false;
        }
        Datacemilan other = (Datacemilan) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cemilan.cemilan.Datacemilan[ id=" + id + " ]";
    }
    
}
