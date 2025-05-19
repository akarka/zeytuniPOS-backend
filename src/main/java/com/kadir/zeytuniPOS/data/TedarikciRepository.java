package com.kadir.zeytuniPOS.data;

import java.util.List;

public interface TedarikciRepository extends BaseRepository<Tedarikci, Integer> {

    List<Tedarikci> findByTedarikciId(Integer id);

}
