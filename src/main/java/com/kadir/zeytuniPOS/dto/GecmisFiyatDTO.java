package com.kadir.zeytuniPOS.dto;

import java.sql.Timestamp;

public class GecmisFiyatDTO {
    private Integer gecmisId;
    private String urunAdi;
    private Integer satisFiyati;
    private Timestamp satisTarihi;

    public Integer getGecmisId() {
        return gecmisId;
    }

    public void setGecmisId(Integer gecmisId) {
        this.gecmisId = gecmisId;
    }

    public String getUrunAdi() {
        return urunAdi;
    }

    public void setUrunAdi(String urunAdi) {
        this.urunAdi = urunAdi;
    }

    public Integer getSatisFiyati() {
        return satisFiyati;
    }

    public void setSatisFiyati(Integer satisFiyati) {
        this.satisFiyati = satisFiyati;
    }

    public Timestamp getSatisTarihi() {
        return satisTarihi;
    }

    public void setSatisTarihi(Timestamp satisTarihi) {
        this.satisTarihi = satisTarihi;
    }

}
