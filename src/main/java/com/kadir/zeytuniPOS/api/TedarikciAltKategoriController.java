package com.kadir.zeytuniPOS.api;

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

    private final TedarikciAltKategoriService tedarikciAltKategoriService;

    @Autowired
    public TedarikciAltKategoriController(TedarikciAltKategoriService tedarikciAltKategoriService) {
        super(tedarikciAltKategoriService);
        this.tedarikciAltKategoriService = tedarikciAltKategoriService;
    }

    @GetMapping("/dto")
    public List<TedarikciAltKategoriDTO> getAllTedarikciAltKategoriler() {
        return tedarikciAltKategoriService.getAllTedarikciAltKategoriler();
    }

    @GetMapping("/dto/{id}")
    public TedarikciAltKategoriDTO getTedarikciAltKategoriById(@PathVariable Integer id) {
        return tedarikciAltKategoriService.getTedarikciAltKategoriById(id);
    }

    @PostMapping("/dto")
    public TedarikciAltKategoriDTO create(@RequestBody TedarikciAltKategoriCreateDTO createDTO) {
        return tedarikciAltKategoriService.createTedarikciAltKategori(createDTO);
    }

    @PutMapping("/dto/{id}")
    public TedarikciAltKategoriDTO update(@PathVariable Integer id,
            @RequestBody TedarikciAltKategoriUpdateDTO updateDTO) {
        return tedarikciAltKategoriService.updateTedarikciAltKategori(id, updateDTO);
    }

}
