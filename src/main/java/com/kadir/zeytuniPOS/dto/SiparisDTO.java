package com.kadir.zeytuniPOS.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class SiparisDTO {
    private Integer siparisId;
    private Integer musteriId;
    private BigDecimal toplamFiyat;
    private String siparisDurumu;
    private LocalDateTime siparisTarihi;
    private List<SiparisKalemiDTO> siparisKalemleri;

    public Integer getSiparisId() {
        return siparisId;
    }

    public void setSiparisId(Integer siparisId) {
        this.siparisId = siparisId;
    }

    public Integer getMusteriId() {
        return musteriId;
    }

    public void setMusteriId(Integer musteriId) {
        this.musteriId = musteriId;
    }

    public BigDecimal getToplamFiyat() {
        return toplamFiyat;
    }

    public void setToplamFiyat(BigDecimal toplamFiyat) {
        this.toplamFiyat = toplamFiyat;
    }

    public String getSiparisDurumu() {
        return siparisDurumu;
    }

    public void setSiparisDurumu(String siparisDurumu) {
        this.siparisDurumu = siparisDurumu;
    }

    public LocalDateTime getSiparisTarihi() {
        return siparisTarihi;
    }

    public void setSiparisTarihi(LocalDateTime siparisTarihi) {
        this.siparisTarihi = siparisTarihi;
    }

    public List<SiparisKalemiDTO> getSiparisKalemleri() {
        return siparisKalemleri;
    }

    public void setSiparisKalemleri(List<SiparisKalemiDTO> siparisKalemleri) {
        this.siparisKalemleri = siparisKalemleri;
    }
}
