package com.kadir.zeytuniPOS.api;

import com.kadir.zeytuniPOS.core.UrunKategorileriService;
import com.kadir.zeytuniPOS.core.security.SecurityUtil;
import com.kadir.zeytuniPOS.data.UrunKategorileri;
import com.kadir.zeytuniPOS.dto.*;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/urunkategorileri")
public class UrunKategorileriController extends BaseController<UrunKategorileri, Integer> {

    private final UrunKategorileriService service;

    public UrunKategorileriController(UrunKategorileriService service) {
        super(service);
        this.service = service;
    }

    @GetMapping("/dto")
    public List<UrunKategorileriDTO> getAllDTO() {
        return service.getAllDTO();
    }

    @PostMapping("/dto")
    public UrunKategorileriDTO create(@RequestBody UrunKategorileriCreateDTO dto) {
        SecurityUtil.setCurrentUserId(2); // Örnek kullanıcı ID(ileride authentication ile otomatik olacak)
        try {
            return service.createFromDTO(dto);
        } finally {
            SecurityUtil.clear(); // ThreadLocal'ı temizle
        }
    }

    @PutMapping("/dto")
    public UrunKategorileriDTO update(@RequestBody UrunKategorileriUpdateDTO dto) {
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
