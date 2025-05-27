package com.kadir.zeytuniPOS.core;

import com.kadir.zeytuniPOS.core.logging.LogIslem;
import com.kadir.zeytuniPOS.data.TedarikciAltKategori;
import com.kadir.zeytuniPOS.data.TedarikciAltKategoriRepository;
import com.kadir.zeytuniPOS.dto.TedarikciAltKategoriCreateDTO;
import com.kadir.zeytuniPOS.dto.TedarikciAltKategoriDTO;
import com.kadir.zeytuniPOS.dto.TedarikciAltKategoriUpdateDTO;
import com.kadir.zeytuniPOS.mapper.TedarikciAltKategoriMapper;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TedarikciAltKategoriService extends AbstractService<TedarikciAltKategori, Integer> {

    private final TedarikciAltKategoriRepository repository;
    private final TedarikciAltKategoriMapper tedarikciAltKategoriMapper;

    public TedarikciAltKategoriService(TedarikciAltKategoriRepository repository,
            TedarikciAltKategoriMapper tedarikciAltKategoriMapper) {
        super(repository);
        this.repository = repository;
        this.tedarikciAltKategoriMapper = tedarikciAltKategoriMapper;
    }

    @LogIslem(islemTuru = "CREATE", hedefTablo = "Tedarikci Kategorileri", aciklama = "Tedarikçi kategorisi eklendi", hedefIdGetterMetodu = "getTedarikciAltKategoriId")
    public TedarikciAltKategoriDTO createTedarikciAltKategori(TedarikciAltKategoriCreateDTO createDTO) {
        TedarikciAltKategori entity = tedarikciAltKategoriMapper.toEntity(createDTO);
        TedarikciAltKategori savedEntity = repository.save(entity);
        return tedarikciAltKategoriMapper.toDTO(savedEntity);
    }

    public List<TedarikciAltKategoriDTO> getAllTedarikciAltKategoriler() {
        List<TedarikciAltKategori> entities = repository.findAll();
        return tedarikciAltKategoriMapper.toDTOList(entities);
    }

    public TedarikciAltKategoriDTO getTedarikciAltKategoriById(Integer id) {
        TedarikciAltKategori entity = getById(id);
        return tedarikciAltKategoriMapper.toDTO(entity);
    }

    @LogIslem(islemTuru = "UPDATE", hedefTablo = "Tedarikci Kategorileri", aciklama = "Tedarikçi kategorisi güncellendi", hedefIdGetterMetodu = "getTedarikciAltKategoriId")
    public TedarikciAltKategoriDTO updateTedarikciAltKategori(Integer id, TedarikciAltKategoriUpdateDTO updateDTO) {
        getById(id);

        TedarikciAltKategori entity = tedarikciAltKategoriMapper.toEntity(updateDTO);
        TedarikciAltKategori updatedEntity = repository.save(entity);
        return tedarikciAltKategoriMapper.toDTO(updatedEntity);
    }
    
    @LogIslem(islemTuru = "DELETE", hedefTablo = "Tedarikci Kategorileri", aciklama = "Tedarikçi kategorisi silindi", hedefIdGetterMetodu = "getTedarikciAltKategoriId")
    public void deleteTedarikciAltKategori(Integer id) {
        repository.deleteById(id);
    }
}
