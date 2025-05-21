package com.kadir.zeytuniPOS.dto;

import java.time.LocalDateTime;

public class IslemLogCreateDTO {
    private Integer kullaniciId;
    private LocalDateTime tarih;
    private String islemTuru;
    private String hedefTablo;
    private Integer hedefId;
    private String aciklama;

    public Integer getKullaniciId() {
        return kullaniciId;
    }

    public void setKullaniciId(Integer kullaniciId) {
        this.kullaniciId = kullaniciId;
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
