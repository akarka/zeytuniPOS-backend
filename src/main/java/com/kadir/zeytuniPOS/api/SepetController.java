package com.kadir.zeytuniPOS.api;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.kadir.zeytuniPOS.core.SepetService;
import com.kadir.zeytuniPOS.core.security.SecurityUtil;
import com.kadir.zeytuniPOS.dto.SepetCreateDTO;
import com.kadir.zeytuniPOS.dto.SepetDTO;
import com.kadir.zeytuniPOS.dto.SepetUpdateDTO;

@RestController
@RequestMapping("/api/sepet")
public class SepetController {

    private final SepetService service;

    public SepetController(SepetService service) {
        this.service = service;
    }

    private void checkYetki(int... izinliRoller) {
        Integer rolId = SecurityUtil.getCurrentUserRolId();
        if (rolId == null || Arrays.stream(izinliRoller).noneMatch(id -> id == rolId)) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Bu işlem için yetkiniz yok.");
        }
    }

    @GetMapping("/dto")
    public List<SepetDTO> getAllDTO() {
        checkYetki(1, 2, 3);
        return service.getAllDTO();
    }

    @PostMapping("/dto")
    public SepetDTO create(@RequestBody SepetCreateDTO dto) {
        checkYetki(1, 2, 3);
        return service.createFromDTO(dto);
    }

    @PutMapping("/dto")
    public SepetDTO update(@RequestBody SepetUpdateDTO dto) {
        checkYetki(1, 2, 3);
        return service.update(dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        checkYetki(1, 2, 3);
        service.deleteById(id);
    }
}