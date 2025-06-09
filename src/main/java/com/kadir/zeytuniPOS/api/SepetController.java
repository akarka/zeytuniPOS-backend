package com.kadir.zeytuniPOS.api;

import java.util.List;

import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/dto")
    public List<SepetDTO> getAllDTO() {
        return service.getAllDTO();
    }

    @PostMapping("/dto")
    public SepetDTO create(@RequestBody SepetCreateDTO dto) {
        SecurityUtil.setCurrentUserId(2); // Örnek kullanıcı ID(ileride authentication ile otomatik olacak)
        try {
            return service.createFromDTO(dto);
        } finally {
            SecurityUtil.clear(); // ThreadLocal'ı temizle
        }
    }

    @PutMapping("/dto")
    public SepetDTO update(@RequestBody SepetUpdateDTO dto) {
        SecurityUtil.setCurrentUserId(2); // Örnek kullanıcı ID(ileride authentication ile otomatik olacak)
        try {
            return service.update(dto);
        } finally {
            SecurityUtil.clear(); // ThreadLocal'ı temizle
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        SecurityUtil.setCurrentUserId(2); // Örnek kullanıcı ID(ileride authentication ile otomatik olacak)
        try {
            service.deleteById(id);
        } finally {
            SecurityUtil.clear(); // ThreadLocal'ı temizle
        }
    }
}