package com.kadir.zeytuniPOS.data;

import java.util.*;

public interface EnvanterRepository extends BaseRepository<Envanter, Integer>{
    Optional<Envanter> findByUrunIdAndTedarikci(Integer urunId, Tedarikci tedarikci);
    
}
