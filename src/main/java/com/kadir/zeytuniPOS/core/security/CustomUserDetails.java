package com.kadir.zeytuniPOS.core.security;

import com.kadir.zeytuniPOS.data.Kullanici;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class CustomUserDetails implements UserDetails {

    private final Kullanici kullanici;

    public CustomUserDetails(Kullanici kullanici) {
        this.kullanici = kullanici;
    }

    public Integer getId() {
        return kullanici.getKullaniciId();
    }

    public String getAdSoyad() {
        return kullanici.getKullaniciAdi();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Rol sistemi eklendiğinde burası genişletilecek
        return Collections.emptyList();
    }

    @Override
    public String getPassword() {
        return kullanici.getSifreHash();
    }

    @Override
    public String getUsername() {
        return kullanici.getKullaniciAdi();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public Kullanici getKullanici() {
        return kullanici;
    }
}
