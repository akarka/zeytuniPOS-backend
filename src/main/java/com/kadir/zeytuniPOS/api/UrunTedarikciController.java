package com.kadir.zeytuniPOS.api;

import com.kadir.zeytuniPOS.core.UrunTedarikciService;
import com.kadir.zeytuniPOS.core.security.SecurityUtil;
import com.kadir.zeytuniPOS.data.UrunTedarikci;
import com.kadir.zeytuniPOS.dto.UrunTedarikciCreateDTO;
import com.kadir.zeytuniPOS.dto.UrunTedarikciDTO;
import com.kadir.zeytuniPOS.dto.UrunTedarikciUpdateDTO;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/uruntedarikci")
public class UrunTedarikciController extends BaseController<UrunTedarikci, Integer> {

    private final UrunTedarikciService service;

    public UrunTedarikciController(UrunTedarikciService service) {
        super(service);
        this.service = service;
    }

    private void checkYetki(int... izinliRoller) {
        Integer rolId = SecurityUtil.getCurrentUserRolId();
        if (rolId == null || Arrays.stream(izinliRoller).noneMatch(id -> id == rolId)) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Bu işlem için yetkiniz yok.");
        }
    }

    @GetMapping("/dto")
    public List<UrunTedarikciDTO> getAllUrunTedarikciler() {
        checkYetki(1, 2, 3);
        return service.getAllUrunTedarikciler();
    }

    @GetMapping("/dto/{id}")
    public UrunTedarikciDTO getUrunTedarikciById(@PathVariable Integer id) {
        checkYetki(1, 2, 3);
        return service.getUrunTedarikciById(id);
    }

    @PostMapping("/dto")
    public UrunTedarikciDTO create(@RequestBody UrunTedarikciCreateDTO dto) {
        checkYetki(1, 2);
        return service.createUrunTedarikci(dto);
    }

    @PutMapping("/dto/{id}")
    public UrunTedarikciDTO update(@PathVariable Integer id, @RequestBody UrunTedarikciUpdateDTO updateDTO) {
        checkYetki(1, 2);
        return service.updateUrunTedarikci(id, updateDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        checkYetki(1, 2);
        service.deleteUrunTedarikci(id);
    }

}
