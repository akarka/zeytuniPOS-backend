package com.kadir.zeytuniPOS.data;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
@Table(name = "Urunler")
public class Urun implements Loglanabilir {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UrunID")
    private Integer urunId;

    public Integer getUrunId() {
        return urunId;
    }

    public void setUrunId(Integer urunId) {
        this.urunId = urunId;
    }

    @Column(name = "UrunAdi", nullable = false, length = 200)
    private String urunAdi;

    public String getUrunAdi() {
        return urunAdi;
    }

    public void setUrunAdi(String urunAdi) {
        this.urunAdi = urunAdi;
    }

    @Column(name = "UrunAciklama", nullable = true, length = 510)
    private String urunAciklama;

    public String getUrunAciklama() {
        return urunAciklama;
    }

    public void setUrunAciklama(String urunAciklama) {
        this.urunAciklama = urunAciklama;
    }

    @Column(name = "AltKategoriID", nullable = false, length = 4)
    private Integer altId;

    public Integer getAltId() {
        return altId;
    }

    public void setAltId(Integer altId) {
        this.altId = altId;
    }

    @Column(name = "BirimID", nullable = false, length = 4)
    private Integer birimId;

    public Integer getBirimId() {
        return birimId;
    }

    public void setBirimId(Integer birimId) {
        this.birimId = birimId;
    }

    @Column(name = "GuncelSatisFiyati")
    private java.math.BigDecimal satisFiyati;

    public java.math.BigDecimal getSatisFiyati() {
        return satisFiyati;
    }

    public void setSatisFiyati(java.math.BigDecimal satisFiyati) {
        this.satisFiyati = satisFiyati;
    }

    // LOGLAMA //
    @Override
    @JsonIgnore
    public Integer getHedefId() {
        return this.urunId;
    }

    @Override
    @JsonIgnore
    public String getHedefTablo() {
        return "Urunler";
    }
}
