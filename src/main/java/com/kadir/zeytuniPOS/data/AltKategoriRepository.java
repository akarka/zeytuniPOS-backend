package com.kadir.zeytuniPOS.data;

import java.util.Optional;

public interface AltKategoriRepository extends BaseRepository<AltKategori, Integer> {
    Optional<AltKategori> findByAltkAdi(String altkAdi);
}
