package com.kadir.zeytuniPOS.data;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
@Table(name = "Kullanicilar")
public class Kullanici implements Loglanabilir {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer kullaniciId;

    public Integer getKullaniciId() {
        return kullaniciId;
    }

    public void setKullaniciId(Integer kullaniciId) {
        this.kullaniciId = kullaniciId;
    }

    @Column(nullable = false, unique = true)
    private String kullaniciAdi;

    public String getKullaniciAdi() {
        return kullaniciAdi;
    }

    public void setKullaniciAdi(String kullaniciAdi) {
        this.kullaniciAdi = kullaniciAdi;
    }

    @Column(nullable = false)
    private String sifreHash;

    public String getSifreHash() {
        return sifreHash;
    }

    public void setSifreHash(String sifreHash) {
        this.sifreHash = sifreHash;
    }

    @Column(nullable = false)
    private boolean aktif = true;

    public boolean isAktif() {
        return aktif;
    }

    public void setAktif(boolean aktif) {
        this.aktif = aktif;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "RolID", nullable = false)
    private Rol rol;

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    // LOGLAMA //
    @Override
    @JsonIgnore
    public Integer getHedefId() {
        return this.kullaniciId;
    }

    @Override
    @JsonIgnore
    public String getHedefTablo() {
        return "Kullanicilar";
    }

}
