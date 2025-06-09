package com.kadir.zeytuniPOS.data;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "Siparis")
public class Siparis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer siparisId;

    private Integer musteriId; // Müşteri tablosuna referans için, eğer varsa

    private BigDecimal toplamFiyat;

    private String siparisDurumu;

    private LocalDateTime siparisTarihi;

    @OneToMany(mappedBy = "siparis", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SiparisKalemi> siparisKalemleri;

    public Siparis() {
        this.siparisTarihi = LocalDateTime.now();
        this.siparisDurumu = "Beklemede";
    }

    // Getters and Setters
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

    public List<SiparisKalemi> getSiparisKalemleri() {
        return siparisKalemleri;
    }

    public void setSiparisKalemleri(List<SiparisKalemi> siparisKalemleri) {
        this.siparisKalemleri = siparisKalemleri;
    }
}


