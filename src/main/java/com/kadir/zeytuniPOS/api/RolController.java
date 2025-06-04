package com.kadir.zeytuniPOS.api;

import com.kadir.zeytuniPOS.core.RolService;
import com.kadir.zeytuniPOS.core.security.SecurityUtil;
import com.kadir.zeytuniPOS.data.Rol;
import com.kadir.zeytuniPOS.dto.RolCreateDTO;
import com.kadir.zeytuniPOS.dto.RolDTO;
import com.kadir.zeytuniPOS.dto.RolUpdateDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roller")
public class RolController extends BaseController<Rol, Integer> {

    private final RolService rolService;

    @Autowired
    public RolController(RolService rolService) {
        super(rolService);
        this.rolService = rolService;
    }

    @GetMapping("/dto")
    public List<RolDTO> getAllRoller() {
        return rolService.getAllRoller();
    }

    @GetMapping("/dto/{id}")
    public RolDTO getRolById(@PathVariable Integer id) {
        return rolService.getRolById(id);
    }

    @PostMapping("/dto")
    public RolDTO create(@RequestBody RolCreateDTO dto) {
        SecurityUtil.setCurrentUserId(2); // Örnek kullanıcı ID(ileride authentication ile otomatik olacak)
        try {
            return rolService.create(dto);
        } finally {
            SecurityUtil.clear(); // ThreadLocal'ı temizle
        }
    }

    @PutMapping("/dto")
    public RolDTO update(@RequestBody RolUpdateDTO dto) {
        SecurityUtil.setCurrentUserId(2); // Örnek kullanıcı ID(ileride authentication ile otomatik olacak)
        try {
            return rolService.update(dto);
        } finally {
            SecurityUtil.clear(); // ThreadLocal'ı temizle
        }
    }

    @DeleteMapping("/dto/{id}")
    public void delete(@PathVariable Integer id) {
        SecurityUtil.setCurrentUserId(2); // Örnek kullanıcı ID(ileride authentication ile otomatik olacak)
        try {
            service.delete(id);
        } finally {
            SecurityUtil.clear(); // ThreadLocal'ı temizle
        }
    }
}
