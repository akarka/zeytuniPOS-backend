package com.kadir.zeytuniPOS.api;

import com.kadir.zeytuniPOS.core.BirimService;
import com.kadir.zeytuniPOS.data.Birim;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/birimler")
public class BirimController extends BaseController<Birim, Integer> {

    public BirimController(BirimService service) {
        super(service);
    }

}
