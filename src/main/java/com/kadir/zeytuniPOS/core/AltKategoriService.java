package com.kadir.zeytuniPOS.core;

import org.springframework.stereotype.Service;

import com.kadir.zeytuniPOS.data.AltKategori;
import com.kadir.zeytuniPOS.data.AltKategoriRepository;

@Service
public class AltKategoriService extends AbstractService<AltKategori, Integer>{

     public AltKategoriService(AltKategoriRepository repository) {
        super(repository);
    }
    
}
