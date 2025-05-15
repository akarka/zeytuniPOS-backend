package com.kadir.zeytuniPOS.core;

import com.kadir.zeytuniPOS.data.UrunTedarikciRepository;
import com.kadir.zeytuniPOS.data.UrunTedarikci;

import org.springframework.stereotype.Service;

@Service
public class UrunTedarikciService extends AbstractService<UrunTedarikci, Integer> {

    public UrunTedarikciService(UrunTedarikciRepository repository) {
        super(repository);
    }

}
