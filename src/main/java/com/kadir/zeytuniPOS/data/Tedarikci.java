package com.kadir.zeytuniPOS.data;

import jakarta.persistence.*;

@Entity
@Table(name = "Tedarikciler")
public class Tedarikci {

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

}
