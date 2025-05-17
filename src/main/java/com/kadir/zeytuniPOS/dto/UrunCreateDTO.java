package com.kadir.zeytuniPOS.dto;

public class UrunCreateDTO {
    private Integer urunId;

    private String urunAdi;
    private Integer birimId;
    private Integer altKategoriId;

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

    public Integer getBirimId() {
        return birimId;
    }

    public void setBirimId(Integer birimId) {
        this.birimId = birimId;
    }

    public Integer getAltKategoriId() {
        return altKategoriId;
    }

    public void setAltKategoriId(Integer altKategoriId) {
        this.altKategoriId = altKategoriId;
    }
}
