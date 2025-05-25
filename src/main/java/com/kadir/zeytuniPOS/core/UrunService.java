package com.kadir.zeytuniPOS.core;

import com.kadir.zeytuniPOS.core.logging.LogIslem;
import com.kadir.zeytuniPOS.data.Urun;
import com.kadir.zeytuniPOS.data.UrunRepository;
import com.kadir.zeytuniPOS.dto.*;
import com.kadir.zeytuniPOS.mapper.UrunMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class UrunService extends AbstractService<Urun, Integer> {

    private final UrunRepository repository;
    private final UrunMapper mapper;

    @Autowired
    public UrunService(UrunRepository repository, UrunMapper mapper) {
        super(repository);
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<UrunDTO> getAllDTO() {
        return mapper.toDTOList(repository.findAll());
    }

    public UrunDTO getByIdDTO(Integer id) {
        Urun entity = getById(id);
        return mapper.toDTO(entity);
    }

    @LogIslem(islemTuru = "CREATE", hedefTablo = "Urunler", aciklama = "Yeni ürün eklendi")
    public UrunDTO createFromDTO(UrunDTOCreate dto) {
        Urun entity = mapper.toEntity(dto);
        return mapper.toDTO(repository.save(entity));
    }

    @LogIslem(islemTuru = "UPDATE", hedefTablo = "Urunler", aciklama = "Ürün güncellendi")
    public UrunDTO update(UrunDTOUpdate dto) {

        Urun mevcut = repository.findById(dto.getUrunId())
                .orElseThrow(() -> new EntityNotFoundException("Ürün bulunamadı"));

        mevcut.setUrunAdi(dto.getUrunAdi());
        return mapper.toDTO(repository.save(mevcut));
    }

    @LogIslem(islemTuru = "DELETE", hedefTablo = "Urunler", aciklama = "Ürün silindi")
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    public List<UrunDTO> findByAltkId(Integer altKategoriId) {
        List<Urun> entities = repository.findByAltKategoriAltkId(altKategoriId);
        return mapper.toDTOList(entities);
    }

}
