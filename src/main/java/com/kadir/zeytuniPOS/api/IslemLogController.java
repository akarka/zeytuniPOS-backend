package com.kadir.zeytuniPOS.api;

import com.kadir.zeytuniPOS.core.IslemLogService;
import com.kadir.zeytuniPOS.core.security.SecurityUtil;
import com.kadir.zeytuniPOS.data.IslemLog;
import com.kadir.zeytuniPOS.dto.IslemLogCreateDTO;
import com.kadir.zeytuniPOS.dto.IslemLogDTO;
import com.kadir.zeytuniPOS.dto.IslemLogUpdateDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;
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

    private void checkYetki(int... izinliRoller) {
        Integer rolId = SecurityUtil.getCurrentUserRolId();
        if (rolId == null || Arrays.stream(izinliRoller).noneMatch(id -> id == rolId)) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Bu işlem için yetkiniz yok.");
        }
    }

    @GetMapping("/dto")
    public List<IslemLogDTO> getAllIslemLogs() {
        checkYetki(1, 2, 3);
        return islemLogService.getAllIslemLogs();
    }

    @GetMapping("/dto/{id}")
    public IslemLogDTO getIslemLogById(@PathVariable Integer id) {
        checkYetki(1, 2, 3);
        return islemLogService.getIslemLogById(id);
    }

    @PostMapping("/dto")
    public IslemLogDTO create(@RequestBody IslemLogCreateDTO createDTO) {
        checkYetki(1, 2, 3);
        return islemLogService.createIslemLog(createDTO);
    }

    @PutMapping("/dto")
    public IslemLogDTO update(@RequestBody IslemLogUpdateDTO updateDTO) {
        checkYetki(1, 2, 3);
        return islemLogService.updateIslemLog(updateDTO.getLogId(), updateDTO);
    }

}
