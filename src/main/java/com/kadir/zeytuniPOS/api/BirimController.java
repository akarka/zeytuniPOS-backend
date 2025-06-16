package com.kadir.zeytuniPOS.api;

import com.kadir.zeytuniPOS.core.BirimService;
import com.kadir.zeytuniPOS.core.security.SecurityUtil;
import com.kadir.zeytuniPOS.data.Birim;
import com.kadir.zeytuniPOS.dto.BirimDTOCreate;
import com.kadir.zeytuniPOS.dto.BirimDTO;
import com.kadir.zeytuniPOS.dto.BirimDTOUpdate;

import java.util.*;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/birimler")
public class BirimController extends BaseController<Birim, Integer> {

    private final BirimService service;

    public BirimController(BirimService service) {
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
    public List<BirimDTO> getAllDTO() {
        checkYetki(1, 2, 3);
        return service.getAllDTO();
    }

    @PostMapping("/dto")
    public BirimDTO create(@RequestBody BirimDTOCreate dto) {
        boolean zatenVar = service.getAllDTO().stream()
                .anyMatch(b -> b.getBirimAdi().equalsIgnoreCase(dto.getBirimAdi()));

        if (zatenVar) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bu ad ile zaten bir birim var.");
        }
        checkYetki(1, 2);
        return service.createFromDTO(dto);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(Integer id) {
        checkYetki(1, 2);
        service.deleteById(id);
    }

    @PutMapping("/dto")
    public BirimDTO update(@RequestBody BirimDTOUpdate dto) {
        checkYetki(1, 2);
        return service.update(dto);
    }
}
