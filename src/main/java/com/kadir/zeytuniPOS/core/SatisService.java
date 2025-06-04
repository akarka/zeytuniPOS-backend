package com.kadir.zeytuniPOS.core;

import com.kadir.zeytuniPOS.core.logging.LogIslem;
import com.kadir.zeytuniPOS.data.Satis;
import com.kadir.zeytuniPOS.dto.*;
import com.kadir.zeytuniPOS.mapper.SatisMapper;
import com.kadir.zeytuniPOS.data.SatisRepository;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class SatisService extends AbstractService<Satis, Integer> {

    private final SatisRepository repository;
    private final SatisMapper mapper;
    private final GecmisFiyatService gecmisFiyatService;

    public SatisService(SatisRepository repository, SatisMapper mapper, GecmisFiyatService gecmisFiyatService) {
        super(repository);
        this.repository = repository;
        this.mapper = mapper;
        this.gecmisFiyatService = gecmisFiyatService;
    }

    public List<SatisDTO> getAllDTO() {
        return mapper.toDTOList(repository.findAll());
    }

    @LogIslem(islemTuru = "CREATE", hedefTablo = "Satislar", aciklama = "Satış eklendi", hedefIdGetterMetodu = "getSatisId")
    public SatisDTO createFromDTO(SatisCreateDTO dto) {
        Satis satis = mapper.toEntity(dto);
        Satis saved = repository.save(satis);

        GecmisFiyatCreateDTO fiyatDTO = new GecmisFiyatCreateDTO();
        fiyatDTO.setUrunId(dto.getUrunId());
        fiyatDTO.setSatisFiyati(BigDecimal.valueOf(dto.getSatisFiyati()));
        fiyatDTO.setTarih(saved.getSatisTarihi().toLocalDateTime().toLocalDate());
        gecmisFiyatService.createGecmisFiyat(fiyatDTO);

        return mapper.toDTO(saved);
    }

    @LogIslem(islemTuru = "UPDATE", hedefTablo = "Satislar", aciklama = "Satış güncellendi", hedefIdGetterMetodu = "getSatisId")
    public SatisDTO update(SatisUpdateDTO dto) {
        return mapper.toDTO(repository.save(mapper.toEntity(dto)));
    }

    @LogIslem(islemTuru = "DELETE", hedefTablo = "Satislar", aciklama = "Satış silindi")
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
