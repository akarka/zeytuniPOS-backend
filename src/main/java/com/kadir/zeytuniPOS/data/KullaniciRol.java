package com.kadir.zeytuniPOS.data;

import jakarta.persistence.*;

@Entity
@Table(name = "kullanicirolleri")
public class KullaniciRol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "KullaniciRolID")
    private Integer kullaniciRolId;

    @ManyToOne
    @JoinColumn(name = "KullaniciID", nullable = false)
    private Kullanici kullanici;

    @ManyToOne
    @JoinColumn(name = "RolID", nullable = false)
    private Rol rol;

    public KullaniciRol() {
    }

    public Integer getKullaniciRolId() {
        return kullaniciRolId;
    }

    public void setKullaniciRolId(Integer kullaniciRolId) {
        this.kullaniciRolId = kullaniciRolId;
    }

    public Kullanici getKullanici() {
        return kullanici;
    }

    public void setKullanici(Kullanici kullanici) {
        this.kullanici = kullanici;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
}
