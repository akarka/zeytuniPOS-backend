package com.kadir.zeytuniPOS.api;

import com.kadir.zeytuniPOS.core.TedarikciService;
import com.kadir.zeytuniPOS.core.security.SecurityUtil;
import com.kadir.zeytuniPOS.data.Tedarikci;
import com.kadir.zeytuniPOS.dto.*;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/tedarikciler")
public class TedarikciController extends BaseController<Tedarikci, Integer> {

    private final TedarikciService service;

    public TedarikciController(TedarikciService service) {
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
    public List<TedarikciDTO> getAllDTO() {
        checkYetki(1, 2, 3);
        return service.getAllDTO();
    }

    @PostMapping("/dto")
    public TedarikciDTO create(@RequestBody TedarikciCreateDTO dto) {
        checkYetki(1, 2);
        return service.createFromDTO(dto);
    }

    @PutMapping("/dto")
    public TedarikciDTO update(@RequestBody TedarikciUpdateDTO dto) {
        checkYetki(1, 2);
        return service.update(dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        checkYetki(1, 2);
        service.deleteById(id);
    }
}
