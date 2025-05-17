package com.kadir.zeytuniPOS.api;

import com.kadir.zeytuniPOS.core.BirimService;
import com.kadir.zeytuniPOS.data.Birim;
import com.kadir.zeytuniPOS.dto.BirimCreateDTO;
import com.kadir.zeytuniPOS.dto.BirimDTO;
import com.kadir.zeytuniPOS.dto.BirimUpdateDTO;

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

    @GetMapping("/dto")
    public List<BirimDTO> getAllDTO() {
        return service.getAllDTO();
    }

    @PostMapping("/dto")
    public BirimDTO create(@RequestBody BirimCreateDTO dto) {
        return service.createFromDTO(dto);
    }

    @DeleteMapping("/by-adi/{birimAdi}")
    public void deleteByAdi(@PathVariable String birimAdi) {
        service.deleteByBirimAdi(birimAdi);
    }

    @PutMapping("/dto")
    public BirimDTO update(@RequestBody BirimUpdateDTO dto) {
        return service.update(dto);
    }
}
