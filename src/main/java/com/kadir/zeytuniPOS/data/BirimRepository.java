package com.kadir.zeytuniPOS.data;

import java.util.Optional;

public interface BirimRepository extends BaseRepository<Birim, Integer> {
    Optional<Birim> findByBirimAdi(String birimAdi);

    Optional<Birim> findByBirimId(Integer birimId);

}
