package com.kadir.zeytuniPOS.core;

import com.kadir.zeytuniPOS.data.IslemLogRepository;
import com.kadir.zeytuniPOS.data.IslemLog;

import org.springframework.stereotype.Service;

@Service
public class IslemLogService extends AbstractService<IslemLog, Integer> {

    public IslemLogService(IslemLogRepository repository) {
        super(repository);
    }

}
