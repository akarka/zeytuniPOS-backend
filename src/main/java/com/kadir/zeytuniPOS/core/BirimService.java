package com.kadir.zeytuniPOS.core;

import com.kadir.zeytuniPOS.core.logging.LogIslem;
import com.kadir.zeytuniPOS.data.Birim;
import com.kadir.zeytuniPOS.data.BirimRepository;
import com.kadir.zeytuniPOS.dto.BirimDTOCreate;
import com.kadir.zeytuniPOS.dto.BirimDTO;
import com.kadir.zeytuniPOS.dto.BirimDTOUpdate;
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

    @LogIslem(islemTuru = "CREATE", hedefTablo = "Birimler", aciklama = "Yeni birim eklendi", hedefIdGetterMetodu = "getBirimId")
    public BirimDTO createFromDTO(BirimDTOCreate dto) {
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

    @LogIslem(islemTuru = "UPDATE", hedefTablo = "Birimler", aciklama = "Birim güncellendi", hedefIdGetterMetodu = "getBirimId")
    public BirimDTO update(BirimDTOUpdate dto) {
        Birim mevcut = birimRepository.findById(dto.getBirimId())
                .orElseThrow(() -> new EntityNotFoundException("Birim bulunamadı"));

        mevcut.setBirimAdi(dto.getBirimAdi());

        return mapper.toDTO(birimRepository.save(mevcut));
    }

    @LogIslem(islemTuru = "DELETE", hedefTablo = "Birimler", aciklama = "Birim silindi", hedefIdParametreIndeksi = 0)
    public void deleteById(Integer birimId) {
        Birim birim = birimRepository.findById(birimId)
                .orElseThrow(() -> new EntityNotFoundException("Birim bulunamadı: " + birimId));
        birimRepository.delete(birim);
    }
}
