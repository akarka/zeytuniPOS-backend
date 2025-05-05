package com.kadir.zeytuniPOS.data;

import java.util.*;

public interface SatisRepository extends BaseRepository<Satis, Integer> {
   
   List<Satis> findByUrunId(Integer urunId);
}