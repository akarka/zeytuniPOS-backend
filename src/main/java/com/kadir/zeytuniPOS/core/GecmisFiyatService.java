package com.kadir.zeytuniPOS.core;

import com.kadir.zeytuniPOS.data.GecmisFiyat;
import com.kadir.zeytuniPOS.data.GecmisFiyatRepository;
import com.kadir.zeytuniPOS.dto.GecmisFiyatCreateDTO;
import com.kadir.zeytuniPOS.dto.GecmisFiyatDTO;
import com.kadir.zeytuniPOS.dto.GecmisFiyatUpdateDTO;
import com.kadir.zeytuniPOS.mapper.GecmisFiyatMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GecmisFiyatService extends AbstractService<GecmisFiyat, Integer> {

    private final GecmisFiyatRepository gecmisFiyatRepository;
    private final GecmisFiyatMapper gecmisFiyatMapper;

    @Autowired
    public GecmisFiyatService(GecmisFiyatRepository gecmisFiyatRepository, 
                             GecmisFiyatMapper gecmisFiyatMapper) {
        super(gecmisFiyatRepository);
        this.gecmisFiyatRepository = gecmisFiyatRepository;
        this.gecmisFiyatMapper = gecmisFiyatMapper;
    }

    public GecmisFiyatDTO createGecmisFiyat(GecmisFiyatCreateDTO createDTO) {
        GecmisFiyat entity = gecmisFiyatMapper.toEntity(createDTO);
        GecmisFiyat savedEntity = gecmisFiyatRepository.save(entity);
        return gecmisFiyatMapper.toDTO(savedEntity);
    }

    public List<GecmisFiyatDTO> getAllGecmisFiyatlar() {
        List<GecmisFiyat> entities = gecmisFiyatRepository.findAll();
        return gecmisFiyatMapper.toDTOList(entities);
    }

    public GecmisFiyatDTO getGecmisFiyatById(Integer id) {
        GecmisFiyat entity = getById(id);
        return gecmisFiyatMapper.toDTO(entity);
    }

    public GecmisFiyatDTO updateGecmisFiyat(Integer id, GecmisFiyatUpdateDTO updateDTO) {
        
        getById(id);
        
        GecmisFiyat entity = gecmisFiyatMapper.toEntity(updateDTO);
        GecmisFiyat updatedEntity = gecmisFiyatRepository.save(entity);
        return gecmisFiyatMapper.toDTO(updatedEntity);
    }

    public void deleteGecmisFiyat(Integer id) {
        gecmisFiyatRepository.deleteById(id);
    }
}
