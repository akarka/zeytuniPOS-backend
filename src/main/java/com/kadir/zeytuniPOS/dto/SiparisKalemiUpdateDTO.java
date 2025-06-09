package com.kadir.zeytuniPOS.dto;

import java.math.BigDecimal;

public class SiparisKalemiUpdateDTO {
    private Integer siparisKalemId;
    private Integer urunId;
    private Integer miktar;
    private BigDecimal satisFiyati;

    public Integer getSiparisKalemId() {
        return siparisKalemId;
    }

    public void setSiparisKalemId(Integer siparisKalemId) {
        this.siparisKalemId = siparisKalemId;
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

    public BigDecimal getSatisFiyati() {
        return satisFiyati;
    }

    public void setSatisFiyati(BigDecimal satisFiyati) {
        this.satisFiyati = satisFiyati;
    }
}
