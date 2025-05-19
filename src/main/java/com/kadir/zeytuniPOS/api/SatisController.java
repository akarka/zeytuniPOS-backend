package com.kadir.zeytuniPOS.api;

import com.kadir.zeytuniPOS.core.SatisService;
import com.kadir.zeytuniPOS.data.Satis;
import com.kadir.zeytuniPOS.dto.*;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/satislar")
public class SatisController extends BaseController<Satis, Integer> {

    private final SatisService service;

    public SatisController(SatisService service) {
        super(service);
        this.service = service;
    }

    @GetMapping("/dto")
    public List<SatisDTO> getAllDTO() {
        return service.getAllDTO();
    }

    @PostMapping("/dto")
    public SatisDTO create(@RequestBody SatisCreateDTO dto) {
        return service.createFromDTO(dto);
    }

    @PutMapping("/dto")
    public SatisDTO update(@RequestBody SatisUpdateDTO dto) {
        return service.update(dto);
    }
}
