package com.kadir.zeytuniPOS.api;

import com.kadir.zeytuniPOS.core.TedarikciService;
import com.kadir.zeytuniPOS.data.Tedarikci;
import com.kadir.zeytuniPOS.dto.*;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tedarikciler")
public class TedarikciController extends BaseController<Tedarikci, Integer> {

    private final TedarikciService service;

    public TedarikciController(TedarikciService service) {
        super(service);
        this.service = service;
    }

    @GetMapping("/dto")
    public List<TedarikciDTO> getAllDTO() {
        return service.getAllDTO();
    }

    @PostMapping("/dto")
    public TedarikciDTO create(@RequestBody TedarikciCreateDTO dto) {
        return service.createFromDTO(dto);
    }

    @PutMapping("/dto")
    public TedarikciDTO update(@RequestBody TedarikciUpdateDTO dto) {
        return service.update(dto);
    }
}
