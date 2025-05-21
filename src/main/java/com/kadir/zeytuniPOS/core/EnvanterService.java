package com.kadir.zeytuniPOS.core;

import com.kadir.zeytuniPOS.data.Envanter;
import com.kadir.zeytuniPOS.data.EnvanterRepository;
import com.kadir.zeytuniPOS.dto.EnvanterCreateDTO;
import com.kadir.zeytuniPOS.dto.EnvanterDTO;
import com.kadir.zeytuniPOS.dto.EnvanterUpdateDTO;
import com.kadir.zeytuniPOS.mapper.EnvanterMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnvanterService extends AbstractService<Envanter, Integer> {

    private final EnvanterRepository envanterRepository;
    private final EnvanterMapper envanterMapper;

    @Autowired
    public EnvanterService(EnvanterRepository envanterRepository, 
                          EnvanterMapper envanterMapper) {
        super(envanterRepository);
        this.envanterRepository = envanterRepository;
        this.envanterMapper = envanterMapper;
    }

    public EnvanterDTO createEnvanter(EnvanterCreateDTO createDTO) {
        Envanter entity = envanterMapper.toEntity(createDTO);
        Envanter savedEntity = envanterRepository.save(entity);
        return envanterMapper.toDTO(savedEntity);
    }

    public List<EnvanterDTO> getAllEnvanterler() {
        List<Envanter> entities = envanterRepository.findAll();
        return envanterMapper.toDTOList(entities);
    }

    public EnvanterDTO getEnvanterById(Integer id) {
        Envanter entity = getById(id);
        return envanterMapper.toDTO(entity);
    }

    public EnvanterDTO updateEnvanter(Integer id, EnvanterUpdateDTO updateDTO) {
        
        getById(id);
        
        Envanter entity = envanterMapper.toEntity(updateDTO);
        Envanter updatedEntity = envanterRepository.save(entity);
        return envanterMapper.toDTO(updatedEntity);
    }

    public void deleteEnvanter(Integer id) {
        envanterRepository.deleteById(id);
    }
}
