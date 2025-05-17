package com.kadir.zeytuniPOS.api;

import com.kadir.zeytuniPOS.core.UrunService;
import com.kadir.zeytuniPOS.data.Urun;
import com.kadir.zeytuniPOS.dto.*;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/urunler")
public class UrunController extends BaseController<Urun, Integer> {

    private final UrunService service;

    public UrunController(UrunService service) {
        super(service);
        this.service = service;
    }

    @GetMapping("/dto")
    public List<UrunDTO> getAllDTO() {
        return service.getAllDTO();
    }

    @PostMapping("/dto") // ❗ dikkat: /dto
    public UrunDTO create(@RequestBody UrunCreateDTO dto) {
        return service.createFromDTO(dto);
    }

    @PutMapping("/dto")
    public UrunDTO update(@RequestBody UrunUpdateDTO dto) {
        return service.update(dto);
    }
}
