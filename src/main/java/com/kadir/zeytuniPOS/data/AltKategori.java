package com.kadir.zeytuniPOS.data;

import jakarta.persistence.*;

@Entity
@Table(name = "AltKategoriler")
public class AltKategori {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AltKategoriID", nullable = false, length = 50)
    private Integer altkId;

    public Integer getAltkId() {
        return altkId;
    }

    public void setAltkId(Integer altkId) {
        this.altkId = altkId;
    }

    @Column(name = "AltKategoriAdi", nullable = false, length = 50)
    public String altkAdi;

    public String getAltkAdi() {
        return altkAdi;
    }

    public void setAltkAdi(String altkAdi) {
        this.altkAdi = altkAdi;
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
