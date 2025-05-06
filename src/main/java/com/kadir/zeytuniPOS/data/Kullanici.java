package com.kadir.zeytuniPOS.data;

import java.util.*;

import jakarta.persistence.*;

@Entity
@Table(name = "Kullanicilar")
public class Kullanici {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer kullaniciId;

    @Column(nullable = false, unique = true)
    private String kullaniciAdi;

    @Column(nullable = false)
    private String sifreHash;

    @Column(nullable = false)
    private boolean aktif = true;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "KullaniciRolleri", joinColumns = @JoinColumn(name = "KullaniciID"), inverseJoinColumns = @JoinColumn(name = "RolID"))
    private Set<Rol> roller = new HashSet<>();

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

    public boolean isAktif() {
        return aktif;
    }

    public void setAktif(boolean aktif) {
        this.aktif = aktif;
    }

    public Set<Rol> getRoller() {
        return roller;
    }

    public void setRoller(Set<Rol> roller) {
        this.roller = roller;
    }

}
