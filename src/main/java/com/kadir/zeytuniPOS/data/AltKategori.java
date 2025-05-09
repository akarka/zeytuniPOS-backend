package com.kadir.zeytuniPOS.data;

import jakarta.persistence.*;

@Entity
@Table(name = "AltKategoriler")
public class AltKategori {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AltKategoriID", nullable = false, length = 50)
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "AltKategoriAdi", nullable = false, length = 50)
    public String ad;

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    @Column(name = "UrunKategoriID", nullable = false, length = 50)
    public String kategoriID;

    public String getKategoriID() {
        return kategoriID;
    }

    public void setKategoriID(String kategoriID) {
        this.kategoriID = kategoriID;
    }

}
