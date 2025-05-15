package com.kadir.zeytuniPOS.data;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
@Table(name = "UrunTedarikci")
public class UrunTedarikci implements Loglanabilir {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UrunTedarikciID")
    public Integer utId;

    public Integer getUtId() {
        return utId;
    }

    public void setUtId(Integer utId) {
        this.utId = utId;
    }

    @Column(name = "UrunID", nullable = false)
    public Integer urunId;

    public Integer getUrunId() {
        return urunId;
    }

    public void setUrunId(Integer urunId) {
        this.urunId = urunId;
    }

    @Column(name = "TedarikciID", nullable = false)
    public Integer tdId;

    public Integer getTdId() {
        return tdId;
    }

    public void setTdId(Integer tdId) {
        this.tdId = tdId;
    }

    @Column(name = "AlisFiyati", nullable = true)
    public Integer alisFiyati;

    public Integer getAlisFiyati() {
        return alisFiyati;
    }

    public void setAlisFiyati(Integer alisFiyati) {
        this.alisFiyati = alisFiyati;
    }

    
    @Column(name = "Tarih", nullable = true)
    public java.sql.Timestamp tarih;

    public java.sql.Timestamp getTarih() {
        return tarih;
    }

    public void setTarih(java.sql.Timestamp tarih) {
        this.tarih = tarih;
    }

    // LOGLAMA //
    @Override
    @JsonIgnore
    public Integer getHedefId() {
        return this.utId;
    }

    @Override
    @JsonIgnore
    public String getHedefTablo() {
        return "UrunTedarikci";
    }
}
