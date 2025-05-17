package com.kadir.zeytuniPOS.data;

import java.util.Optional;

public interface UrunKategorileriRepository extends BaseRepository<UrunKategorileri, Integer> {

    Optional<UrunKategorileri> findByUrunKategoriAdi(String urunKategoriAdi);
}
