package com.kadir.zeytuniPOS.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class GecmisFiyatCreateDTO {
    private Integer urunId;
    private BigDecimal satisFiyati;
    private LocalDate tarih;

    public Integer getUrunId() {
        return urunId;
    }

    public void setUrunId(Integer urunId) {
        this.urunId = urunId;
    }

    public BigDecimal getSatisFiyati() {
        return satisFiyati;
    }

    public void setSatisFiyati(BigDecimal satisFiyati) {
        this.satisFiyati = satisFiyati;
    }

    public LocalDate getTarih() {
        return tarih;
    }

    public void setTarih(LocalDate tarih) {
        this.tarih = tarih;
    }
}
