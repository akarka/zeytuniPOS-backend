package com.kadir.zeytuniPOS.data;

import jakarta.persistence.*;

@Entity
@Table(name = "AltKategoriler")
public class AltKategori {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AltKategoriID", nullable = false, length = 50)
    private Integer altkId;

    public Integer getAltkId() {
        return altkId;
    }

    public void setAltkId(Integer altkId) {
        this.altkId = altkId;
    }

    @Column(name = "AltKategoriAdi", nullable = false, length = 50, unique = true)
    public String altkAdi;

    public String getAltkAdi() {
        return altkAdi;
    }

    public void setAltkAdi(String altkAdi) {
        this.altkAdi = altkAdi;
    }

    @ManyToOne(optional = false)
    @JoinColumn(name = "UrunKategoriID", referencedColumnName = "urunKategoriId")
    private UrunKategorileri urunKategorileri;

    public UrunKategorileri getUrunKategorileri() {
        return urunKategorileri;
    }

    public void setUrunKategorileri(UrunKategorileri urunKategorileri) {
        this.urunKategorileri = urunKategorileri;
    }

}
