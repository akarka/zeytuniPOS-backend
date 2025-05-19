package com.kadir.zeytuniPOS.data;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
@Table(name = "Tedarikciler")
public class Tedarikci implements Loglanabilir {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tedarikciId;

    public Integer getTedarikciId() {
        return tedarikciId;
    }

    public void setTedarikciId(Integer tedarikciId) {
        this.tedarikciId = tedarikciId;
    }

    @Column(nullable = false, unique = true)
    private String tedarikciAdi;

    public String getTedarikciAdi() {
        return tedarikciAdi;
    }

    public void setTedarikciAdi(String tedarikciAdi) {
        this.tedarikciAdi = tedarikciAdi;
    }

    @Column(nullable = true)
    private String tedarikciIletisim;

    public String getTedarikciIletisim() {
        return tedarikciIletisim;
    }

    public void setTedarikciIletisim(String tedarikciIletisim) {
        this.tedarikciIletisim = tedarikciIletisim;
    }

    @Column(nullable = true)
    private String tedarikciAdres;

    public String getTedarikciAdres() {
        return tedarikciAdres;
    }

    public void setTedarikciAdres(String tedarikciAdres) {
        this.tedarikciAdres = tedarikciAdres;
    }

    // LOGLAMA //
    @Override
    @JsonIgnore
    public Integer getHedefId() {
        return this.tedarikciId;
    }

    @Override
    @JsonIgnore
    public String getHedefTablo() {
        return "Tedarikciler";
    }

}
