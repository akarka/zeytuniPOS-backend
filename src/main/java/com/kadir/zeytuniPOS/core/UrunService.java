package com.kadir.zeytuniPOS.core;

import com.kadir.zeytuniPOS.core.logging.LogIslem;
import com.kadir.zeytuniPOS.data.Urun;
import com.kadir.zeytuniPOS.data.UrunRepository;
import com.kadir.zeytuniPOS.dto.*;
import com.kadir.zeytuniPOS.mapper.UrunMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        Urun saved = repository.save(entity);
        return mapper.toDTO(saved);
    }

    @LogIslem(islemTuru = "UPDATE", hedefTablo = "Urunler", aciklama = "Ürün güncellendi")
    public UrunDTO update(UrunDTOUpdate dto) {
        // ID kontrolü
        getById(dto.getUrunId());

        Urun updated = repository.save(mapper.toEntity(dto));
        return mapper.toDTO(updated);
    }

    @LogIslem(islemTuru = "DELETE", hedefTablo = "Urunler", aciklama = "Ürün silindi")
    public void deleteWithDTO(UrunDTODelete deleteDTO) {
        // Onay kodu kontrolü
        if (deleteDTO.getOnayKodu() != null && !deleteDTO.getOnayKodu().equals("ONAYLA")) {
            throw new RuntimeException("Geçersiz onay kodu. Silme işlemi için 'ONAYLA' yazmalısınız.");
        }
        // İlişkili kayıtları kontrol et
        if (Boolean.TRUE.equals(deleteDTO.getIliskiliKayitlariSil())) {
            // İlişkili kayıtları silme işlemi burada yapılabilir
            // Örneğin: urunTedarikciRepository.deleteByUrunId(deleteDTO.getUrunId());
        }

        repository.deleteById(deleteDTO.getUrunId());
    }

    public List<UrunDTO> findByAltkId(Integer altKategoriId) {
        List<Urun> entities = repository.findByAltKategoriAltkId(altKategoriId);
        return mapper.toDTOList(entities);
    }

}
