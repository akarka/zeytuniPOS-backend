package com.kadir.zeytuniPOS.core;

import com.kadir.zeytuniPOS.data.IslemLogRepository;
import com.kadir.zeytuniPOS.data.Kullanici;
import com.kadir.zeytuniPOS.data.KullaniciRepository;
import com.kadir.zeytuniPOS.data.IslemLog;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

@Service
public class IslemLogService extends AbstractService<IslemLog, Integer> {

    private final IslemLogRepository repository;
    private final KullaniciRepository kulRepo;

    public IslemLogService(IslemLogRepository repository, KullaniciRepository kulRepo) {
        super(repository);
        this.repository = repository;
        this.kulRepo=kulRepo;
    }

    public void logger(Integer kullaniciId, String islemTuru, String hedefTablo, Integer hedefId) {
        IslemLog logger = new IslemLog();

        Kullanici kullanici = kulRepo.findById(kullaniciId)
            .orElseThrow(() -> new RuntimeException("Kullanıcı bulunamadı."));

        logger.setKullanici(kullanici);
        logger.setIslemTuru(islemTuru);
        logger.setHedefTablo(hedefTablo);
        logger.setHedefId(hedefId);
        logger.setTarih(Timestamp.valueOf(LocalDateTime.now()));
        repository.save(logger);
    }

}
