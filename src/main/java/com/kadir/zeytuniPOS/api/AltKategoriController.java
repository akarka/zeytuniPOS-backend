package com.kadir.zeytuniPOS.api;

import com.kadir.zeytuniPOS.data.AltKategori;
import com.kadir.zeytuniPOS.dto.AltKategoriCreateDTO;
import com.kadir.zeytuniPOS.dto.AltKategoriDTO;
import com.kadir.zeytuniPOS.dto.AltKategoriUpdateDTO;
import com.kadir.zeytuniPOS.core.AltKategoriService;

import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/altkategoriler")
public class AltKategoriController extends BaseController<AltKategori, Integer> {

    private final AltKategoriService service;

    public AltKategoriController(AltKategoriService service) {
        super(service);
        this.service = service;
    }

    @GetMapping("/dto")
    public List<AltKategoriDTO> getAllAltKategoriler() {
        return service.getAllDTO();
    }

    @PostMapping("/dto")
    public AltKategoriDTO create(@RequestBody AltKategoriCreateDTO dto) {
        return service.createFromDTO(dto);
    }

    @PutMapping("/dto")
    public AltKategoriDTO update(@RequestBody AltKategoriUpdateDTO dto) {
        return service.update(dto);
    }
}
