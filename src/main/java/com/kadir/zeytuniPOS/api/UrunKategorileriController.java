package com.kadir.zeytuniPOS.api;

import com.kadir.zeytuniPOS.core.UrunKategorileriService;
import com.kadir.zeytuniPOS.data.UrunKategorileri;
import com.kadir.zeytuniPOS.dto.*;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/urunkategorileri")
public class UrunKategorileriController extends BaseController<UrunKategorileri, Integer> {

    private final UrunKategorileriService service;

    public UrunKategorileriController(UrunKategorileriService service) {
        super(service);
        this.service = service;
    }

    @GetMapping("/dto")
    public List<UrunKategorileriDTO> getAllDTO() {
        return service.getAllDTO();
    }

    @PostMapping("/dto")
    public UrunKategorileriDTO create(@RequestBody UrunKategorileriCreateDTO dto) {
        return service.createFromDTO(dto);
    }

    @PutMapping("/dto")
    public UrunKategorileriDTO update(@RequestBody UrunKategorileriUpdateDTO dto) {
        return service.update(dto);
    }
}
