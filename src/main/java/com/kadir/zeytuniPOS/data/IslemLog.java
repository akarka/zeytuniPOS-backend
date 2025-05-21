package com.kadir.zeytuniPOS.data;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "islemlog")
public class IslemLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LogID", nullable = false)
    private Integer logId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "KullaniciID", nullable = false)
    private Kullanici kullanici;

    @Column(name = "Tarih", nullable = false)
    private LocalDateTime tarih;

    @Column(name = "IslemTuru", nullable = false)
    private String islemTuru;

    @Column(name = "HedefTablo", nullable = false)
    private String hedefTablo;

    @Column(name = "HedefID", nullable = true)
    private Integer hedefId;

    @Column(name = "Aciklama", nullable = true)
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

    public LocalDateTime getTarih() {
        return tarih;
    }

    public void setTarih(LocalDateTime tarih) {
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
