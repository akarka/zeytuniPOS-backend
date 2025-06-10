package com.kadir.zeytuniPOS.api;

import com.kadir.zeytuniPOS.core.TedarikciAltKategoriService;
import com.kadir.zeytuniPOS.core.security.SecurityUtil;
import com.kadir.zeytuniPOS.data.TedarikciAltKategori;
import com.kadir.zeytuniPOS.dto.TedarikciAltKategoriCreateDTO;
import com.kadir.zeytuniPOS.dto.TedarikciAltKategoriDTO;
import com.kadir.zeytuniPOS.dto.TedarikciAltKategoriUpdateDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/tedarikcialtkategori")
public class TedarikciAltKategoriController extends BaseController<TedarikciAltKategori, Integer> {

    private final TedarikciAltKategoriService service;

    @Autowired
    public TedarikciAltKategoriController(TedarikciAltKategoriService saervice) {
        super(saervice);
        this.service = saervice;
    }

    private void checkYetki(int... izinliRoller) {
        Integer rolId = SecurityUtil.getCurrentUserRolId();
        if (rolId == null || Arrays.stream(izinliRoller).noneMatch(id -> id == rolId)) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Bu işlem için yetkiniz yok.");
        }
    }

    @GetMapping("/dto")
    public List<TedarikciAltKategoriDTO> getAllTedarikciAltKategoriler() {
        checkYetki(1, 2, 3);
        return service.getAllTedarikciAltKategoriler();
    }

    @GetMapping("/dto/{id}")
    public TedarikciAltKategoriDTO getTedarikciAltKategoriById(@PathVariable Integer id) {
        checkYetki(1, 2, 3);
        return service.getTedarikciAltKategoriById(id);
    }

    @PostMapping("/dto")
    public TedarikciAltKategoriDTO create(@RequestBody TedarikciAltKategoriCreateDTO createDTO) {
        checkYetki(1);
        return service.createTedarikciAltKategori(createDTO);
    }

    @PutMapping("/dto/{id}")
    public TedarikciAltKategoriDTO update(@PathVariable Integer id,
            @RequestBody TedarikciAltKategoriUpdateDTO updateDTO) {
        checkYetki(1);
        return service.updateTedarikciAltKategori(id, updateDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        checkYetki(1);
        service.deleteTedarikciAltKategori(id);
    }

}
