package com.kadir.zeytuniPOS.api;

import com.kadir.zeytuniPOS.dto.SiparisKalemiCreateDTO;
import com.kadir.zeytuniPOS.dto.SiparisKalemiDTO;
import com.kadir.zeytuniPOS.dto.SiparisKalemiUpdateDTO;
import com.kadir.zeytuniPOS.core.security.SecurityUtil;
import com.kadir.zeytuniPOS.core.SiparisKalemiService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/siparis-kalemleri")
public class SiparisKalemiController {

    private final SiparisKalemiService service;

    public SiparisKalemiController(SiparisKalemiService service) {
        this.service = service;
    }

    @GetMapping("/dto")
    public List<SiparisKalemiDTO> getAllDTO() {
        return service.getAllDTO();
    }

    @PostMapping("/dto")
    public SiparisKalemiDTO create(@RequestBody SiparisKalemiCreateDTO dto) {
        SecurityUtil.setCurrentUserId(2); // İleride authentication ile otomatik olacak
        try {
            return service.createFromDTO(dto);
        } finally {
            SecurityUtil.clear();
        }
    }

    @PutMapping("/dto")
    public SiparisKalemiDTO update(@RequestBody SiparisKalemiUpdateDTO dto) {
        SecurityUtil.setCurrentUserId(2);
        try {
            return service.update(dto);
        } finally {
            SecurityUtil.clear();
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        SecurityUtil.setCurrentUserId(2);
        try {
            service.deleteById(id);
        } finally {
            SecurityUtil.clear();
        }
    }
}
