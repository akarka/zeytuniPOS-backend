package com.kadir.zeytuniPOS.api;

import org.springframework.web.bind.annotation.*;

import com.kadir.zeytuniPOS.core.UrunKategorileriService;
import com.kadir.zeytuniPOS.data.UrunKategorileri;

@RestController
@RequestMapping("/api/urunkategorileri")
public class UrunKategorileriController extends BaseController<UrunKategorileri, Integer>{

    public UrunKategorileriController(UrunKategorileriService service){
        super(service);
    }
    
}
