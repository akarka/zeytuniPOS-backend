package com.kadir.zeytuniPOS.data;

import jakarta.persistence.*;

@Entity
@Table(name = "Birimler")
public class Birim {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BirimID")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "BirimAdi", nullable = false, length = 50)
    private String ad;

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

}
