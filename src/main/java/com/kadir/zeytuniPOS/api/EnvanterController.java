package com.kadir.zeytuniPOS.api;

import com.kadir.zeytuniPOS.core.EnvanterService;
import com.kadir.zeytuniPOS.data.Envanter;
import com.kadir.zeytuniPOS.dto.EnvanterCreateDTO;
import com.kadir.zeytuniPOS.dto.EnvanterDTO;
import com.kadir.zeytuniPOS.dto.EnvanterUpdateDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/envanter")
public class EnvanterController extends BaseController<Envanter, Integer> {

    private final EnvanterService envanterService;

    @Autowired
    public EnvanterController(EnvanterService envanterService) {
        super(envanterService);
        this.envanterService = envanterService;
    }

    @GetMapping("/dto")
    public List<EnvanterDTO> getAllEnvanterler() {
        return envanterService.getAllEnvanterler();
    }

    @GetMapping("/dto/{id}")
    public EnvanterDTO getEnvanterById(@PathVariable Integer id) {
        return envanterService.getEnvanterById(id);
    }

    @PostMapping("/dto")
    public EnvanterDTO create(@RequestBody EnvanterCreateDTO createDTO) {
        return envanterService.createEnvanter(createDTO);
    }

    @PutMapping("/dto")
    public EnvanterDTO update(@RequestBody EnvanterUpdateDTO updateDTO) {
        return envanterService.updateEnvanter(updateDTO.getEnvanterId(), updateDTO);
    }

    @DeleteMapping("/dto/{id}")
    public void delete(@PathVariable Integer id) {
        envanterService.deleteEnvanter(id);
    }
}
