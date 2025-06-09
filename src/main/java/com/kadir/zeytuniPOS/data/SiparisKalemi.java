package com.kadir.zeytuniPOS.data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "SiparisKalemleri")
public class SiparisKalemi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer siparisKalemId;

    @ManyToOne
    @JoinColumn(name = "siparisId", nullable = false)
    private Siparis siparis;

    @ManyToOne
    @JoinColumn(name = "urunId", nullable = false)
    private Urun urun;

    private Integer miktar;

    private BigDecimal satisFiyati;

    private LocalDateTime eklenmeTarihi;

    public Integer getSiparisKalemId() {
        return siparisKalemId;
    }

    public void setSiparisKalemId(Integer siparisKalemId) {
        this.siparisKalemId = siparisKalemId;
    }

    public Siparis getSiparis() {
        return siparis;
    }

    public void setSiparis(Siparis siparis) {
        this.siparis = siparis;
    }

    public Urun getUrun() {
        return urun;
    }

    public void setUrun(Urun urun) {
        this.urun = urun;
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

    public SiparisKalemi() {
        this.eklenmeTarihi = LocalDateTime.now();
    }
}
