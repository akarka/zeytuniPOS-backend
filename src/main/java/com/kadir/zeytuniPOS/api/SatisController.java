package com.kadir.zeytuniPOS.api;

import com.kadir.zeytuniPOS.core.SatisService;
import com.kadir.zeytuniPOS.core.security.SecurityUtil;
import com.kadir.zeytuniPOS.data.Satis;
import com.kadir.zeytuniPOS.dto.SatisCreateDTO;
import com.kadir.zeytuniPOS.dto.SatisDTO;
import com.kadir.zeytuniPOS.dto.SatisUpdateDTO;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/satislar")
public class SatisController extends BaseController<Satis, Integer> {

    private final SatisService service;

    public SatisController(SatisService service) {
        super(service);
        this.service = service;
    }

    private void checkYetki(int... izinliRoller) {
        Integer rolId = SecurityUtil.getCurrentUserRolId();
        if (rolId == null || Arrays.stream(izinliRoller).noneMatch(id -> id == rolId)) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Bu işlem için yetkiniz yok.");
        }
    }

    @GetMapping("/dto")
    public List<SatisDTO> getAllDTO() {
        checkYetki(1, 2, 3);
        return service.getAllDTO();
    }

    @PostMapping("/dto")
    public SatisDTO create(@RequestBody SatisCreateDTO dto) {
        checkYetki(1, 2, 3);
        return service.createFromDTO(dto);
    }

    @PutMapping("/dto")
    public SatisDTO update(@RequestBody SatisUpdateDTO dto) {
        checkYetki(1, 2, 3);
        return service.update(dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        checkYetki(1, 2);
        service.deleteById(id);
    }

    @PostMapping("/toplu")
    public void topluSatisYap(@RequestBody List<SatisCreateDTO> satislar) {
        checkYetki(1, 2, 3);
        for (SatisCreateDTO dto : satislar) {
            service.createFromDTO(dto);
        }
    }

}
