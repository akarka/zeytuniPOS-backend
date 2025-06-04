package com.kadir.zeytuniPOS.core;

import com.kadir.zeytuniPOS.core.logging.LogIslem;
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

    @LogIslem(islemTuru = "CREATE", hedefTablo = "Roller", aciklama = "Rol eklendi", hedefIdGetterMetodu = "getRolId")
    public RolDTO create(RolCreateDTO createDTO) {
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

    @LogIslem(islemTuru = "UPDATE", hedefTablo = "Roller", aciklama = "Rol güncellendi", hedefIdGetterMetodu = "getRolId")
    public RolDTO update(RolUpdateDTO updateDTO) {

        Rol entity = rolMapper.toEntity(updateDTO);
        Rol updatedEntity = rolRepository.save(entity);
        return rolMapper.toDTO(updatedEntity);
    }

    @LogIslem(islemTuru = "DELETE", hedefTablo = "Roller", aciklama = "Rol silinddi", hedefIdGetterMetodu = "getRolId")
    public void delete(Integer id) {
        rolRepository.deleteById(id);
    }
}
