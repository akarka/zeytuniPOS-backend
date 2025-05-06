package com.kadir.zeytuniPOS.data;

import java.sql.Timestamp;
import java.time.LocalDateTime;
//import java.util.*;

import jakarta.persistence.*;

@Entity
@Table(name = "IslemLog")
public class IslemLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer logId;

    public Integer getLogId() {
        return logId;
    }

    public void setLogId(Integer logId) {
        this.logId = logId;
    }

    @ManyToOne
    @JoinColumn(name = "KullaniciID", nullable = false)
    private Kullanici kullanici;

    public Kullanici getKullanici() {
        return kullanici;
    }

    public void setKullanici(Kullanici kullanici) {
        this.kullanici = kullanici;
    }

    @Column(nullable = false)
    private Timestamp tarih = Timestamp.valueOf(LocalDateTime.now());

    public Timestamp getTarih() {
        return tarih;
    }

    public void setTarih(Timestamp tarih) {
        this.tarih = tarih;
    }

    @Column(nullable = false)
    private String islemTuru;

    public String getIslemTuru() {
        return islemTuru;
    }

    public void setIslemTuru(String islemTuru) {
        this.islemTuru = islemTuru;
    }

    @Column(nullable = false)
    private String hedefTablo;

    public String getHedefTablo() {
        return hedefTablo;
    }

    public void setHedefTablo(String hedefTablo) {
        this.hedefTablo = hedefTablo;
    }

    @Column(nullable = false)
    private Integer hedefId;

    public Integer getHedefId() {
        return hedefId;
    }

    public void setHedefId(Integer hedefId) {
        this.hedefId = hedefId;
    }

    @Column(nullable = true)
    private String aciklama;

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }

}
