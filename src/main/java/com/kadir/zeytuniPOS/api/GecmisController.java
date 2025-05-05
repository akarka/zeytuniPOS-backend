package com.kadir.zeytuniPOS.api;

import com.kadir.zeytuniPOS.core.GecmisService;
import com.kadir.zeytuniPOS.data.Gecmis;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/gecmis")
public class GecmisController extends BaseController<Gecmis, Integer> {

    public GecmisController(GecmisService service) {
        super(service);
    }

}
