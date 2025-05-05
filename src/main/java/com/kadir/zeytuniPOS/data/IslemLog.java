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

    @ManyToOne
    @JoinColumn(name = "KullaniciID", nullable = false)
    private Kullanici kullanici;

    @Column(nullable = false)
    private Timestamp tarih = Timestamp.valueOf(LocalDateTime.now());

    @Column(nullable = false)
    private String islemTuru;

    @Column(nullable = false)
    private String hedefTablo;

    @Column(nullable = false)
    private Integer hedefId;

    @Column(nullable = false)
    private String aciklama;

    public Integer getLogId() {
        return logId;
    }

    public void setLogId(Integer logId) {
        this.logId = logId;
    }

    public Kullanici getKullanici() {
        return kullanici;
    }

    public void setKullanici(Kullanici kullanici) {
        this.kullanici = kullanici;
    }

    public Timestamp getTarih() {
        return tarih;
    }

    public void setTarih(Timestamp tarih) {
        this.tarih = tarih;
    }

    public String getIslemTuru() {
        return islemTuru;
    }

    public void setIslemTuru(String islemTuru) {
        this.islemTuru = islemTuru;
    }

    public String getHedefTablo() {
        return hedefTablo;
    }

    public void setHedefTablo(String hedefTablo) {
        this.hedefTablo = hedefTablo;
    }

    public Integer getHedefId() {
        return hedefId;
    }

    public void setHedefId(Integer hedefId) {
        this.hedefId = hedefId;
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }

}
