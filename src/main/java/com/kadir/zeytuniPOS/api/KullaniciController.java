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
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/dto")
    public List<KullaniciDTO> getAllKullanicilar() {
        return kullaniciService.getAllKullanicilar();
    }

    @GetMapping("/dto/{id}")
    public KullaniciDTO getKullaniciById(@PathVariable Integer id) {
        return kullaniciService.getKullaniciById(id);
    }

    @PostMapping("/dto")
    public KullaniciDTO create(@RequestBody KullaniciCreateDTO dto) {
        SecurityUtil.setCurrentUserId(2); // İleride oturumdan alınacak
        try {
            return kullaniciService.createFromDTO(dto);
        } finally {
            SecurityUtil.clear();
        }
    }

    @PutMapping("/dto")
    public KullaniciDTO update(@RequestBody KullaniciUpdateDTO dto) {
        System.out.println("Geldi");
        SecurityUtil.setCurrentUserId(2);
        try {
            return kullaniciService.update(dto);
        } finally {
            SecurityUtil.clear();
        }
    }

    @DeleteMapping("/dto/{id}")
    public void delete(@PathVariable Integer id) {
        System.out.println("Geldi");
        SecurityUtil.setCurrentUserId(2);
        try {
            kullaniciService.delete(id);
        } finally {
            SecurityUtil.clear();
        }
    }

    @PostMapping("/sifre-guncelle")
    public void guncelleSifre(@RequestBody SifreGuncelleDTO dto) {
        SecurityUtil.setCurrentUserId(2);
        try {
            kullaniciService.guncelleSifre(dto);
        } finally {
            SecurityUtil.clear();
        }
    }

    @GetMapping("/me")
    public KullaniciDTO getAktifKullanici(Authentication auth) {
        CustomUserDetails user = (CustomUserDetails) auth.getPrincipal();
        return mapper.toDTO(user.getKullanici());
    }
}
