package com.kadir.zeytuniPOS.api;

import com.kadir.zeytuniPOS.core.UrunKategorileriService;
import com.kadir.zeytuniPOS.core.security.SecurityUtil;
import com.kadir.zeytuniPOS.data.UrunKategorileri;
import com.kadir.zeytuniPOS.dto.*;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/urunkategorileri")
public class UrunKategorileriController extends BaseController<UrunKategorileri, Integer> {

    private final UrunKategorileriService service;

    public UrunKategorileriController(UrunKategorileriService service) {
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
    public List<UrunKategorileriDTO> getAllDTO() {
        checkYetki(1, 2, 3);
        return service.getAllDTO();
    }

    @PostMapping("/dto")
    public UrunKategorileriDTO create(@RequestBody UrunKategorileriCreateDTO dto) {
        checkYetki(1);
        return service.createFromDTO(dto);
    }

    @PutMapping("/dto")
    public UrunKategorileriDTO update(@RequestBody UrunKategorileriUpdateDTO dto) {
        checkYetki(1);
        return service.update(dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        checkYetki(1);
        service.deleteById(id);
    }
}
