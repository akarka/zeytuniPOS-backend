package com.kadir.zeytuniPOS.data;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
@Table(name = "Envanter")
public class Envanter implements Loglanabilir {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    public Integer envanterId;

    public Integer getEnvanterId() {
        return envanterId;
    }

    public void setEnvanterId(Integer envanterId) {
        this.envanterId = envanterId;
    }

    @Column(name = "UrunID", nullable = false, length = 50)
    private Integer urunId;

    public Integer getUrunId() {
        return urunId;
    }

    public void setUrunId(Integer urunId) {
        this.urunId = urunId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TedarikciID", nullable = false)
    private Tedarikci tedarikci;

    public Tedarikci getTedarikci() {
        return tedarikci;
    }

    public void setTedarikci(Tedarikci tedarikci) {
        this.tedarikci = tedarikci;
    }

    @Column(nullable = true)
    private Integer stokMiktari;

    public Integer getStokMiktari() {
        return stokMiktari;
    }

    public void setStokMiktari(Integer stokMiktari) {
        this.stokMiktari = stokMiktari;
    }

    @Column(nullable = false)
    private Timestamp girisTarihi = Timestamp.valueOf(LocalDateTime.now());

    public Timestamp getGirisTarihi() {
        return girisTarihi;
    }

    public void setGirisTarihi(Timestamp girisTarihi) {
        this.girisTarihi = girisTarihi;
    }

    // LOGLAMA //
    @Override
    @JsonIgnore
    public Integer getHedefId() {
        return this.envanterId;
    }

    @Override
    @JsonIgnore
    public String getHedefTablo() {
        return "UrunKategori";
    }
}
