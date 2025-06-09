package com.kadir.zeytuniPOS.data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "Sepet")
public class Sepet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer sepetId;

    @ManyToOne
    @JoinColumn(name = "urunId", nullable = false)
    private Urun urun;

    private Integer miktar;

    private BigDecimal satisFiyati;

    private LocalDateTime eklenmeTarihi;

    public Integer getSepetId() {
        return sepetId;
    }

    public void setSepetId(Integer sepetId) {
        this.sepetId = sepetId;
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
}