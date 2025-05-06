package com.kadir.zeytuniPOS.core;

/*import com.kadir.zeytuniPOS.data.Gecmis;*/
import com.kadir.zeytuniPOS.data.Satis;
import com.kadir.zeytuniPOS.data.SatisRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class SatisService extends AbstractService<Satis, Integer> {

    /*private final GecmisService gecmisService;*/
    private final SatisRepository repository;

    public SatisService(SatisRepository repository, GecmisService gecmisService, IslemLogService islemLogService) {
        super(repository);
        /*this.gecmisService = gecmisService;*/
        this.repository = repository;

    }

    public List<Satis> getByUrunId(Integer urunId) {
        return repository.findByUrunId(urunId);
    }

    public List<Satis> getAll() {
        return repository.findAll();
    }

    public Satis getById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Satış bulunamadı: ID = " + id));
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public Satis create(Satis satis) {
        if (satis.getSatisTarihi() == null) {
            satis.setSatisTarihi(Timestamp.valueOf(LocalDateTime.now()));
        }
        Satis kayit = super.create(satis);

        /*Gecmis gecmis = new Gecmis();
        gecmis.setUrunId(kayit.getUrunId());
        gecmis.setSatisFiyati(kayit.getSatisFiyati());
        gecmis.setSatisTarihi(kayit.getSatisTarihi());
        gecmisService.create(gecmis);*/

        return kayit;
    }

    public Satis update(Integer id, Satis guncelSatis) {
        Satis mevcutSatis = repository.findById(id).orElseThrow(() -> new RuntimeException("Satis bulunamadi."));

        mevcutSatis.setUrunId(guncelSatis.getUrunId());
        mevcutSatis.setMiktar(guncelSatis.getMiktar());
        mevcutSatis.setSatisFiyati(guncelSatis.getSatisFiyati());
        mevcutSatis.setSatisTarihi(guncelSatis.getSatisTarihi());

        return repository.save(mevcutSatis);

    }

}
