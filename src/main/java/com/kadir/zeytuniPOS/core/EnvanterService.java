package com.kadir.zeytuniPOS.core;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.kadir.zeytuniPOS.data.Envanter;
import com.kadir.zeytuniPOS.data.EnvanterRepository;
import com.kadir.zeytuniPOS.data.Tedarikci;

@Service
public class EnvanterService extends AbstractService<Envanter, Integer> {

    private final EnvanterRepository repository;

    public EnvanterService(EnvanterRepository repository) {
        super(repository);
        this.repository = repository;
    }

    public void stokGir(Integer urunId, Integer stokMiktari, Tedarikci tedarikci) {
        Envanter envanter = repository.findByUrunIdAndTedarikci(urunId, tedarikci)
                .orElseGet(() -> {
                    Envanter yeni = new Envanter();
                    yeni.setUrunId(urunId);
                    yeni.setTedarikci(tedarikci);
                    yeni.setStokMiktari(0);
                    return yeni;
                });

        envanter.setStokMiktari(envanter.getStokMiktari() + stokMiktari);
        envanter.setGirisTarihi(Timestamp.valueOf(LocalDateTime.now()));
        repository.save(envanter);
    }

    public void stokCik(Integer urunId, Integer stokMiktari, Tedarikci tedarikci) {
        Envanter envanter = repository.findByUrunIdAndTedarikci(urunId, tedarikci)
                .orElseThrow(() -> new RuntimeException("Stok bulunamadı"));

        if (envanter.getStokMiktari() < stokMiktari) {
            throw new RuntimeException("Yetersiz stok");
        }

        envanter.setStokMiktari(envanter.getStokMiktari() - stokMiktari);
        envanter.setGirisTarihi(Timestamp.valueOf(LocalDateTime.now()));
        repository.save(envanter);
    }

    public double stokSorgula(Integer urunId, Tedarikci tedarikci) {
        return repository.findByUrunIdAndTedarikci(urunId, tedarikci)
                .map(Envanter::getStokMiktari)
                .orElse(0);
    }

}
