package com.kadir.zeytuniPOS.dto;

import java.time.LocalDateTime;

public class SatisCreateDTO {
    private Integer urunId;
    private Integer miktar;
    private Long satisFiyati;
    private LocalDateTime satisTarihi;
    private String notlar;

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

    public Long getSatisFiyati() {
        return satisFiyati;
    }

    public void setSatisFiyati(Long satisFiyati) {
        this.satisFiyati = satisFiyati;
    }

    public LocalDateTime getSatisTarihi() {
        return satisTarihi;
    }

    public void setSatisTarihi(LocalDateTime satisTarihi) {
        this.satisTarihi = satisTarihi;
    }

    public String getNotlar() {
        return notlar;
    }

    public void setNotlar(String notlar) {
        this.notlar = notlar;
    }
}
