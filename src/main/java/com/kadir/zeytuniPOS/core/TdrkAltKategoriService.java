package com.kadir.zeytuniPOS.core;

import com.kadir.zeytuniPOS.data.TdrkAltKategoriRepository;
import com.kadir.zeytuniPOS.data.TdrkAltKategori;

import org.springframework.stereotype.Service;

@Service
public class TdrkAltKategoriService extends AbstractService<TdrkAltKategori, Integer> {

    public TdrkAltKategoriService(TdrkAltKategoriRepository repository) {
        super(repository);
    }

}
