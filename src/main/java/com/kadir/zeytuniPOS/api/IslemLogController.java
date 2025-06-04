package com.kadir.zeytuniPOS.api;

import com.kadir.zeytuniPOS.core.IslemLogService;
import com.kadir.zeytuniPOS.core.security.SecurityUtil;
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
        SecurityUtil.setCurrentUserId(2); // İleride oturumdan alınacak
        try {
            return islemLogService.getAllIslemLogs();
        } finally {
            SecurityUtil.clear();
        }
    }

    @GetMapping("/dto/{id}")
    public IslemLogDTO getIslemLogById(@PathVariable Integer id) {
        SecurityUtil.setCurrentUserId(2); // İleride oturumdan alınacak
        try {
            return islemLogService.getIslemLogById(id);
        } finally {
            SecurityUtil.clear();
        }
    }

    @PostMapping("/dto")
    public IslemLogDTO create(@RequestBody IslemLogCreateDTO createDTO) {
        SecurityUtil.setCurrentUserId(2); // İleride oturumdan alınacak
        try {
            return islemLogService.createIslemLog(createDTO);
        } finally {
            SecurityUtil.clear();
        }
    }

    @PutMapping("/dto")
    public IslemLogDTO update(@RequestBody IslemLogUpdateDTO updateDTO) {
        SecurityUtil.setCurrentUserId(2); // İleride oturumdan alınacak
        try {
            return islemLogService.updateIslemLog(updateDTO.getLogId(), updateDTO);
        } finally {
            SecurityUtil.clear();
        }
    }

}
