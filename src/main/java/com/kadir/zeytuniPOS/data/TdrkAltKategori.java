package com.kadir.zeytuniPOS.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;

@Entity
@Table(name = "TedarikciAltKategori")
public class TdrkAltKategori {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TedarikciAltKategoriID")
    private Integer tdrkAKId;

    public Integer getTdrkAKId() {
        return tdrkAKId;
    }

    public void setTdrkAKId(Integer tdrkAKId) {
        this.tdrkAKId = tdrkAKId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TedarikciID", nullable = false)
    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    private Tedarikci tedarikciId;

    public Tedarikci getTedarikciId() {
        return tedarikciId;
    }

    public void setTedarikciId(Tedarikci tedarikciId) {
        this.tedarikciId = tedarikciId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "AltKategoriID", nullable = false)
    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    private AltKategori altkId;

    public AltKategori getAltkId() {
        return altkId;
    }

    public void setAltkId(AltKategori altkId) {
        this.altkId = altkId;
    }

}
