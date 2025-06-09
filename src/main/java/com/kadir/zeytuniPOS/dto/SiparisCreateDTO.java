package com.kadir.zeytuniPOS.dto;

import java.util.List;

public class SiparisCreateDTO {
    private Integer musteriId;
    private String siparisDurumu;
    private List<SiparisKalemiCreateDTO> siparisKalemleri;

    public Integer getMusteriId() {
        return musteriId;
    }

    public void setMusteriId(Integer musteriId) {
        this.musteriId = musteriId;
    }

    public String getSiparisDurumu() {
        return siparisDurumu;
    }

    public void setSiparisDurumu(String siparisDurumu) {
        this.siparisDurumu = siparisDurumu;
    }

    public List<SiparisKalemiCreateDTO> getSiparisKalemleri() {
        return siparisKalemleri;
    }

    public void setSiparisKalemleri(List<SiparisKalemiCreateDTO> siparisKalemleri) {
        this.siparisKalemleri = siparisKalemleri;
    }
}
