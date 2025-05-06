package com.kadir.zeytuniPOS.core;

import com.kadir.zeytuniPOS.data.Gecmis;
import com.kadir.zeytuniPOS.data.GecmisRepository;
import com.kadir.zeytuniPOS.data.Satis;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class GecmisService extends AbstractService<Gecmis, Integer> {

    private final GecmisRepository repository;

    public GecmisService(GecmisRepository repository) {
        super(repository);
        this.repository = repository;
    }

    public List<Gecmis> getByUrunID(Integer urunId) {
        return repository.findByUrunId(urunId);
    }

    public void satisKaydi(Satis satis) {
        Gecmis gecmis = new Gecmis();
        gecmis.setUrunId(satis.getUrunId());
        gecmis.setSatisFiyati(satis.getSatisFiyati());
        gecmis.setSatisTarihi(satis.getSatisTarihi());

        repository.save(gecmis);
    }

}
