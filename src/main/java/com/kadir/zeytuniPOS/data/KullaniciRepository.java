package com.kadir.zeytuniPOS.data;

import java.util.*;

public interface KullaniciRepository extends BaseRepository<Kullanici, Integer> {
    Optional<Kullanici> findByKullaniciId(Integer kullaniciId);
}
