package com.kadir.zeytuniPOS.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class EnvanterUpdateDTO {
    private Integer envanterId;
    private Integer urunId;
    private Integer tedarikciId;
    private BigDecimal stokMiktari;
    private LocalDate girisTarihi;

    public Integer getEnvanterId() {
        return envanterId;
    }

    public void setEnvanterId(Integer envanterId) {
        this.envanterId = envanterId;
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

    public BigDecimal getStokMiktari() {
        return stokMiktari;
    }

    public void setStokMiktari(BigDecimal stokMiktari) {
        this.stokMiktari = stokMiktari;
    }

    public LocalDate getGirisTarihi() {
        return girisTarihi;
    }

    public void setGirisTarihi(LocalDate girisTarihi) {
        this.girisTarihi = girisTarihi;
    }
}
