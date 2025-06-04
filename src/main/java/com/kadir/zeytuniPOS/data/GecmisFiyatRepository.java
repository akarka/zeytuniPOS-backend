package com.kadir.zeytuniPOS.data;

import java.util.List;

public interface GecmisFiyatRepository extends BaseRepository<GecmisFiyat, Integer> {
    List<GecmisFiyat> findByUrun_UrunIdOrderByTarihDesc(Integer urunId);

}
