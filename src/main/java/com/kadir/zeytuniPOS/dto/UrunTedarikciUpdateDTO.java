package com.kadir.zeytuniPOS.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class UrunTedarikciUpdateDTO {
    private Integer urunTedarikciId;
    private Integer urunId;
    private Integer tedarikciId;
    private BigDecimal alisFiyati;
    private LocalDate tarih;

    public Integer getUrunTedarikciId() {
        return urunTedarikciId;
    }

    public void setUrunTedarikciId(Integer urunTedarikciId) {
        this.urunTedarikciId = urunTedarikciId;
    }

    public Integer getUrunId() {
        return urunId;
    }

    public void setUrunId(Integer urunId) {
        this.urunId = urunId;
    }

    public Integer getTedarikciId() {
        return tedarikciId;
    }

    public void setTedarikciId(Integer tedarikciId) {
        this.tedarikciId = tedarikciId;
    }

    public BigDecimal getAlisFiyati() {
        return alisFiyati;
    }

    public void setAlisFiyati(BigDecimal alisFiyati) {
        this.alisFiyati = alisFiyati;
    }

    public LocalDate getTarih() {
        return tarih;
    }

    public void setTarih(LocalDate tarih) {
        this.tarih = tarih;
    }
}
