package com.kadir.zeytuniPOS.api;

import com.kadir.zeytuniPOS.core.GecmisFiyatService;
import com.kadir.zeytuniPOS.core.security.SecurityUtil;
import com.kadir.zeytuniPOS.data.GecmisFiyat;
import com.kadir.zeytuniPOS.dto.GecmisFiyatCreateDTO;
import com.kadir.zeytuniPOS.dto.GecmisFiyatDTO;
import com.kadir.zeytuniPOS.dto.GecmisFiyatUpdateDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/gecmisfiyat")
public class GecmisFiyatController extends BaseController<GecmisFiyat, Integer> {

    private final GecmisFiyatService gecmisFiyatService;

    private void checkYetki(int... izinliRoller) {
        Integer rolId = SecurityUtil.getCurrentUserRolId();
        if (rolId == null || Arrays.stream(izinliRoller).noneMatch(id -> id == rolId)) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Bu işlem için yetkiniz yok.");
        }
    }

    @Autowired
    public GecmisFiyatController(GecmisFiyatService gecmisFiyatService) {
        super(gecmisFiyatService);
        this.gecmisFiyatService = gecmisFiyatService;
    }

    @GetMapping("/dto")
    public List<GecmisFiyatDTO> getAllGecmisFiyatlar() {
        checkYetki(1, 2, 3);
        return gecmisFiyatService.getAllGecmisFiyatlar();
    }

    @GetMapping("/dto/{id}")
    public GecmisFiyatDTO getGecmisFiyatById(@PathVariable Integer id) {
        checkYetki(1, 2, 3);
        return gecmisFiyatService.getGecmisFiyatById(id);
    }

    @GetMapping("/dto/urun/{urunId}")
    public List<GecmisFiyatDTO> getUrunDetayi(@PathVariable("urunId") Integer urunId) {
        checkYetki(1, 2, 3);
        return gecmisFiyatService.getUrunDetayi(urunId);
    }

    @PostMapping("/dto")
    public GecmisFiyatDTO create(@RequestBody GecmisFiyatCreateDTO createDTO) {
        checkYetki(1, 2, 3);
        return gecmisFiyatService.createGecmisFiyat(createDTO);
    }

    @PutMapping("/dto")
    public GecmisFiyatDTO update(@RequestBody GecmisFiyatUpdateDTO updateDTO) {
        checkYetki(1, 2, 3);
        return gecmisFiyatService.updateGecmisFiyat(updateDTO.getGecmisFiyatId(), updateDTO);
    }

}
