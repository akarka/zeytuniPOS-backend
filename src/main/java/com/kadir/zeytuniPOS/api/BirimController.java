package com.kadir.zeytuniPOS.api;

import com.kadir.zeytuniPOS.core.BirimService;
import com.kadir.zeytuniPOS.data.Birim;
import com.kadir.zeytuniPOS.dto.BirimDTO;

import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/birimler")
public class BirimController extends BaseController<Birim, Integer> {

    private final BirimService service;

    public BirimController(BirimService service) {
        super(service);
        this.service = service;
    }

    @GetMapping
    public List<BirimDTO> getAllBirimler() {
        return service.getAllDTO();
    }

}
