package com.kadir.zeytuniPOS.api;

import com.kadir.zeytuniPOS.core.SecurityUtil;
import com.kadir.zeytuniPOS.core.TedarikciAltKategoriService;
import com.kadir.zeytuniPOS.data.TedarikciAltKategori;
import com.kadir.zeytuniPOS.dto.TedarikciAltKategoriCreateDTO;
import com.kadir.zeytuniPOS.dto.TedarikciAltKategoriDTO;
import com.kadir.zeytuniPOS.dto.TedarikciAltKategoriUpdateDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/dto")
    public List<TedarikciAltKategoriDTO> getAllTedarikciAltKategoriler() {
        return service.getAllTedarikciAltKategoriler();
    }

    @GetMapping("/dto/{id}")
    public TedarikciAltKategoriDTO getTedarikciAltKategoriById(@PathVariable Integer id) {
        return service.getTedarikciAltKategoriById(id);
    }

    @PostMapping("/dto")
    public TedarikciAltKategoriDTO create(@RequestBody TedarikciAltKategoriCreateDTO createDTO) {
        return service.createTedarikciAltKategori(createDTO);
    }

    @PutMapping("/dto/{id}")
    public TedarikciAltKategoriDTO update(@PathVariable Integer id,
            @RequestBody TedarikciAltKategoriUpdateDTO updateDTO) {
        return service.updateTedarikciAltKategori(id, updateDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        SecurityUtil.setCurrentUserId(2); // Örnek kullanıcı ID(ileride authentication ile otomatik olacak)
        try {
            service.deleteTedarikciAltKategori(id);
        } finally {
            SecurityUtil.clear(); // ThreadLocal'ı temizle
        }
    }

}
