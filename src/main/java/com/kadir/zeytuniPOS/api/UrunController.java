package com.kadir.zeytuniPOS.api;

import com.kadir.zeytuniPOS.core.UrunService;
import com.kadir.zeytuniPOS.core.security.SecurityUtil;
import com.kadir.zeytuniPOS.data.Urun;
import com.kadir.zeytuniPOS.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;
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

    private void checkYetki(int... izinliRoller) {
        Integer rolId = SecurityUtil.getCurrentUserRolId();
        if (rolId == null || Arrays.stream(izinliRoller).noneMatch(id -> id == rolId)) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Bu işlem için yetkiniz yok.");
        }
    }

    @GetMapping("/dto")
    public List<UrunDTO> getAllDTO() {
        checkYetki(1, 2, 3);
        return service.getAllDTO();
    }

    @GetMapping("/dto/{id}")
    public UrunDTO getByIdDTO(@PathVariable Integer id) {
        checkYetki(1, 2, 3);
        return service.getByIdDTO(id);
    }

    @PostMapping("/dto")
    public UrunDTO create(@RequestBody UrunDTOCreate dto) {
        checkYetki(1, 2);
        return service.createFromDTO(dto);
    }

    @PutMapping("/dto")
    public UrunDTO update(@RequestBody UrunDTOUpdate dto) {
        checkYetki(1, 2);
        return service.update(dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        checkYetki(1, 2);
        service.deleteById(id);
    }

    @GetMapping("/search/category/{altkId}")
    public List<UrunDTO> findByAltkId(@PathVariable Integer altkId) {
        checkYetki(1, 2);
        return service.findByAltkId(altkId);
    }

}
