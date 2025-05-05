package com.kadir.zeytuniPOS.core;

import com.kadir.zeytuniPOS.data.KullaniciRepository;
import com.kadir.zeytuniPOS.data.Kullanici;

import java.util.*;
import org.springframework.stereotype.Service;

@Service
public class KullaniciService extends AbstractService<Kullanici, Integer> {

    private final KullaniciRepository repository;

    public KullaniciService(KullaniciRepository repository) {
        super(repository);
        this.repository = repository;
    }

    public Optional<Kullanici> getByUsername(Integer kullaniciId) {
        return repository.findByKullaniciId(kullaniciId);
    }
}
