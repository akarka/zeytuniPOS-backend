package com.kadir.zeytuniPOS.core;

import com.kadir.zeytuniPOS.data.Kullanici;
import com.kadir.zeytuniPOS.data.KullaniciRepository;
import com.kadir.zeytuniPOS.dto.KullaniciCreateDTO;
import com.kadir.zeytuniPOS.dto.KullaniciDTO;
import com.kadir.zeytuniPOS.dto.KullaniciUpdateDTO;
import com.kadir.zeytuniPOS.mapper.KullaniciMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KullaniciService extends AbstractService<Kullanici, Integer> {

    private final KullaniciRepository kullaniciRepository;
    private final KullaniciMapper kullaniciMapper;

    @Autowired
    public KullaniciService(KullaniciRepository kullaniciRepository, 
                           KullaniciMapper kullaniciMapper) {
        super(kullaniciRepository);
        this.kullaniciRepository = kullaniciRepository;
        this.kullaniciMapper = kullaniciMapper;
    }

    public KullaniciDTO createKullanici(KullaniciCreateDTO createDTO) {
        Kullanici entity = kullaniciMapper.toEntity(createDTO);
        Kullanici savedEntity = kullaniciRepository.save(entity);
        return kullaniciMapper.toDTO(savedEntity);
    }

    public List<KullaniciDTO> getAllKullanicilar() {
        List<Kullanici> entities = kullaniciRepository.findAll();
        return kullaniciMapper.toDTOList(entities);
    }

    public KullaniciDTO getKullaniciById(Integer id) {
        Kullanici entity = getById(id);
        return kullaniciMapper.toDTO(entity);
    }

    public KullaniciDTO updateKullanici(Integer id, KullaniciUpdateDTO updateDTO) {
        
        getById(id);
        
        Kullanici entity = kullaniciMapper.toEntity(updateDTO);
        Kullanici updatedEntity = kullaniciRepository.save(entity);
        return kullaniciMapper.toDTO(updatedEntity);
    }

    public void deleteKullanici(Integer id) {
        kullaniciRepository.deleteById(id);
    }
}
