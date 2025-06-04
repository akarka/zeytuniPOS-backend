package com.kadir.zeytuniPOS.api;

import com.kadir.zeytuniPOS.core.BirimService;
import com.kadir.zeytuniPOS.core.security.SecurityUtil;
import com.kadir.zeytuniPOS.data.Birim;
import com.kadir.zeytuniPOS.dto.BirimDTOCreate;
import com.kadir.zeytuniPOS.dto.BirimDTO;
import com.kadir.zeytuniPOS.dto.BirimDTOUpdate;

import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/birimler")
public class BirimController extends BaseController<Birim, Integer> {

    private final BirimService service;

    public BirimController(BirimService service) {
        super(service);
        this.service = service;
    }

    @GetMapping("/dto")
    public List<BirimDTO> getAllDTO() {
        SecurityUtil.setCurrentUserId(2); // İleride oturumdan alınacak
        try {
            return service.getAllDTO();
        } finally {
            SecurityUtil.clear();
        }
    }

    @PostMapping("/dto")
    public BirimDTO create(@RequestBody BirimDTOCreate dto) {
        SecurityUtil.setCurrentUserId(2); // İleride oturumdan alınacak
        try {
            return service.createFromDTO(dto);
        } finally {
            SecurityUtil.clear();
        }
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(Integer id) {
        SecurityUtil.setCurrentUserId(2); // İleride oturumdan alınacak
        try {
            service.deleteById(id);
        } finally {
            SecurityUtil.clear();
        }
    }

    @PutMapping("/dto")
    public BirimDTO update(@RequestBody BirimDTOUpdate dto) {
        SecurityUtil.setCurrentUserId(2); // İleride oturumdan alınacak
        try {
            return service.update(dto);
        } finally {
            SecurityUtil.clear();
        }
    }
}
