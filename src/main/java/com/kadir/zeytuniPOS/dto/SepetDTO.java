package com.kadir.zeytuniPOS.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class SepetDTO {
    private Integer sepetId;
    private Integer urunId;
    private String urunAdi;
    private Integer miktar;
    private BigDecimal satisFiyati;
    private LocalDateTime eklenmeTarihi;

    public Integer getSepetId() {
        return sepetId;
    }

    public void setSepetId(Integer sepetId) {
        this.sepetId = sepetId;
    }

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

    public Integer getMiktar() {
        return miktar;
    }

    public void setMiktar(Integer miktar) {
        this.miktar = miktar;
    }

    public BigDecimal getSatisFiyati() {
        return satisFiyati;
    }

    public void setSatisFiyati(BigDecimal satisFiyati) {
        this.satisFiyati = satisFiyati;
    }

    public LocalDateTime getEklenmeTarihi() {
        return eklenmeTarihi;
    }

    public void setEklenmeTarihi(LocalDateTime eklenmeTarihi) {
        this.eklenmeTarihi = eklenmeTarihi;
    }

}