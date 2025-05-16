package com.kadir.zeytuniPOS.data;

import jakarta.persistence.*;

@Entity
@Table(name = "GecmisFiyatlar")
public class Gecmis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "GecmisFiyatID")
    private Integer gecmisId;

    public Integer getGecmisId() {
        return gecmisId;
    }

    public void setGecmisId(Integer gecmisId) {
        this.gecmisId = gecmisId;
    }

    @Column(name = "UrunID", nullable = false, length = 50)
    private Integer urunId;

    public Integer getUrunId() {
        return urunId;
    }

    public void setUrunId(Integer urunId) {
        this.urunId = urunId;
    }

    @Column(name = "SatisFiyati", nullable = false, length = 50)
    private Integer satisFiyati;

    public Integer getSatisFiyati() {
        return satisFiyati;
    }

    public void setSatisFiyati(Integer satisFiyati) {
        this.satisFiyati = satisFiyati;
    }

    @Column(name = "Tarih", nullable = true, length = 8)
    private java.sql.Timestamp SatisTarihi;

    public java.sql.Timestamp getSatisTarihi() {
        return SatisTarihi;
    }

    public void setSatisTarihi(java.sql.Timestamp satisTarihi) {
        SatisTarihi = satisTarihi;
    }

}
