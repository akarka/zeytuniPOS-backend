package com.kadir.zeytuniPOS.api;

import com.kadir.zeytuniPOS.core.KullaniciRolService;
import com.kadir.zeytuniPOS.data.KullaniciRol;
import com.kadir.zeytuniPOS.dto.KullaniciRolCreateDTO;
import com.kadir.zeytuniPOS.dto.KullaniciRolDTO;
import com.kadir.zeytuniPOS.dto.KullaniciRolUpdateDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/kullanicirolleri")
public class KullaniciRolController extends BaseController<KullaniciRol, Integer> {

    private final KullaniciRolService kullaniciRolService;

    @Autowired
    public KullaniciRolController(KullaniciRolService kullaniciRolService) {
        super(kullaniciRolService);
        this.kullaniciRolService = kullaniciRolService;
    }

    @GetMapping("/dto")
    public List<KullaniciRolDTO> getAllKullaniciRoller() {
        return kullaniciRolService.getAllKullaniciRoller();
    }

    @GetMapping("/dto/{id}")
    public KullaniciRolDTO getKullaniciRolById(@PathVariable Integer id) {
        return kullaniciRolService.getKullaniciRolById(id);
    }

    @PostMapping("/dto")
    public KullaniciRolDTO create(@RequestBody KullaniciRolCreateDTO createDTO) {
        return kullaniciRolService.createKullaniciRol(createDTO);
    }

    @PutMapping("/dto")
    public KullaniciRolDTO update(@RequestBody KullaniciRolUpdateDTO updateDTO) {
        return kullaniciRolService.updateKullaniciRol(updateDTO.getKullaniciRolId(), updateDTO);
    }

    @DeleteMapping("/dto/{id}")
    public void delete(@PathVariable Integer id) {
        kullaniciRolService.deleteKullaniciRol(id);
    }
}
