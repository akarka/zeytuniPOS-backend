package com.kadir.zeytuniPOS.data;

import java.util.*;

public interface UrunRepository extends BaseRepository<Urun, Integer> {
   List<Urun> findByUrunId(Integer id);
}