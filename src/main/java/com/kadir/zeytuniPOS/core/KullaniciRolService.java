package com.kadir.zeytuniPOS.core;

import com.kadir.zeytuniPOS.data.KullaniciRol;
import com.kadir.zeytuniPOS.data.KullaniciRolRepository;
import com.kadir.zeytuniPOS.dto.KullaniciRolCreateDTO;
import com.kadir.zeytuniPOS.dto.KullaniciRolDTO;
import com.kadir.zeytuniPOS.dto.KullaniciRolUpdateDTO;
import com.kadir.zeytuniPOS.mapper.KullaniciRolMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KullaniciRolService extends AbstractService<KullaniciRol, Integer> {

    private final KullaniciRolRepository kullaniciRolRepository;
    private final KullaniciRolMapper kullaniciRolMapper;

    @Autowired
    public KullaniciRolService(KullaniciRolRepository kullaniciRolRepository,
            KullaniciRolMapper kullaniciRolMapper) {
        super(kullaniciRolRepository);
        this.kullaniciRolRepository = kullaniciRolRepository;
        this.kullaniciRolMapper = kullaniciRolMapper;
    }

    public KullaniciRolDTO createKullaniciRol(KullaniciRolCreateDTO createDTO) {
        KullaniciRol entity = kullaniciRolMapper.toEntity(createDTO);
        KullaniciRol savedEntity = kullaniciRolRepository.save(entity);
        return kullaniciRolMapper.toDTO(savedEntity);
    }

    public List<KullaniciRolDTO> getAllKullaniciRoller() {
        List<KullaniciRol> entities = kullaniciRolRepository.findAll();
        return kullaniciRolMapper.toDTOList(entities);
    }

    public KullaniciRolDTO getKullaniciRolById(Integer id) {
        KullaniciRol entity = getById(id);
        return kullaniciRolMapper.toDTO(entity);
    }

    public KullaniciRolDTO updateKullaniciRol(Integer id, KullaniciRolUpdateDTO updateDTO) {

        getById(id);

        KullaniciRol entity = kullaniciRolMapper.toEntity(updateDTO);

        KullaniciRol updatedEntity = kullaniciRolRepository.save(entity);
        return kullaniciRolMapper.toDTO(updatedEntity);
    }

    public void deleteKullaniciRol(Integer id) {
        kullaniciRolRepository.deleteById(id);
    }
}
