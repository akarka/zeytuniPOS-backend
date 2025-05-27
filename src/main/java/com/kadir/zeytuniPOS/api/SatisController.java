package com.kadir.zeytuniPOS.api;

import com.kadir.zeytuniPOS.core.SatisService;
import com.kadir.zeytuniPOS.core.SecurityUtil;
import com.kadir.zeytuniPOS.data.Satis;
import com.kadir.zeytuniPOS.dto.*;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/satislar")
public class SatisController extends BaseController<Satis, Integer> {

    private final SatisService service;

    public SatisController(SatisService service) {
        super(service);
        this.service = service;
    }

    @GetMapping("/dto")
    public List<SatisDTO> getAllDTO() {
        return service.getAllDTO();
    }

    @PostMapping("/dto")
    public SatisDTO create(@RequestBody SatisCreateDTO dto) {
        SecurityUtil.setCurrentUserId(2); // Örnek kullanıcı ID(ileride authentication ile otomatik olacak)
        try {
            return service.createFromDTO(dto);
        } finally {
            SecurityUtil.clear(); // ThreadLocal'ı temizle
        }
    }

    @PutMapping("/dto")
    public SatisDTO update(@RequestBody SatisUpdateDTO dto) {
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
