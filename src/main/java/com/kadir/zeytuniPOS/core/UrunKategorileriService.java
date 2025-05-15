package com.kadir.zeytuniPOS.core;

import com.kadir.zeytuniPOS.data.UrunKategorileriRepository;
import com.kadir.zeytuniPOS.data.UrunKategorileri;

import org.springframework.stereotype.Service;

@Service
public class UrunKategorileriService extends AbstractService<UrunKategorileri, Integer> {

    public UrunKategorileriService(UrunKategorileriRepository repository) {
        super(repository);
    }

}
