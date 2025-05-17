package com.kadir.zeytuniPOS.core;

import com.kadir.zeytuniPOS.data.UrunKategorileri;
import com.kadir.zeytuniPOS.dto.*;
import com.kadir.zeytuniPOS.mapper.UrunKategorileriMapper;
import com.kadir.zeytuniPOS.data.UrunKategorileriRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UrunKategorileriService extends AbstractService<UrunKategorileri, Integer> {

    private final UrunKategorileriRepository repo;
    private final UrunKategorileriMapper mapper;

    public UrunKategorileriService(UrunKategorileriRepository repo, UrunKategorileriMapper mapper) {
        super(repo);
        this.repo = repo;
        this.mapper = mapper;
    }

    public List<UrunKategorileriDTO> getAllDTO() {
        return mapper.toDTOList(repo.findAll());
    }

    public UrunKategorileriDTO createFromDTO(UrunKategorileriCreateDTO dto) {
        return mapper.toDTO(repo.save(mapper.toEntity(dto)));
    }

    public UrunKategorileriDTO update(UrunKategorileriUpdateDTO dto) {
        return mapper.toDTO(repo.save(mapper.toEntity(dto)));
    }
}
