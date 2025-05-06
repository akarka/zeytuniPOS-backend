package com.kadir.zeytuniPOS.api;

import com.kadir.zeytuniPOS.core.SatisService;
import com.kadir.zeytuniPOS.data.Satis;
import com.kadir.zeytuniPOS.core.IslemLogService;
import com.kadir.zeytuniPOS.core.GecmisService;
import com.kadir.zeytuniPOS.data.Gecmis;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/satislar")
public class SatisController extends BaseController<Satis, Integer> {

    private final SatisService satisService;
    private final IslemLogService islemLogService;
    private final GecmisService gecmisService;

    public SatisController(SatisService satisService, IslemLogService islemLogService, GecmisService gecmisService) {
        super(satisService);
        this.satisService = satisService;
        this.islemLogService = islemLogService;
        this.gecmisService = gecmisService;
    }

    @GetMapping("/urun/{urunId}")
    public List<Satis> getByUrunId(@PathVariable Integer urunId) {
        return satisService.getByUrunId(urunId);
    }
    
    @Override
    @PostMapping
    public Satis create(@RequestBody Satis satis) {
        Satis kayit = satisService.create(satis);
        islemLogService.logger(1, kayit, "CREATE"); // loglama - sabit kullanıcı

        Gecmis gecmis = new Gecmis(); // geçmiş fiyat kaydı
        gecmis.setUrunId(kayit.getUrunId());
        gecmis.setSatisFiyati(kayit.getSatisFiyati());
        gecmis.setSatisTarihi(kayit.getSatisTarihi());
        gecmisService.create(gecmis);

        return kayit;
    }

    @Override
    @PutMapping("/{id}")
    public Satis update(@PathVariable Integer id, @RequestBody Satis satis) {
        Satis guncellenmis = satisService.update(id, satis);
        islemLogService.logger(1, guncellenmis, "UPDATE"); // loglama - sabit kullanıcı
        return guncellenmis;
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        Satis silinecek = satisService.getById(id);
        satisService.delete(id);
        islemLogService.logger(1, silinecek, "DELETE"); // loglama - sabit kullanıcı
    }
}
