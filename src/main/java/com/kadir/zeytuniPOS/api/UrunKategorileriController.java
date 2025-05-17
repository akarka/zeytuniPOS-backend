package com.kadir.zeytuniPOS.api;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.kadir.zeytuniPOS.core.UrunKategorileriService;
import com.kadir.zeytuniPOS.data.UrunKategorileri;
import com.kadir.zeytuniPOS.dto.UrunKategoriDTO;

@RestController
@RequestMapping("/api/urunkategorileri")
public class UrunKategorileriController extends BaseController<UrunKategorileri, Integer> {

    private final UrunKategorileriService service;

    public UrunKategorileriController(UrunKategorileriService service) {
        super(service);
        this.service = service;
    }

    @GetMapping
    public List<UrunKategoriDTO> getAllDTO() {
        return service.getAllDTO();
    }

}
