package com.kadir.zeytuniPOS.core;

import com.kadir.zeytuniPOS.data.UrunKategorileriRepository;
import com.kadir.zeytuniPOS.dto.UrunKategoriDTO;
import com.kadir.zeytuniPOS.mapper.UrunKategoriMapper;
import com.kadir.zeytuniPOS.data.UrunKategorileri;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UrunKategorileriService extends AbstractService<UrunKategorileri, Integer> {

    private final UrunKategoriMapper mapper;

    public UrunKategorileriService(UrunKategorileriRepository repository, UrunKategoriMapper mapper) {
        super(repository);
        this.mapper = mapper;
    }

    public List<UrunKategoriDTO> getAllDTO() {
        return mapper.toDTOList(repository.findAll());
    }

}
