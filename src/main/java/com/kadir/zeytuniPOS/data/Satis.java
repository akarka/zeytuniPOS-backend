package com.kadir.zeytuniPOS.data;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
@Table(name = "Satislar")
public class Satis implements Loglanabilir {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SatisID")
    private Integer satisId;

    public Integer getSatisId() {
        return satisId;
    }

    public void setSatisId(Integer satisId) {
        this.satisId = satisId;
    }

    @Column(name = "UrunID", nullable = false, length = 50)
    private Integer urunId;

    public Integer getUrunId() {
        return urunId;
    }

    public void setUrunId(Integer urunId) {
        this.urunId = urunId;
    }

    @Column(name = "Miktar", nullable = false, length = 50)
    private Integer miktar;

    public Integer getMiktar() {
        return miktar;
    }

    public void setMiktar(Integer miktar) {
        this.miktar = miktar;
    }

    @Column(name = "SatisFiyati", nullable = true, length = 50)
    private Integer SatisFiyati;

    public Integer getSatisFiyati() {
        return SatisFiyati;
    }

    public void setSatisFiyati(Integer satisFiyati) {
        SatisFiyati = satisFiyati;
    }

    @Column(name = "SatisTarihi", nullable = true, length = 8)
    private java.sql.Timestamp SatisTarihi;

    public java.sql.Timestamp getSatisTarihi() {
        return SatisTarihi;
    }

    public void setSatisTarihi(java.sql.Timestamp satisTarihi) {
        SatisTarihi = satisTarihi;
    }

    // LOGLAMA //
    @Override
    @JsonIgnore
    public Integer getHedefId() {
        return this.satisId;
    }

    @Override
    @JsonIgnore
    public String getHedefTablo() {
        return "Satislar";
    }

}
