package com.kadir.zeytuniPOS.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kadir.zeytuniPOS.core.IslemLogService;
import com.kadir.zeytuniPOS.data.IslemLog;

@RestController
@RequestMapping("/api/islemlog")
public class IslemLogController extends BaseController<IslemLog,Integer>{

    public IslemLogController(IslemLogService service){
        super(service);
    }
    
}
