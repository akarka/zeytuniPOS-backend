package com.kadir.zeytuniPOS.core;

import com.kadir.zeytuniPOS.data.Rol;
import com.kadir.zeytuniPOS.data.RolRepository;
import com.kadir.zeytuniPOS.dto.RolCreateDTO;
import com.kadir.zeytuniPOS.dto.RolDTO;
import com.kadir.zeytuniPOS.dto.RolUpdateDTO;
import com.kadir.zeytuniPOS.mapper.RolMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolService extends AbstractService<Rol, Integer> {

    private final RolRepository rolRepository;
    private final RolMapper rolMapper;

    @Autowired
    public RolService(RolRepository rolRepository, 
                     RolMapper rolMapper) {
        super(rolRepository);
        this.rolRepository = rolRepository;
        this.rolMapper = rolMapper;
    }

    public RolDTO createRol(RolCreateDTO createDTO) {
        Rol entity = rolMapper.toEntity(createDTO);
        Rol savedEntity = rolRepository.save(entity);
        return rolMapper.toDTO(savedEntity);
    }

    public List<RolDTO> getAllRoller() {
        List<Rol> entities = rolRepository.findAll();
        return rolMapper.toDTOList(entities);
    }

    public RolDTO getRolById(Integer id) {
        Rol entity = getById(id);
        return rolMapper.toDTO(entity);
    }

    public RolDTO updateRol(Integer id, RolUpdateDTO updateDTO) {
        // ID kontrolü
        getById(id);
        
        Rol entity = rolMapper.toEntity(updateDTO);
        Rol updatedEntity = rolRepository.save(entity);
        return rolMapper.toDTO(updatedEntity);
    }

    public void deleteRol(Integer id) {
        rolRepository.deleteById(id);
    }
}
