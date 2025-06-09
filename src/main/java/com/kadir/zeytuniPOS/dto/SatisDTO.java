package com.kadir.zeytuniPOS.dto;

import java.time.LocalDateTime;

public class SatisDTO {
    private Integer satisId;
    private Integer urunId;
    private Integer miktar;
    private Integer satisFiyati;
    private LocalDateTime satisTarihi;

    public Integer getSatisId() {
        return satisId;
    }

    public void setSatisId(Integer satisId) {
        this.satisId = satisId;
    }

    public Integer getUrunId() {
        return urunId;
    }

    public void setUrunId(Integer urunId) {
        this.urunId = urunId;
    }

    public Integer getMiktar() {
        return miktar;
    }

    public void setMiktar(Integer miktar) {
        this.miktar = miktar;
    }

    public Integer getSatisFiyati() {
        return satisFiyati;
    }

    public void setSatisFiyati(Integer satisFiyati) {
        this.satisFiyati = satisFiyati;
    }

    public LocalDateTime getSatisTarihi() {
        return satisTarihi;
    }

    public void setSatisTarihi(LocalDateTime satisTarihi) {
        this.satisTarihi = satisTarihi;
    }
}
