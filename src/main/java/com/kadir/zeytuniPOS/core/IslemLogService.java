package com.kadir.zeytuniPOS.core;

import com.kadir.zeytuniPOS.data.IslemLogRepository;
import com.kadir.zeytuniPOS.data.Kullanici;
import com.kadir.zeytuniPOS.data.KullaniciRepository;
import com.kadir.zeytuniPOS.data.Loglanabilir;
import com.kadir.zeytuniPOS.data.IslemLog;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.*;

import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

@Service
public class IslemLogService extends AbstractService<IslemLog, Integer> {

    private final IslemLogRepository repository;
    private final KullaniciRepository kulRepo;

    public IslemLogService(IslemLogRepository repository, KullaniciRepository kulRepo) {
        super(repository);
        this.repository = repository;
        this.kulRepo = kulRepo;
    }

    public List<IslemLog> getAll(Sort sort) {
    return repository.findAll(sort);
}

    public void logger(Integer kullaniciId, Loglanabilir entity, String islemTuru) {
        IslemLog logger = new IslemLog();

        Kullanici kullanici = kulRepo.findById(kullaniciId)
                .orElseThrow(() -> new RuntimeException("Kullanıcı bulunamadı."));

        logger.setKullanici(kullanici);
        logger.setIslemTuru(islemTuru);
        logger.setHedefTablo(entity.getHedefTablo());
        logger.setHedefId(entity.getHedefId());
        logger.setTarih(Timestamp.valueOf(LocalDateTime.now()));

        repository.save(logger);
    }



}
