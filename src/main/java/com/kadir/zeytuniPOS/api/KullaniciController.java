package com.kadir.zeytuniPOS.api;

import com.kadir.zeytuniPOS.core.KullaniciService;
import com.kadir.zeytuniPOS.data.Kullanici;
import com.kadir.zeytuniPOS.dto.KullaniciCreateDTO;
import com.kadir.zeytuniPOS.dto.KullaniciDTO;
import com.kadir.zeytuniPOS.dto.KullaniciUpdateDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/kullanicilar")
public class KullaniciController extends BaseController<Kullanici, Integer> {

    private final KullaniciService kullaniciService;

    @Autowired
    public KullaniciController(KullaniciService kullaniciService) {
        super(kullaniciService);
        this.kullaniciService = kullaniciService;
    }

    @GetMapping("/dto")
    public List<KullaniciDTO> getAllKullanicilar() {
        return kullaniciService.getAllKullanicilar();
    }

    @GetMapping("/dto/{id}")
    public KullaniciDTO getKullaniciById(@PathVariable Integer id) {
        return kullaniciService.getKullaniciById(id);
    }

    @PostMapping("/dto")
    public KullaniciDTO create(@RequestBody KullaniciCreateDTO createDTO) {
        return kullaniciService.createKullanici(createDTO);
    }

    @PutMapping("/dto")
    public KullaniciDTO update(@RequestBody KullaniciUpdateDTO updateDTO) {
        return kullaniciService.updateKullanici(updateDTO.getKullaniciId(), updateDTO);
    }

    @DeleteMapping("/dto/{id}")
    public void delete(@PathVariable Integer id) {
        kullaniciService.deleteKullanici(id);
    }
}
