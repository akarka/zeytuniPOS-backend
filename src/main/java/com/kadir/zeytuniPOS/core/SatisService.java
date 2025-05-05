package com.kadir.zeytuniPOS.core;

import com.kadir.zeytuniPOS.data.Gecmis;
import com.kadir.zeytuniPOS.data.Satis;
import com.kadir.zeytuniPOS.data.SatisRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SatisService extends AbstractService<Satis, Integer> {

    private final GecmisService gecmisService;
    private final SatisRepository repository;

    public SatisService(SatisRepository repository, GecmisService gecmisService) {
        super(repository);
        this.gecmisService = gecmisService;
        this.repository = repository;

    }

    public List<Satis> getByUrunId(Integer urunId) {
        return repository.findByUrunId(urunId);
    }

    public List<Satis> getAll() {
        return repository.findAll();
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public Satis create(Satis satis) {
        Satis saved = super.create(satis);

        Gecmis gecmis = new Gecmis();
        gecmis.setUrunId(saved.getUrunID());
        gecmis.setSatisFiyati(saved.getSatisFiyati());
        gecmis.setSatisTarihi(saved.getSatisTarihi());
        gecmisService.create(gecmis);

        return saved;
    }

    public Satis update(Integer id, Satis guncelSatis) {
        Satis mevcutSatis = repository.findById(id).orElseThrow(() -> new RuntimeException("Satış bulunamadı."));

        mevcutSatis.setUrunID(guncelSatis.getUrunID());
        mevcutSatis.setMiktar(guncelSatis.getMiktar());
        mevcutSatis.setSatisFiyati(guncelSatis.getSatisFiyati());
        mevcutSatis.setSatisTarihi(guncelSatis.getSatisTarihi());

        return repository.save(mevcutSatis);

    }

}
