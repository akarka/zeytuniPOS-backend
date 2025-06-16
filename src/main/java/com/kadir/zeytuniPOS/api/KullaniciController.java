package com.kadir.zeytuniPOS.api;

import com.kadir.zeytuniPOS.core.KullaniciService;
import com.kadir.zeytuniPOS.core.security.CustomUserDetails;
import com.kadir.zeytuniPOS.core.security.SecurityUtil;
import com.kadir.zeytuniPOS.data.Kullanici;
import com.kadir.zeytuniPOS.dto.KullaniciCreateDTO;
import com.kadir.zeytuniPOS.dto.KullaniciDTO;
import com.kadir.zeytuniPOS.dto.KullaniciUpdateDTO;
import com.kadir.zeytuniPOS.dto.SifreGuncelleDTO;
import com.kadir.zeytuniPOS.mapper.KullaniciMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/kullanicilar")
public class KullaniciController extends BaseController<Kullanici, Integer> {

    private final KullaniciService kullaniciService;
    private final KullaniciMapper mapper;

    @Autowired
    public KullaniciController(KullaniciService kullaniciService, KullaniciMapper mapper) {
        super(kullaniciService);
        this.kullaniciService = kullaniciService;
        this.mapper = mapper;
    }

    private void checkYetki(int... izinliRoller) {
        Integer rolId = SecurityUtil.getCurrentUserRolId();
        if (rolId == null || Arrays.stream(izinliRoller).noneMatch(id -> id == rolId)) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Bu işlem için yetkiniz yok.");
        }
    }

    @GetMapping("/dto")
    public List<KullaniciDTO> getAllKullanicilar() {
        checkYetki(1, 2, 3);
        return kullaniciService.getAllKullanicilar();
    }

    @GetMapping("/dto/{id}")
    public KullaniciDTO getKullaniciById(@PathVariable Integer id) {
        checkYetki(1, 2, 3);
        return kullaniciService.getKullaniciById(id);
    }

    @PostMapping("/dto")
    public KullaniciDTO create(@RequestBody KullaniciCreateDTO dto) {
        checkYetki(1, 2, 3);
        return kullaniciService.createFromDTO(dto);
    }

    @PutMapping("/dto")
    public KullaniciDTO update(@RequestBody KullaniciUpdateDTO dto) {
        checkYetki(1);
        return kullaniciService.update(dto);
    }

    @DeleteMapping("/dto/{id}")
    public void delete(@PathVariable Integer id) {
        checkYetki(1);
        kullaniciService.delete(id);
    }

    @PostMapping("/sifre-guncelle")
    public void guncelleSifre(@RequestBody SifreGuncelleDTO dto) {
        checkYetki(1);
        kullaniciService.guncelleSifre(dto);
    }

    @GetMapping("/me")
    public KullaniciDTO getAktifKullanici(Authentication auth) {
        checkYetki(1, 2, 3);
        CustomUserDetails user = (CustomUserDetails) auth.getPrincipal();
        return mapper.toDTO(user.getKullanici());
    }
}
