package com.kadir.zeytuniPOS.data;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "uruntedarikci")
public class UrunTedarikci {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UrunTedarikciID", nullable = false)
    private Integer urunTedarikciId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "UrunID", referencedColumnName = "urunId", nullable = false)
    private Urun urun;

    @ManyToOne(optional = false)
    @JoinColumn(name = "TedarikciID", referencedColumnName = "tedarikciId", nullable = false)
    private Tedarikci tedarikci;

    @Column(name = "AlisFiyati", nullable = false)
    private BigDecimal alisFiyati;

    @Column(name = "Tarih", nullable = true)
    private LocalDate tarih;

    public Integer getUrunTedarikciId() {
        return urunTedarikciId;
    }

    public void setUrunTedarikciId(Integer urunTedarikciId) {
        this.urunTedarikciId = urunTedarikciId;
    }

    public Urun getUrun() {
        return urun;
    }

    public void setUrun(Urun urun) {
        this.urun = urun;
    }

    public Tedarikci getTedarikci() {
        return tedarikci;
    }

    public void setTedarikci(Tedarikci tedarikci) {
        this.tedarikci = tedarikci;
    }

    public BigDecimal getAlisFiyati() {
        return alisFiyati;
    }

    public void setAlisFiyati(BigDecimal alisFiyati) {
        this.alisFiyati = alisFiyati;
    }

    public LocalDate getTarih() {
        return tarih;
    }

    public void setTarih(LocalDate tarih) {
        this.tarih = tarih;
    }
}
