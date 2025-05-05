package com.kadir.zeytuniPOS.core;

import com.kadir.zeytuniPOS.data.Birim;
import com.kadir.zeytuniPOS.data.BirimRepository;
import org.springframework.stereotype.Service;

@Service
public class BirimService extends AbstractService<Birim, Integer> {

    public BirimService(BirimRepository repository) {
        super(repository);
    }
}
