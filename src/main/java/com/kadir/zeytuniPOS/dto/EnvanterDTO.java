package com.kadir.zeytuniPOS.dto;

import java.sql.Timestamp;

public class EnvanterDTO {
    private Integer envanterId;
    private Integer urunId;
    private Integer tedarikciId;
    private Integer stokMiktari;
    private Timestamp girisTarihi;

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

    public Integer getStokMiktari() {
        return stokMiktari;
    }

    public void setStokMiktari(Integer stokMiktari) {
        this.stokMiktari = stokMiktari;
    }

    public Timestamp getGirisTarihi() {
        return girisTarihi;
    }

    public void setGirisTarihi(Timestamp girisTarihi) {
        this.girisTarihi = girisTarihi;
    }
}
