package com.kadir.zeytuniPOS.data;

import java.util.*;


public interface GecmisRepository extends BaseRepository<Gecmis, Integer> {

    List<Gecmis> findByUrunId(Integer urunId);
}
