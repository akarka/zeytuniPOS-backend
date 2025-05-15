package com.kadir.zeytuniPOS.api;

import com.kadir.zeytuniPOS.data.Envanter;
import com.kadir.zeytuniPOS.core.EnvanterService;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/envanter")
public class EnvanterController extends BaseController<Envanter, Integer> {

    public EnvanterController(EnvanterService service) {
        super(service);
    }

}
