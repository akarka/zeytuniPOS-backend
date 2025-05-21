package com.kadir.zeytuniPOS.data;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "envanter")
public class Envanter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EnvanterID", nullable = false)
    private Integer envanterId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "UrunID", nullable = false)
    private Urun urun;

    @ManyToOne(optional = false)
    @JoinColumn(name = "TedarikciID", nullable = false)
    private Tedarikci tedarikci;

    @Column(name = "StokMiktari", nullable = true)
    private BigDecimal stokMiktari;

    @Column(name = "GirisTarihi", nullable = true)
    private LocalDate girisTarihi;

    public Integer getEnvanterId() {
        return envanterId;
    }

    public void setEnvanterId(Integer envanterId) {
        this.envanterId = envanterId;
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

    public BigDecimal getStokMiktari() {
        return stokMiktari;
    }

    public void setStokMiktari(BigDecimal stokMiktari) {
        this.stokMiktari = stokMiktari;
    }

    public LocalDate getGirisTarihi() {
        return girisTarihi;
    }

    public void setGirisTarihi(LocalDate girisTarihi) {
        this.girisTarihi = girisTarihi;
    }
}
