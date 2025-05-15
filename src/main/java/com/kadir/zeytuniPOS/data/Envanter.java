package com.kadir.zeytuniPOS.data;

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

    @Column(nullable = false)
    private Integer tedarikciId;

    public Integer getTedarikciId() {
        return tedarikciId;
    }

    public void setTedarikciId(Integer tedarikciId) {
        this.tedarikciId = tedarikciId;
    }

    @Column(name = "BirimID", nullable = false)
    private Long birimId;

    public Long getId() {
        return birimId;
    }

    public void setbirimId(Long birimId) {
        this.birimId = birimId;
    }

    @Column(nullable = true)
    private Integer stokMiktari;

    public Integer getStokmiktar() {
        return stokMiktari;
    }

    public void setStokmiktar(Integer stokMiktari) {
        this.stokMiktari = stokMiktari;
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
