package com.kadir.zeytuniPOS.data;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "Satislar")
public class Satis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SatisID")
    private Integer satisId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "UrunID", referencedColumnName = "urunId")
    private Urun urun;

    @Column(name = "Miktar", nullable = false, length = 50)
    private Integer miktar;

    @Column(name = "SatisFiyati", nullable = true, length = 50)
    private Integer satisFiyati;

    @Column(name = "SatisTarihi", nullable = true)
    private LocalDateTime satisTarihi;

    public Integer getSatisId() {
        return satisId;
    }

    public void setSatisId(Integer satisId) {
        this.satisId = satisId;
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
