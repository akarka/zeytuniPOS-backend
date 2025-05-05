package com.kadir.zeytuniPOS.api;

import com.kadir.zeytuniPOS.core.SatisService;
import com.kadir.zeytuniPOS.data.Satis;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/satislar")
public class SatisController extends BaseController<Satis, Integer> {

    private final SatisService service;
    
    public SatisController(SatisService service) {
        super(service);
        this.service=service;
    }

    @GetMapping("/urun/{urunId}")
    public List<Satis> getByUrunId(@PathVariable Integer urunId) {
        return service.getByUrunId(urunId);
    }

}
