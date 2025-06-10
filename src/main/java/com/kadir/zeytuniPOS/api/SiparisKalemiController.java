package com.kadir.zeytuniPOS.api;

import com.kadir.zeytuniPOS.dto.SiparisKalemiCreateDTO;
import com.kadir.zeytuniPOS.dto.SiparisKalemiDTO;
import com.kadir.zeytuniPOS.dto.SiparisKalemiUpdateDTO;
import com.kadir.zeytuniPOS.core.security.SecurityUtil;
import com.kadir.zeytuniPOS.core.SiparisKalemiService;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/siparis-kalemleri")
public class SiparisKalemiController {

    private final SiparisKalemiService service;

    public SiparisKalemiController(SiparisKalemiService service) {
        this.service = service;
    }

    private void checkYetki(int... izinliRoller) {
        Integer rolId = SecurityUtil.getCurrentUserRolId();
        if (rolId == null || Arrays.stream(izinliRoller).noneMatch(id -> id == rolId)) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Bu işlem için yetkiniz yok.");
        }
    }

    @GetMapping("/dto")
    public List<SiparisKalemiDTO> getAllDTO() {
        checkYetki(1, 2, 3);
        return service.getAllDTO();
    }

    @PostMapping("/dto")
    public SiparisKalemiDTO create(@RequestBody SiparisKalemiCreateDTO dto) {
        checkYetki(1, 2, 3);
        return service.createFromDTO(dto);
    }

    @PutMapping("/dto")
    public SiparisKalemiDTO update(@RequestBody SiparisKalemiUpdateDTO dto) {
        checkYetki(1, 2, 3);
        return service.update(dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        checkYetki(1, 2, 3);
        service.deleteById(id);
    }
}
