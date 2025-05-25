package com.kadir.zeytuniPOS.api;

import com.kadir.zeytuniPOS.core.UrunService;
import com.kadir.zeytuniPOS.core.SecurityUtil;
import com.kadir.zeytuniPOS.data.Urun;
import com.kadir.zeytuniPOS.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/urunler")
public class UrunController extends BaseController<Urun, Integer> {

    private final UrunService service;

    @Autowired
    public UrunController(UrunService service) {
        super(service);
        this.service = service;
    }

    @GetMapping("/dto")
    public List<UrunDTO> getAllDTO() {
        return service.getAllDTO();
    }

    @GetMapping("/dto/{id}")
    public UrunDTO getByIdDTO(@PathVariable Integer id) {
        return service.getByIdDTO(id);
    }

    @PostMapping("/dto")
    public UrunDTO create(@RequestBody UrunDTOCreate dto) {
        SecurityUtil.setCurrentUserId(2); // Örnek kullanıcı ID(ileride authentication ile otomatik olacak)
        try {
            return service.createFromDTO(dto);
        } finally {
            SecurityUtil.clear(); // ThreadLocal'ı temizle
        }
    }

    @PutMapping("/dto")
    public UrunDTO update(@RequestBody UrunDTOUpdate dto) {
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

    @GetMapping("/search/category/{altKategoriId}")
    public List<UrunDTO> findByAltkId(@PathVariable Integer altkId) {
        return service.findByAltkId(altkId);
    }

}
