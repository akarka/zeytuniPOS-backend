package com.kadir.zeytuniPOS.data;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
@Table(name = "UrunKategorileri")
public class UrunKategorileri implements Loglanabilir {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    public Integer urunKategoriId;

    public Integer getUrunKategoriId() {
        return urunKategoriId;
    }

    public void setUrunKategoriId(Integer urunKategoriId) {
        this.urunKategoriId = urunKategoriId;
    }

    @Column
    public String urunKategoriAdi;

    public String getUrunKategoriAdi() {
        return urunKategoriAdi;
    }

    public void setUrunKategoriAdi(String urunKategoriAdi) {
        this.urunKategoriAdi = urunKategoriAdi;
    }

    // LOGLAMA //
    @Override
    @JsonIgnore
    public Integer getHedefId() {
        return this.urunKategoriId;
    }

    @Override
    @JsonIgnore
    public String getHedefTablo() {
        return "UrunKategori";
    }
}
