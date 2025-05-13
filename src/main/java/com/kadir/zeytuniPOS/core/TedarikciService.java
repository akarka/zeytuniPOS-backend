package com.kadir.zeytuniPOS.core;

import com.kadir.zeytuniPOS.data.TedarikciRepository;
import com.kadir.zeytuniPOS.data.Tedarikci;

import org.springframework.stereotype.Service;

@Service
public class TedarikciService extends AbstractService<Tedarikci, Integer> {

    public TedarikciService(TedarikciRepository repository) {
        super(repository);
    }

    public Tedarikci getById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tedarikci bulunamadı: ID = " + id));
    }

    public Tedarikci update(Integer id, Tedarikci guncelTedarikci) {
        Tedarikci mevcutTedarikci = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tedarikci bulunamadi."));

        mevcutTedarikci.setTedarikciAdi(guncelTedarikci.getTedarikciAdi());
        mevcutTedarikci.setTedarikciIletisim(guncelTedarikci.getTedarikciIletisim());
        mevcutTedarikci.setTedarikciAdres(guncelTedarikci.getTedarikciAdres());

        return repository.save(mevcutTedarikci);

    }

}
