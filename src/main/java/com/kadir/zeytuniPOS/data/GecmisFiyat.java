package com.kadir.zeytuniPOS.data;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "gecmisfiyatlar")
public class GecmisFiyat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "GecmisFiyatID", nullable = false)
    private Integer gecmisFiyatId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "UrunID", nullable = false)
    private Urun urun;

    @Column(name = "SatisFiyati", nullable = true)
    private BigDecimal satisFiyati;

    @Column(name = "Tarih", nullable = true)
    private LocalDate tarih;

    public Integer getGecmisFiyatId() {
        return gecmisFiyatId;
    }

    public void setGecmisFiyatId(Integer gecmisFiyatId) {
        this.gecmisFiyatId = gecmisFiyatId;
    }

    public Urun getUrun() {
        return urun;
    }

    public void setUrun(Urun urun) {
        this.urun = urun;
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
