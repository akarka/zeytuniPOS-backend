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

    public GecmisFiyatDTO createGecmisFiyat(GecmisFiyatCreateDTO dto) {
        GecmisFiyat entity = gecmisFiyatMapper.toEntity(dto);
        return gecmisFiyatMapper.toDTO(gecmisFiyatRepository.save(entity));
    }

    public List<GecmisFiyatDTO> getAllGecmisFiyatlar() {
        return gecmisFiyatMapper.toDTOList(gecmisFiyatRepository.findAll());
    }

    public GecmisFiyatDTO getGecmisFiyatById(Integer id) {
        return gecmisFiyatMapper.toDTO(getById(id));
    }

    public GecmisFiyatDTO updateGecmisFiyat(Integer id, GecmisFiyatUpdateDTO dto) {
        getById(id);
        return gecmisFiyatMapper.toDTO(gecmisFiyatRepository.save(gecmisFiyatMapper.toEntity(dto)));
    }

    public void deleteGecmisFiyat(Integer id) {
        gecmisFiyatRepository.deleteById(id);
    }

    public List<GecmisFiyatDTO> getUrunDetayi(Integer urunId) {
        List<GecmisFiyat> liste = gecmisFiyatRepository.findByUrun_UrunIdOrderByTarihDesc(urunId);

        return gecmisFiyatMapper.toDTOList(liste);
    }
}
