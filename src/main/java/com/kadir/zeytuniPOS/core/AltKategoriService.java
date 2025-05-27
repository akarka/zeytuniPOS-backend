package com.kadir.zeytuniPOS.core;

import com.kadir.zeytuniPOS.core.logging.LogIslem;
import com.kadir.zeytuniPOS.data.AltKategori;
import com.kadir.zeytuniPOS.data.AltKategoriRepository;
import com.kadir.zeytuniPOS.dto.AltKategoriCreateDTO;
import com.kadir.zeytuniPOS.dto.AltKategoriDTO;
import com.kadir.zeytuniPOS.dto.AltKategoriUpdateDTO;
import com.kadir.zeytuniPOS.mapper.AltKategoriMapper;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AltKategoriService extends AbstractService<AltKategori, Integer> {

    private final AltKategoriRepository repository;
    private final AltKategoriMapper mapper;

    public AltKategoriService(AltKategoriRepository repository, AltKategoriMapper mapper) {
        super(repository);
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<AltKategoriDTO> getAllDTO() {
        return mapper.toDTOList(repository.findAll());
    }

    @LogIslem(islemTuru = "CREATE", hedefTablo = "Alt Kategori", aciklama = "Alt Kategori eklendi", hedefIdGetterMetodu = "getAltkId")
    public AltKategoriDTO createFromDTO(AltKategoriCreateDTO dto) {
        AltKategori entity = mapper.toEntity(dto);
        return mapper.toDTO(repository.save(entity));
    }

    @LogIslem(islemTuru = "UPDATE", hedefTablo = "Alt Kategori", aciklama = "Alt Kategori güncellendi", hedefIdGetterMetodu = "getAltkId")
    public AltKategoriDTO update(AltKategoriUpdateDTO dto) {
        AltKategori entity = mapper.toEntity(dto);
        return mapper.toDTO(repository.save(entity));
    }

    @LogIslem(islemTuru = "DELETE", hedefTablo = "Alt Kategori", aciklama = "Alt Kategori silindi", hedefIdGetterMetodu = "getAltkId")
    public void deleteById(Integer id) {
       repository.deleteById(id);
    }

}
