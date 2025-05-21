package com.kadir.zeytuniPOS.data;

import jakarta.persistence.*;

@Entity
@Table(name = "tedarikcialtkategori")
public class TedarikciAltKategori {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TedarikciAltKategoriID", nullable = false)
    private Integer tedarikciAltKategoriId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "TedarikciID", referencedColumnName = "tedarikciId", nullable = false)
    private Tedarikci tedarikci;

    @ManyToOne(optional = false)
    @JoinColumn(name = "AltKategoriID", referencedColumnName = "altKategoriId", nullable = false)
    private AltKategori altKategori;

    public Integer getTedarikciAltKategoriId() {
        return tedarikciAltKategoriId;
    }

    public void setTedarikciAltKategoriId(Integer tedarikciAltKategoriId) {
        this.tedarikciAltKategoriId = tedarikciAltKategoriId;
    }

    public Tedarikci getTedarikci() {
        return tedarikci;
    }

    public void setTedarikci(Tedarikci tedarikci) {
        this.tedarikci = tedarikci;
    }

    public AltKategori getAltKategori() {
        return altKategori;
    }

    public void setAltKategori(AltKategori altKategori) {
        this.altKategori = altKategori;
    }
}
