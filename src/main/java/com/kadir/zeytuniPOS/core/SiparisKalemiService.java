package com.kadir.zeytuniPOS.core;

import com.kadir.zeytuniPOS.data.SiparisKalemi;
import com.kadir.zeytuniPOS.dto.SiparisKalemiCreateDTO;
import com.kadir.zeytuniPOS.dto.SiparisKalemiDTO;
import com.kadir.zeytuniPOS.dto.SiparisKalemiUpdateDTO;
import com.kadir.zeytuniPOS.mapper.SiparisKalemiMapper;
import com.kadir.zeytuniPOS.data.SiparisKalemiRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SiparisKalemiService {

    private final SiparisKalemiRepository repository;
    private final SiparisKalemiMapper mapper;

    public SiparisKalemiService(SiparisKalemiRepository repository, SiparisKalemiMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<SiparisKalemiDTO> getAllDTO() {
        return repository.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    public SiparisKalemiDTO createFromDTO(SiparisKalemiCreateDTO dto) {
        SiparisKalemi entity = mapper.toEntity(dto);
        return mapper.toDto(repository.save(entity));
    }

    public SiparisKalemiDTO update(SiparisKalemiUpdateDTO dto) {
        SiparisKalemi entity = repository.findById(dto.getSiparisKalemId())
                .orElseThrow(() -> new RuntimeException("Sipariş kalemi bulunamadı"));
        // Update fields from DTO to entity
        entity.setMiktar(dto.getMiktar());
        entity.setSatisFiyati(dto.getSatisFiyati());
        // Assuming urunId is not updated directly, but through a new Urun object if
        // needed
        // entity.setUrun(mapper.mapUrunIdToUrun(dto.getUrunId())); // This would
        // require fetching Urun from DB

        return mapper.toDto(repository.save(entity));
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
