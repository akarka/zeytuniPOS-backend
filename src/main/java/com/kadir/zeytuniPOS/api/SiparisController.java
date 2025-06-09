package com.kadir.zeytuniPOS.api;

import com.kadir.zeytuniPOS.dto.SiparisCreateDTO;
import com.kadir.zeytuniPOS.dto.SiparisDTO;
import com.kadir.zeytuniPOS.core.security.SecurityUtil;
import com.kadir.zeytuniPOS.core.SiparisService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/siparisler")
public class SiparisController {

    private final SiparisService siparisService;

    public SiparisController(SiparisService siparisService) {
        this.siparisService = siparisService;
    }

    @GetMapping
    public List<SiparisDTO> getAllSiparisDTOs() {
        return siparisService.getAllSiparisDTOs();
    }

    @GetMapping("/{id}")
    public SiparisDTO getSiparisById(@PathVariable Integer id) {
        return siparisService.getSiparisDTOById(id);
    }

    @PostMapping
    public SiparisDTO createSiparis(@RequestBody SiparisCreateDTO dto) {
        SecurityUtil.setCurrentUserId(2); // İleride authentication ile otomatik olacak
        try {
            return siparisService.createSiparisFromDTO(dto);
        } finally {
            SecurityUtil.clear();
        }
    }

    @PutMapping("/{id}")
    public SiparisDTO updateSiparis(@PathVariable Integer id, @RequestBody SiparisCreateDTO dto) {
        SecurityUtil.setCurrentUserId(2);
        try {
            return siparisService.updateSiparis(id, dto);
        } finally {
            SecurityUtil.clear();
        }
    }

    @DeleteMapping("/{id}")
    public void deleteSiparis(@PathVariable Integer id) {
        SecurityUtil.setCurrentUserId(2);
        try {
            siparisService.deleteSiparisById(id);
        } finally {
            SecurityUtil.clear();
        }
    }
}
