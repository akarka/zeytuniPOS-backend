package com.kadir.zeytuniPOS.api;

import java.util.*;

import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.*;

import com.kadir.zeytuniPOS.core.IslemLogService;
import com.kadir.zeytuniPOS.data.IslemLog;

@RestController
@RequestMapping("/api/islemlog")
public class IslemLogController extends BaseController<IslemLog, Integer> {

    private final IslemLogService service;

    public IslemLogController(IslemLogService service) {
        super(service);
        this.service = service;
    }

    @Override
    @GetMapping
    public List<IslemLog> getAll() {
        Sort sortObj = Sort.by(Sort.Direction.DESC, "tarih");
        return service.getAll(sortObj);
    }

}
