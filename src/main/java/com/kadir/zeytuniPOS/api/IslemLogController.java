package com.kadir.zeytuniPOS.api;

import com.kadir.zeytuniPOS.core.IslemLogService;
import com.kadir.zeytuniPOS.data.IslemLog;
import com.kadir.zeytuniPOS.dto.IslemLogCreateDTO;
import com.kadir.zeytuniPOS.dto.IslemLogDTO;
import com.kadir.zeytuniPOS.dto.IslemLogUpdateDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/islemlog")
public class IslemLogController extends BaseController<IslemLog, Integer> {

    private final IslemLogService islemLogService;

    @Autowired
    public IslemLogController(IslemLogService islemLogService) {
        super(islemLogService);
        this.islemLogService = islemLogService;
    }

    @GetMapping("/dto")
    public List<IslemLogDTO> getAllIslemLogs() {
        return islemLogService.getAllIslemLogs();
    }

    @GetMapping("/dto/{id}")
    public IslemLogDTO getIslemLogById(@PathVariable Integer id) {
        return islemLogService.getIslemLogById(id);
    }

    @PostMapping("/dto")
    public IslemLogDTO create(@RequestBody IslemLogCreateDTO createDTO) {
        return islemLogService.createIslemLog(createDTO);
    }

    @PutMapping("/dto")
    public IslemLogDTO update(@RequestBody IslemLogUpdateDTO updateDTO) {
        return islemLogService.updateIslemLog(updateDTO.getLogId(), updateDTO);
    }

    @DeleteMapping("/dto/{id}")
    public void delete(@PathVariable Integer id) {
        islemLogService.deleteIslemLog(id);
    }
}
