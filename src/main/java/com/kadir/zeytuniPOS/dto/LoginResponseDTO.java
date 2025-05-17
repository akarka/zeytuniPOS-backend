package com.kadir.zeytuniPOS.dto;

public class LoginResponseDTO {
    private Integer kullaniciId;
    private String kullaniciAdi;
    private String rol;

    public LoginResponseDTO(Integer id, String adi, String rol) {
        this.kullaniciId = id;
        this.kullaniciAdi = adi;
        this.rol = rol;
    }

    public Integer getKullaniciId() {
        return kullaniciId;
    }

    public String getKullaniciAdi() {
        return kullaniciAdi;
    }

    public String getRol() {
        return rol;
    }
}
