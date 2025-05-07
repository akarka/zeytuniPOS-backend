package com.kadir.zeytuniPOS.api;

import com.kadir.zeytuniPOS.core.IslemLogService;
import com.kadir.zeytuniPOS.core.UrunService;
import com.kadir.zeytuniPOS.data.Urun;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/urunler")
public class UrunController extends BaseController<Urun, Integer> {

    private final UrunService service;
    private final IslemLogService islemLogService;

    public UrunController(UrunService service, IslemLogService islemLogService) {
        super(service);
        this.service = service;
        this.islemLogService = islemLogService;
    }

    @GetMapping("/{urunId}")
    public List<Urun> getByUrunId(@PathVariable Integer urunId) {
        return service.getByUrunId(urunId);
    }

    @GetMapping
    public List<Urun> getAll() {
        return service.getAll();
    }

    @Override
    @PostMapping
    public Urun create(@RequestBody Urun urun) {
        Urun kayit = service.create(urun);
        islemLogService.logger(1, kayit, "CREATE"); // loglama - sabit kullanıcı

        return kayit;
    }

    @PutMapping("/{urunId}")
    public Urun update(@PathVariable Integer urunId, @RequestBody Urun guncelleme) {
        return service.update(urunId, guncelleme);
    }

    @DeleteMapping("/{urunId}")
    public void delete(@PathVariable Integer urunId) {
        service.delete(urunId);
    }

}
