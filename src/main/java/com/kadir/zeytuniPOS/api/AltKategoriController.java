package com.kadir.zeytuniPOS.api;

import org.springframework.web.bind.annotation.*;

import com.kadir.zeytuniPOS.data.AltKategori;
import com.kadir.zeytuniPOS.core.AltKategoriService;

@RestController
@RequestMapping("/api/altkategoriler")
public class AltKategoriController extends BaseController<AltKategori, Integer> {

    public AltKategoriController(AltKategoriService service) {
        super(service);
    }

}
