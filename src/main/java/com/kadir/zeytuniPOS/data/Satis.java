package com.kadir.zeytuniPOS.data;

import jakarta.persistence.*;

@Entity
@Table(name = "Satislar")
public class Satis{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SatisID")
    private Integer satisId;

    public Integer getSatisId() {
        return satisId;
    }

    public void setSatisId(Integer satisId) {
        this.satisId = satisId;
    }

    @ManyToOne(optional = false)
    @JoinColumn(name = "UrunID", referencedColumnName = "urunId")
    private Urun urun;

    public Urun getUrun() {
        return urun;
    }

    public void setUrun(Urun urun) {
        this.urun = urun;
    }

    @Column(name = "Miktar", nullable = false, length = 50)
    private Integer miktar;

    public Integer getMiktar() {
        return miktar;
    }

    public void setMiktar(Integer miktar) {
        this.miktar = miktar;
    }

    @Column(name = "SatisFiyati", nullable = true, length = 50)
    private Integer satisFiyati;

    public Integer getSatisFiyati() {
        return satisFiyati;
    }

    public void setSatisFiyati(Integer satisFiyati) {
        this.satisFiyati = satisFiyati;
    }

    @Column(name = "SatisTarihi", nullable = true, length = 8)
    private java.sql.Timestamp satisTarihi;

    public java.sql.Timestamp getSatisTarihi() {
        return satisTarihi;
    }

    public void setSatisTarihi(java.sql.Timestamp satisTarihi) {
        this.satisTarihi = satisTarihi;
    }

}
