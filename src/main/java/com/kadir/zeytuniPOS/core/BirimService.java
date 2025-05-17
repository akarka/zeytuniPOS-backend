package com.kadir.zeytuniPOS.core;

import com.kadir.zeytuniPOS.data.Birim;
import com.kadir.zeytuniPOS.data.BirimRepository;
import com.kadir.zeytuniPOS.dto.BirimDTO;
import com.kadir.zeytuniPOS.mapper.BirimMapper;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class BirimService extends AbstractService<Birim, Integer> {

    private final BirimMapper mapper;

    public BirimService(BirimRepository repository, BirimMapper mapper) {
        super(repository);
        this.mapper = mapper;
    }

    public List<BirimDTO> getAllDTO() {
        return mapper.toDTOList(getAll());
    }

    public BirimDTO getByIdDTO(Integer birimId) {
        Birim entity = getById(birimId);
        return mapper.toDTO(entity);
    }
}
