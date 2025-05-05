package com.kadir.zeytuniPOS.data;

import jakarta.persistence.*;

@Entity
@Table(name = "Satislar")
public class Satis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SatisID")
    private Integer id;

    @Column(name = "UrunID", nullable = false, length = 50)
    private Integer urunId;

    @Column(name = "Miktar", nullable = false, length = 50)
    private Integer miktar;

    @Column(name = "SatisFiyati", nullable = true, length = 50)
    private Integer SatisFiyati;

    @Column(name = "SatisTarihi", nullable = true, length = 8)
    private java.sql.Timestamp SatisTarihi;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUrunID() {
        return urunId;
    }

    public void setUrunID(Integer urunId) {
        this.urunId = urunId;
    }

    public Integer getMiktar() {
        return miktar;
    }

    public void setMiktar(Integer miktar) {
        this.miktar = miktar;
    }

    public Integer getSatisFiyati() {
        return SatisFiyati;
    }

    public void setSatisFiyati(Integer satisFiyati) {
        SatisFiyati = satisFiyati;
    }

    public java.sql.Timestamp getSatisTarihi() {
        return SatisTarihi;
    }

    public void setSatisTarihi(java.sql.Timestamp satisTarihi) {
        SatisTarihi = satisTarihi;
    }

}
