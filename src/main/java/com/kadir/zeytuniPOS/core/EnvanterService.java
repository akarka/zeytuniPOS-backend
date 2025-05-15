package com.kadir.zeytuniPOS.core;

import org.springframework.stereotype.Service;

import com.kadir.zeytuniPOS.data.Envanter;
import com.kadir.zeytuniPOS.data.EnvanterRepository;

@Service
public class EnvanterService extends AbstractService<Envanter, Integer>{

    public EnvanterService(EnvanterRepository repository){
        super(repository);
    }
    
}
