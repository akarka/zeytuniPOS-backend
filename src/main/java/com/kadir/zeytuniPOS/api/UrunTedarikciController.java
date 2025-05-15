package com.kadir.zeytuniPOS.api;

import org.springframework.web.bind.annotation.*;

import com.kadir.zeytuniPOS.core.UrunTedarikciService;
import com.kadir.zeytuniPOS.data.UrunTedarikci;

@RestController
@RequestMapping("/api/uruntedarikci")
public class UrunTedarikciController extends BaseController<UrunTedarikci, Integer>{

    public UrunTedarikciController(UrunTedarikciService service){
        super(service);
    }
    
}
