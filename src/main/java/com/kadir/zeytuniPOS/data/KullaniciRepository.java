package com.kadir.zeytuniPOS.data;

import java.util.Optional;

public interface KullaniciRepository extends BaseRepository<Kullanici, Integer> {

    Optional<Kullanici> findByKullaniciAdi(String kullaniciAdi);

}
