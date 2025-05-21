package com.kadir.zeytuniPOS.api;

import com.kadir.zeytuniPOS.core.GecmisFiyatService;
import com.kadir.zeytuniPOS.data.GecmisFiyat;
import com.kadir.zeytuniPOS.dto.GecmisFiyatCreateDTO;
import com.kadir.zeytuniPOS.dto.GecmisFiyatDTO;
import com.kadir.zeytuniPOS.dto.GecmisFiyatUpdateDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/gecmisfiyat")
public class GecmisFiyatController extends BaseController<GecmisFiyat, Integer> {

    private final GecmisFiyatService gecmisFiyatService;

    @Autowired
    public GecmisFiyatController(GecmisFiyatService gecmisFiyatService) {
        super(gecmisFiyatService);
        this.gecmisFiyatService = gecmisFiyatService;
    }

    @GetMapping("/dto")
    public List<GecmisFiyatDTO> getAllGecmisFiyatlar() {
        return gecmisFiyatService.getAllGecmisFiyatlar();
    }

    @GetMapping("/dto/{id}")
    public GecmisFiyatDTO getGecmisFiyatById(@PathVariable Integer id) {
        return gecmisFiyatService.getGecmisFiyatById(id);
    }

    @PostMapping("/dto")
    public GecmisFiyatDTO create(@RequestBody GecmisFiyatCreateDTO createDTO) {
        return gecmisFiyatService.createGecmisFiyat(createDTO);
    }

    @PutMapping("/dto")
    public GecmisFiyatDTO update(@RequestBody GecmisFiyatUpdateDTO updateDTO) {
        return gecmisFiyatService.updateGecmisFiyat(updateDTO.getGecmisFiyatId(), updateDTO);
    }

    @DeleteMapping("/dto/{id}")
    public void delete(@PathVariable Integer id) {
        gecmisFiyatService.deleteGecmisFiyat(id);
    }
}
