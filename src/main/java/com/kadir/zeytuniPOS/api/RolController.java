package com.kadir.zeytuniPOS.api;

import com.kadir.zeytuniPOS.core.RolService;
import com.kadir.zeytuniPOS.core.security.SecurityUtil;
import com.kadir.zeytuniPOS.data.Rol;
import com.kadir.zeytuniPOS.dto.RolCreateDTO;
import com.kadir.zeytuniPOS.dto.RolDTO;
import com.kadir.zeytuniPOS.dto.RolUpdateDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;
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

    private void checkYetki(int... izinliRoller) {
        Integer rolId = SecurityUtil.getCurrentUserRolId();
        if (rolId == null || Arrays.stream(izinliRoller).noneMatch(id -> id == rolId)) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Bu işlem için yetkiniz yok.");
        }
    }

    @GetMapping("/dto")
    public List<RolDTO> getAllRoller() {
        checkYetki(1, 2, 3);
        return rolService.getAllRoller();
    }

    @GetMapping("/dto/{id}")
    public RolDTO getRolById(@PathVariable Integer id) {
        checkYetki(1, 2, 3);
        return rolService.getRolById(id);
    }

    @PostMapping("/dto")
    public RolDTO create(@RequestBody RolCreateDTO dto) {
        checkYetki(1);
        return rolService.create(dto);
    }

    @PutMapping("/dto")
    public RolDTO update(@RequestBody RolUpdateDTO dto) {
        checkYetki(1);
        return rolService.update(dto);
    }

    @DeleteMapping("/dto/{id}")
    public void delete(@PathVariable Integer id) {
        checkYetki(1);
        service.delete(id);
    }
}
