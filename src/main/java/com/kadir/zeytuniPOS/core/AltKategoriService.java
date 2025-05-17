package com.kadir.zeytuniPOS.core;

import com.kadir.zeytuniPOS.data.AltKategori;
import com.kadir.zeytuniPOS.data.AltKategoriRepository;
import com.kadir.zeytuniPOS.dto.AltKategoriCreateDTO;
import com.kadir.zeytuniPOS.dto.AltKategoriDTO;
import com.kadir.zeytuniPOS.dto.AltKategoriUpdateDTO;
import com.kadir.zeytuniPOS.mapper.AltKategoriMapper;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AltKategoriService extends AbstractService<AltKategori, Integer> {

    private final AltKategoriRepository repository;
    private final AltKategoriMapper mapper;

    public AltKategoriService(AltKategoriRepository repository, AltKategoriMapper mapper) {
        super(repository);
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<AltKategoriDTO> getAllDTO() {
        return mapper.toDTOList(repository.findAll());
    }

    public AltKategoriDTO createFromDTO(AltKategoriCreateDTO dto) {
        AltKategori entity = mapper.toEntity(dto);
        return mapper.toDTO(repository.save(entity));
    }

    public AltKategoriDTO update(AltKategoriUpdateDTO dto) {
        AltKategori entity = mapper.toEntity(dto);
        return mapper.toDTO(repository.save(entity));
    }

}
