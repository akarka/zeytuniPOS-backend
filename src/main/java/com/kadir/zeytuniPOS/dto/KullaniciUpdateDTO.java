package com.kadir.zeytuniPOS.dto;

public class KullaniciUpdateDTO {
    private Integer kullaniciId;
    private String kullaniciAdi;
    private String sifreHash;
    private Boolean aktif;

    private Integer rolAdi;
    private Integer rolId;

    public Integer getKullaniciId() {
        return kullaniciId;
    }

    public void setKullaniciId(Integer kullaniciId) {
        this.kullaniciId = kullaniciId;
    }

    public String getKullaniciAdi() {
        return kullaniciAdi;
    }

    public void setKullaniciAdi(String kullaniciAdi) {
        this.kullaniciAdi = kullaniciAdi;
    }

    public String getSifreHash() {
        return sifreHash;
    }

    public void setSifreHash(String sifreHash) {
        this.sifreHash = sifreHash;
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
