package com.kadir.zeytuniPOS.api;

import com.kadir.zeytuniPOS.core.UrunTedarikciService;
import com.kadir.zeytuniPOS.data.UrunTedarikci;
import com.kadir.zeytuniPOS.dto.UrunTedarikciCreateDTO;
import com.kadir.zeytuniPOS.dto.UrunTedarikciDTO;
import com.kadir.zeytuniPOS.dto.UrunTedarikciUpdateDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/uruntedarikci")
public class UrunTedarikciController extends BaseController<UrunTedarikci, Integer> {

    private final UrunTedarikciService urunTedarikciService;

    @Autowired
    public UrunTedarikciController(UrunTedarikciService urunTedarikciService) {
        super(urunTedarikciService);
        this.urunTedarikciService = urunTedarikciService;
    }

    @GetMapping("/dto")
    public List<UrunTedarikciDTO> getAllUrunTedarikciler() {
        return urunTedarikciService.getAllUrunTedarikciler();
    }

    @GetMapping("/dto/{id}")
    public UrunTedarikciDTO getUrunTedarikciById(@PathVariable Integer id) {
        return urunTedarikciService.getUrunTedarikciById(id);
    }

    @PostMapping("/dto")
    public UrunTedarikciDTO create(@RequestBody UrunTedarikciCreateDTO createDTO) {
        return urunTedarikciService.createUrunTedarikci(createDTO);
    }

    @PutMapping("/dto/{id}")
    public UrunTedarikciDTO update(@PathVariable Integer id, @RequestBody UrunTedarikciUpdateDTO updateDTO) {
        return urunTedarikciService.updateUrunTedarikci(id, updateDTO);
    }

}
