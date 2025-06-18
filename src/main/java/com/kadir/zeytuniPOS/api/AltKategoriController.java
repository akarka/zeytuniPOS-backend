package com.kadir.zeytuniPOS.api;

import com.kadir.zeytuniPOS.data.AltKategori;
import com.kadir.zeytuniPOS.dto.AltKategoriCreateDTO;
import com.kadir.zeytuniPOS.dto.AltKategoriDTO;
import com.kadir.zeytuniPOS.dto.AltKategoriUpdateDTO;
import com.kadir.zeytuniPOS.core.AltKategoriService;
import com.kadir.zeytuniPOS.core.security.SecurityUtil;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/altkategoriler")
public class AltKategoriController extends BaseController<AltKategori, Integer> {

    private final AltKategoriService service;

    public AltKategoriController(AltKategoriService service) {
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
    public List<AltKategoriDTO> getAllAltKategoriler() {
        checkYetki(1, 2, 3);
        return service.getAllDTO();
    }

    @PostMapping("/dto")
    public AltKategoriDTO create(@RequestBody AltKategoriCreateDTO dto) {
        checkYetki(1, 2, 3);
        return service.createFromDTO(dto);
    }

    @PutMapping("/dto")
    public AltKategoriDTO update(@RequestBody AltKategoriUpdateDTO dto) {
        checkYetki(1, 2, 3);
        return service.update(dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        checkYetki(1, 2, 3);
        service.deleteById(id);
    }
}
