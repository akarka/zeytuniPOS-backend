package com.kadir.zeytuniPOS.api;

import org.springframework.web.bind.annotation.*;

import com.kadir.zeytuniPOS.core.TdrkAltKategoriService;
import com.kadir.zeytuniPOS.data.TdrkAltKategori;


@RestController
@RequestMapping("/api/tedarikcialtkategori")
public class TdrkAltKategoriController extends BaseController<TdrkAltKategori, Integer> {

    public TdrkAltKategoriController(TdrkAltKategoriService service){
        super(service);
    }
    
}
