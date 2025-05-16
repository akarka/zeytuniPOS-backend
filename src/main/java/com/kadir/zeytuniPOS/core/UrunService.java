package com.kadir.zeytuniPOS.core;

import com.kadir.zeytuniPOS.data.Urun;
import com.kadir.zeytuniPOS.data.UrunRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UrunService extends AbstractService<Urun, Integer>{

    private final UrunRepository repository;

    public UrunService(UrunRepository repository) {
        super(repository);
        this.repository = repository;
    }

    public Urun create(Urun urun) {
        return repository.save(urun);
    }

    public void delete(Integer urunId) {
        repository.deleteById(urunId);
    }

    public List<Urun> getAll() {
        return repository.findAll();
    }

    public List<Urun> getByUrunId(Integer urunId) {
        return repository.findByUrunId(urunId);
    }

    public Urun update(Integer urunId, Urun guncel) {
        Urun mevcut = repository.findById(urunId).orElseThrow(() -> new RuntimeException("Geçersiz ürün ID."));
        mevcut.setUrunAdi(guncel.getUrunAdi());
        mevcut.setUrunAciklama(guncel.getUrunAciklama());
        mevcut.setAltId(guncel.getAltId());
        mevcut.setBirimId(guncel.getBirimId());
        mevcut.setSatisFiyati(guncel.getSatisFiyati());

        return repository.save(mevcut);
    }

}
