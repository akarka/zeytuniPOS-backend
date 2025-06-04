package com.kadir.zeytuniPOS.dto;

public class KullaniciCreateDTO {
    private String kullaniciAdi;
    private String sifre;
    private Boolean aktif;
    private Integer rolAdi;
    private Integer rolId;

    public String getKullaniciAdi() {
        return kullaniciAdi;
    }

    public void setKullaniciAdi(String kullaniciAdi) {
        this.kullaniciAdi = kullaniciAdi;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    public Boolean getAktif() {
        return aktif;
    }

    public void setAktif(Boolean aktif) {
        this.aktif = aktif;
    }

    public Integer getRolAdi() {
        return rolAdi;
    }

    public void setRolAdi(Integer rolAdi) {
        this.rolAdi = rolAdi;
    }

    public Integer getRolId() {
        return rolId;
    }

    public void setRolId(Integer rolId) {
        this.rolId = rolId;
    }
}
