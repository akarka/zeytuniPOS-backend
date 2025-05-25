package com.kadir.zeytuniPOS.api;

import com.kadir.zeytuniPOS.core.BirimService;
import com.kadir.zeytuniPOS.data.Birim;
import com.kadir.zeytuniPOS.dto.BirimDTOCreate;
import com.kadir.zeytuniPOS.dto.BirimDTO;
import com.kadir.zeytuniPOS.dto.BirimDTOUpdate;

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
    public BirimDTO create(@RequestBody BirimDTOCreate dto) {
        return service.createFromDTO(dto);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(Integer id) {
        service.deleteById(id);
    }

    @PutMapping("/dto")
    public BirimDTO update(@RequestBody BirimDTOUpdate dto) {
        return service.update(dto);
    }
}
