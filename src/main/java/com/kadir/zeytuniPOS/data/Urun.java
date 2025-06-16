package com.kadir.zeytuniPOS.data;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "Urunler")
public class Urun {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UrunID")
    private Integer urunId;

    @Column(name = "UrunAdi", nullable = false, unique = true)
    private String urunAdi;

    @Column(name = "UrunAciklama")
    private String urunAciklama;

    @ManyToOne(optional = false)
    @JoinColumn(name = "AltKategoriID")
    private AltKategori altKategori;

    @ManyToOne(optional = false)
    @JoinColumn(name = "BirimID")
    private Birim birim;

    @Column(name = "GuncelSatisFiyati")
    private BigDecimal guncelSatisFiyati;

    @Column(name = "Notlar")
    private String notlar;

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

    public String getUrunAciklama() {
        return urunAciklama;
    }

    public void setUrunAciklama(String urunAciklama) {
        this.urunAciklama = urunAciklama;
    }

    public AltKategori getAltKategori() {
        return altKategori;
    }

    public void setAltKategori(AltKategori altKategori) {
        this.altKategori = altKategori;
    }

    public Birim getBirim() {
        return birim;
    }

    public void setBirim(Birim birim) {
        this.birim = birim;
    }

    public BigDecimal getGuncelSatisFiyati() {
        return guncelSatisFiyati;
    }

    public void setGuncelSatisFiyati(BigDecimal guncelSatisFiyati) {
        this.guncelSatisFiyati = guncelSatisFiyati;
    }

    public String getNotlar() {
        return notlar;
    }

    public void setNotlar(String notlar) {
        this.notlar = notlar;
    }
}
