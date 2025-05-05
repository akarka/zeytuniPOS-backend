package com.kadir.zeytuniPOS.data;

import java.util.*;

public interface IslemLogRepository extends BaseRepository<IslemLog, Integer> {
    List<IslemLog> findByHedefTabloAndHedefId(String tablo, Integer hedefId);

}
