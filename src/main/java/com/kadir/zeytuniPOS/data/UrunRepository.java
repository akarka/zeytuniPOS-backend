package com.kadir.zeytuniPOS.data;

import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UrunRepository extends BaseRepository<Urun, Integer> {

   List<Urun> findByAltKategoriAltkId(Integer altkId);

}
