package com.kadir.zeytuniPOS.dto;

import java.math.BigDecimal;

public class UrunDTOCreate {
    private String urunAdi;
    private String urunAciklama;
    private Integer altKategoriId;
    private Integer birimId;
    private BigDecimal guncelSatisFiyati;
    private String notlar;

    public UrunDTOCreate() {
    }

    public String getUrunAdi() {
        return urunAdi;
    }

    public void setUrunAdi(String urunAdi) {
        this.urunAdi = urunAdi;
    }

    public String getUrunAciklama() {
        return urunAciklama;
    }

    public void setUrunAciklama(String urunAciklama) {
        this.urunAciklama = urunAciklama;
    }

    public Integer getAltKategoriId() {
        return altKategoriId;
    }

    public void setAltKategoriId(Integer altKategoriId) {
        this.altKategoriId = altKategoriId;
    }

    public Integer getBirimId() {
        return birimId;
    }

    public void setBirimId(Integer birimId) {
        this.birimId = birimId;
    }

    public BigDecimal getGuncelSatisFiyati() {
        return guncelSatisFiyati;
    }

    public void setGuncelSatisFiyati(BigDecimal guncelSatisFiyati) {
        this.guncelSatisFiyati = guncelSatisFiyati;
    }

    public String getNotlar() {
        return notlar;
    }

    public void setNotlar(String notlar) {
        this.notlar = notlar;
    }
}
