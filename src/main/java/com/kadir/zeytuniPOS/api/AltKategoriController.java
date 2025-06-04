package com.kadir.zeytuniPOS.api;

import com.kadir.zeytuniPOS.data.AltKategori;
import com.kadir.zeytuniPOS.dto.AltKategoriCreateDTO;
import com.kadir.zeytuniPOS.dto.AltKategoriDTO;
import com.kadir.zeytuniPOS.dto.AltKategoriUpdateDTO;
import com.kadir.zeytuniPOS.core.AltKategoriService;
import com.kadir.zeytuniPOS.core.security.SecurityUtil;

import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/altkategoriler")
public class AltKategoriController extends BaseController<AltKategori, Integer> {

    private final AltKategoriService service;

    public AltKategoriController(AltKategoriService service) {
        super(service);
        this.service = service;
    }

    @GetMapping("/dto")
    public List<AltKategoriDTO> getAllAltKategoriler() {
        return service.getAllDTO();
    }

    @PostMapping("/dto")
    public AltKategoriDTO create(@RequestBody AltKategoriCreateDTO dto) {
        SecurityUtil.setCurrentUserId(1); // Örnek kullanıcı ID(ileride authentication ile otomatik olacak)
        try {
            return service.createFromDTO(dto);
        } finally {
            SecurityUtil.clear(); // ThreadLocal'ı temizle
        }
    }

    @PutMapping("/dto")
    public AltKategoriDTO update(@RequestBody AltKategoriUpdateDTO dto) {
        SecurityUtil.setCurrentUserId(3); // Örnek kullanıcı ID(ileride authentication ile otomatik olacak)
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
