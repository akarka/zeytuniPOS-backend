package com.kadir.zeytuniPOS.api;

import com.kadir.zeytuniPOS.core.SecurityUtil;
import com.kadir.zeytuniPOS.core.TedarikciService;
import com.kadir.zeytuniPOS.data.Tedarikci;
import com.kadir.zeytuniPOS.dto.*;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tedarikciler")
public class TedarikciController extends BaseController<Tedarikci, Integer> {

    private final TedarikciService service;

    public TedarikciController(TedarikciService service) {
        super(service);
        this.service = service;
    }

    @GetMapping("/dto")
    public List<TedarikciDTO> getAllDTO() {
        return service.getAllDTO();
    }

    @PostMapping("/dto")
    public TedarikciDTO create(@RequestBody TedarikciCreateDTO dto) {
        SecurityUtil.setCurrentUserId(1); // Örnek kullanıcı ID(ileride authentication ile otomatik olacak)
        try {
            return service.createFromDTO(dto);
        } finally {
            SecurityUtil.clear(); // ThreadLocal'ı temizle
        }
    }

    @PutMapping("/dto")
    public TedarikciDTO update(@RequestBody TedarikciUpdateDTO dto) {
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
