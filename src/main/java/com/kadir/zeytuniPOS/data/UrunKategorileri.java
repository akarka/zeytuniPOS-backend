package com.kadir.zeytuniPOS.data;

import jakarta.persistence.*;

@Entity
@Table(name = "UrunKategorileri")
public class UrunKategorileri {

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

    @Column(nullable = false, length = 50, unique = true)
    public String urunKategoriAdi;

    public String getUrunKategoriAdi() {
        return urunKategoriAdi;
    }

    public void setUrunKategoriAdi(String urunKategoriAdi) {
        this.urunKategoriAdi = urunKategoriAdi;
    }

}
