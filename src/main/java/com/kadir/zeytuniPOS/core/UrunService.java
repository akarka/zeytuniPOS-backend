package com.kadir.zeytuniPOS.core;

import com.kadir.zeytuniPOS.data.Urun;
import com.kadir.zeytuniPOS.data.UrunRepository;
import com.kadir.zeytuniPOS.dto.*;
import com.kadir.zeytuniPOS.mapper.UrunMapper;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UrunService extends AbstractService<Urun, Integer> {

    private final UrunRepository repository;
    private final UrunMapper mapper;

    public UrunService(UrunRepository repository, UrunMapper mapper) {
        super(repository);
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<UrunDTO> getAllDTO() {
        return mapper.toDTOList(repository.findAll());
    }

    public UrunDTO createFromDTO(UrunCreateDTO dto) {
        return mapper.toDTO(repository.save(mapper.toEntity(dto)));
    }

    public UrunDTO update(UrunUpdateDTO dto) {
        return mapper.toDTO(repository.save(mapper.toEntity(dto)));
    }
}
