package com.kadir.zeytuniPOS.core;

import com.kadir.zeytuniPOS.data.Birim;
import com.kadir.zeytuniPOS.data.BirimRepository;
import com.kadir.zeytuniPOS.dto.BirimCreateDTO;
import com.kadir.zeytuniPOS.dto.BirimDTO;
import com.kadir.zeytuniPOS.dto.BirimUpdateDTO;
import com.kadir.zeytuniPOS.mapper.BirimMapper;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BirimService extends AbstractService<Birim, Integer> {

    private final BirimMapper mapper;
    private final BirimRepository birimRepository;

    public BirimService(BirimRepository birimRepository, BirimMapper mapper) {
        super(birimRepository);
        this.mapper = mapper;
        this.birimRepository = birimRepository;
    }

    public BirimDTO createFromDTO(BirimCreateDTO dto) {
        Birim entity = mapper.toEntity(dto);
        return mapper.toDTO(birimRepository.save(entity));
    }

    public List<BirimDTO> getAllDTO() {
        return mapper.toDTOList(getAll());
    }

    public BirimDTO getByIdDTO(Integer birimId) {
        Birim entity = getById(birimId);
        return mapper.toDTO(entity);
    }

    public BirimDTO update(BirimUpdateDTO dto) {
        Birim existing = birimRepository.findById(dto.getBirimId())
                .orElseThrow(() -> new EntityNotFoundException("Birim bulunamadı"));

        existing.setBirimAdi(dto.getBirimAdi()); // 🔁 direkt güncelle

        return mapper.toDTO(birimRepository.save(existing));
    }

    public void deleteByBirimAdi(String birimAdi) {
        Birim birim = birimRepository.findByBirimAdi(birimAdi)
                .orElseThrow(() -> new EntityNotFoundException("Birim bulunamadı: " + birimAdi));
        birimRepository.delete(birim);
    }
}
