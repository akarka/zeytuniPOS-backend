package com.kadir.zeytuniPOS.api;

import com.kadir.zeytuniPOS.core.UrunTedarikciService;
import com.kadir.zeytuniPOS.core.security.SecurityUtil;
import com.kadir.zeytuniPOS.data.UrunTedarikci;
import com.kadir.zeytuniPOS.dto.UrunTedarikciCreateDTO;
import com.kadir.zeytuniPOS.dto.UrunTedarikciDTO;
import com.kadir.zeytuniPOS.dto.UrunTedarikciUpdateDTO;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/uruntedarikci")
public class UrunTedarikciController extends BaseController<UrunTedarikci, Integer> {

    private final UrunTedarikciService service;

    public UrunTedarikciController(UrunTedarikciService service) {
        super(service);
        this.service = service;
    }

    @GetMapping("/dto")
    public List<UrunTedarikciDTO> getAllUrunTedarikciler() {
        return service.getAllUrunTedarikciler();
    }

    @GetMapping("/dto/{id}")
    public UrunTedarikciDTO getUrunTedarikciById(@PathVariable Integer id) {
        return service.getUrunTedarikciById(id);
    }

    @PostMapping("/dto")
    public UrunTedarikciDTO create(@RequestBody UrunTedarikciCreateDTO dto) {
        SecurityUtil.setCurrentUserId(1); // Örnek kullanıcı ID(ileride authentication ile otomatik olacak)
        try {
            return service.createUrunTedarikci(dto);
        } finally {
            SecurityUtil.clear(); // ThreadLocal'ı temizle
        }
    }

    @PutMapping("/dto/{id}")
    public UrunTedarikciDTO update(@PathVariable Integer id, @RequestBody UrunTedarikciUpdateDTO updateDTO) {
        SecurityUtil.setCurrentUserId(3); // Örnek kullanıcı ID(ileride authentication ile otomatik olacak)
        try {
            return service.updateUrunTedarikci(id, updateDTO);
        } finally {
            SecurityUtil.clear(); // ThreadLocal'ı temizle
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        SecurityUtil.setCurrentUserId(2); // Örnek kullanıcı ID(ileride authentication ile otomatik olacak)
        try {
            service.deleteUrunTedarikci(id);
        } finally {
            SecurityUtil.clear(); // ThreadLocal'ı temizle
        }
    }

}
