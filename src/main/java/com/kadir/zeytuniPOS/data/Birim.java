package com.kadir.zeytuniPOS.data;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
@Table(name = "Birimler")
public class Birim implements Loglanabilir {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BirimID")
    private Long birimId;

    public Long getBirimId() {
        return birimId;
    }

    public void setBirimId(Long birimId) {
        this.birimId = birimId;
    }

    @Column(name = "BirimAdi", nullable = false, length = 50, unique = true)
    private String birimAdi;

    public String getBirimAdi() {
        return birimAdi;
    }

    public void setBirimAdi(String birimAdi) {
        this.birimAdi = birimAdi;
    }

    // LOGLAMA //
    @Override
    @JsonIgnore
    public Integer getHedefId() {
        return birimId.intValue();
    }

    @Override
    @JsonIgnore
    public String getHedefTablo() {
        return "UrunKategori";
    }

}
