package com.kadir.zeytuniPOS.dto;

import java.math.BigDecimal;

public class UrunDTO {
    private Integer urunId;
    private String urunAdi;
    private String urunAciklama;
    private Integer altkId;
    private Integer birimId;
    private BigDecimal satisFiyati;

    public Integer getUrunId() {
        return urunId;
    }

    public void setUrunId(Integer urunId) {
        this.urunId = urunId;
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

    public Integer getAltkId() {
        return altkId;
    }

    public void setAltkId(Integer altkId) {
        this.altkId = altkId;
    }

    public Integer getBirimId() {
        return birimId;
    }

    public void setBirimId(Integer birimId) {
        this.birimId = birimId;
    }

    public BigDecimal getSatisFiyati() {
        return satisFiyati;
    }

    public void setSatisFiyati(BigDecimal satisFiyati) {
        this.satisFiyati = satisFiyati;
    }
}
