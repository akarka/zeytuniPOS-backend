package com.kadir.zeytuniPOS.api;

import com.kadir.zeytuniPOS.core.KullaniciService;
import com.kadir.zeytuniPOS.data.Kullanici;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/kullanicilar")
public class KullaniciController extends BaseController<Kullanici, Integer> {

    public KullaniciController(KullaniciService service) {
        super(service);
    }

}
