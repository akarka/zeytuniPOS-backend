package com.kadir.zeytuniPOS.core;

import com.kadir.zeytuniPOS.data.RolRepository;
import com.kadir.zeytuniPOS.data.Rol;

import org.springframework.stereotype.Service;

@Service
public class RolService extends AbstractService<Rol, Integer> {

    public RolService(RolRepository repository) {
        super(repository);
    }

}
