package com.kadir.zeytuniPOS.data;

import jakarta.persistence.*;

@Entity
@Table(name = "Urunler")
public class Urun {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UrunID")
    private Integer urunId;

    @Column(name = "UrunAdi", nullable = false, length = 200)
    private String ad;

    @Column(name = "UrunAciklama", nullable = true, length = 510)
    private String urunAciklama;

    @Column(name = "AltKategoriID", nullable = false, length = 4)
    private Integer altId;

    @Column(name = "BirimID", nullable = false, length = 4)
    private Integer birimId;

    @Column(name = "GuncelSatisFiyati")
    private java.math.BigDecimal satisFiyati;

    public Integer getId() {
        return urunId;
    }

    public void setId(Integer urunId) {
        this.urunId = urunId;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getUrunAciklama() {
        return urunAciklama;
    }

    public void setUrunAciklama(String urunAciklama) {
        this.urunAciklama = urunAciklama;
    }

    public Integer getAltId() {
        return altId;
    }

    public void setAltId(Integer altId) {
        this.altId = altId;
    }

    public Integer getBirimId() {
        return birimId;
    }

    public void setBirimId(Integer birimId) {
        this.birimId = birimId;
    }

    public java.math.BigDecimal getSatisFiyati() {
        return satisFiyati;
    }

    public void setSatisFiyati(java.math.BigDecimal satisFiyati) {
        this.satisFiyati = satisFiyati;
    }
}
