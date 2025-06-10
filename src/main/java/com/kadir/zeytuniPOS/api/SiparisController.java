package com.kadir.zeytuniPOS.api;

import com.kadir.zeytuniPOS.dto.SiparisCreateDTO;
import com.kadir.zeytuniPOS.dto.SiparisDTO;
import com.kadir.zeytuniPOS.core.security.SecurityUtil;
import com.kadir.zeytuniPOS.core.SiparisService;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/siparisler")
public class SiparisController {

    private final SiparisService siparisService;

    public SiparisController(SiparisService siparisService) {
        this.siparisService = siparisService;
    }

    private void checkYetki(int... izinliRoller) {
        Integer rolId = SecurityUtil.getCurrentUserRolId();
        if (rolId == null || Arrays.stream(izinliRoller).noneMatch(id -> id == rolId)) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Bu işlem için yetkiniz yok.");
        }
    }

    @GetMapping
    public List<SiparisDTO> getAllSiparisDTOs() {
        checkYetki(1, 2, 3);
        return siparisService.getAllSiparisDTOs();
    }

    @GetMapping("/{id}")
    public SiparisDTO getSiparisById(@PathVariable Integer id) {
        checkYetki(1, 2, 3);
        return siparisService.getSiparisDTOById(id);
    }

    @PostMapping
    public SiparisDTO createSiparis(@RequestBody SiparisCreateDTO dto) {
        checkYetki(1, 2, 3);
        return siparisService.createSiparisFromDTO(dto);
    }

    @PutMapping("/{id}")
    public SiparisDTO updateSiparis(@PathVariable Integer id, @RequestBody SiparisCreateDTO dto) {
        checkYetki(1, 2, 3);
        return siparisService.updateSiparis(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deleteSiparis(@PathVariable Integer id) {
        checkYetki(1, 2, 3);
        siparisService.deleteSiparisById(id);
    }
}
