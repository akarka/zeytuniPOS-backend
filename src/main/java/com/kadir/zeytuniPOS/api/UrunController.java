package com.kadir.zeytuniPOS.api;

import com.kadir.zeytuniPOS.core.UrunService;
import com.kadir.zeytuniPOS.data.Urun;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/urunler")
public class UrunController extends BaseController<Urun, Integer>{

    private final UrunService service;

    public UrunController(UrunService service) {
        super(service);
        this.service = service;
    }

    @PostMapping
    public Urun create(@RequestBody Urun urun) {
        return service.create(urun);
    }

    @DeleteMapping("/{urunId}")
    public void delete(@PathVariable Integer urunId) {
        service.delete(urunId);
    }

    @GetMapping("/{urunId}")
    public List<Urun> getByUrunId(@PathVariable Integer urunId) {
        return service.getByUrunId(urunId);
    }

    @GetMapping
    public List<Urun> getAll() {
        return service.getAll();
    }

    @PutMapping("/{urunId}")
    public Urun update(@PathVariable Integer urunId, @RequestBody Urun guncelleme) {
        return service.update(urunId, guncelleme);
    }

}
