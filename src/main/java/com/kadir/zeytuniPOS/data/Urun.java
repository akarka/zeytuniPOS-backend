package com.kadir.zeytuniPOS.data;

import jakarta.persistence.*;

@Entity
@Table(name = "Urunler")
public class Urun {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer urunId;

    @Column(name = "UrunAdi", nullable = false)
    private String urunAdi;

    @ManyToOne(optional = false)
    @JoinColumn(name = "BirimID")
    private Birim birim;

    @ManyToOne(optional = false)
    @JoinColumn(name = "AltKategoriID")
    private AltKategori altKategori;

    public Integer getUrunId() {
        return urunId;
    }

    public void setUrunId(Integer urunId) {
        this.urunId = urunId;
    }

    public String getUrunAdi() {
        return urunAdi;
    }

    public void setUrunAdi(String urunAdi) {
        this.urunAdi = urunAdi;
    }

    public Birim getBirim() {
        return birim;
    }

    public void setBirim(Birim birim) {
        this.birim = birim;
    }

    public AltKategori getAltKategori() {
        return altKategori;
    }

    public void setAltKategori(AltKategori altKategori) {
        this.altKategori = altKategori;
    }
}
