package com.kadir.zeytuniPOS.core;

import com.kadir.zeytuniPOS.data.Tedarikci;
import com.kadir.zeytuniPOS.data.TedarikciRepository;
import com.kadir.zeytuniPOS.dto.*;
import com.kadir.zeytuniPOS.mapper.TedarikciMapper;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TedarikciService extends AbstractService<Tedarikci, Integer> {

    private final TedarikciRepository repository;
    private final TedarikciMapper mapper;

    public TedarikciService(TedarikciRepository repository, TedarikciMapper mapper) {
        super(repository);
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<TedarikciDTO> getAllDTO() {
        return mapper.toDTOList(repository.findAll());
    }

    public TedarikciDTO createFromDTO(TedarikciCreateDTO dto) {
        return mapper.toDTO(repository.save(mapper.toEntity(dto)));
    }

    public TedarikciDTO update(TedarikciUpdateDTO dto) {
        return mapper.toDTO(repository.save(mapper.toEntity(dto)));
    }
}
