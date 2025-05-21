package com.kadir.zeytuniPOS.core;

import com.kadir.zeytuniPOS.data.TedarikciAltKategori;
import com.kadir.zeytuniPOS.data.TedarikciAltKategoriRepository;
import com.kadir.zeytuniPOS.dto.TedarikciAltKategoriCreateDTO;
import com.kadir.zeytuniPOS.dto.TedarikciAltKategoriDTO;
import com.kadir.zeytuniPOS.dto.TedarikciAltKategoriUpdateDTO;
import com.kadir.zeytuniPOS.mapper.TedarikciAltKategoriMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TedarikciAltKategoriService extends AbstractService<TedarikciAltKategori, Integer> {

    private final TedarikciAltKategoriRepository tedarikciAltKategoriRepository;
    private final TedarikciAltKategoriMapper tedarikciAltKategoriMapper;

    @Autowired
    public TedarikciAltKategoriService(TedarikciAltKategoriRepository tedarikciAltKategoriRepository,
            TedarikciAltKategoriMapper tedarikciAltKategoriMapper) {
        super(tedarikciAltKategoriRepository);
        this.tedarikciAltKategoriRepository = tedarikciAltKategoriRepository;
        this.tedarikciAltKategoriMapper = tedarikciAltKategoriMapper;
    }

    public TedarikciAltKategoriDTO createTedarikciAltKategori(TedarikciAltKategoriCreateDTO createDTO) {
        TedarikciAltKategori entity = tedarikciAltKategoriMapper.toEntity(createDTO);
        TedarikciAltKategori savedEntity = tedarikciAltKategoriRepository.save(entity);
        return tedarikciAltKategoriMapper.toDTO(savedEntity);
    }

    public List<TedarikciAltKategoriDTO> getAllTedarikciAltKategoriler() {
        List<TedarikciAltKategori> entities = tedarikciAltKategoriRepository.findAll();
        return tedarikciAltKategoriMapper.toDTOList(entities);
    }

    public TedarikciAltKategoriDTO getTedarikciAltKategoriById(Integer id) {
        TedarikciAltKategori entity = getById(id);
        return tedarikciAltKategoriMapper.toDTO(entity);
    }

    public TedarikciAltKategoriDTO updateTedarikciAltKategori(Integer id, TedarikciAltKategoriUpdateDTO updateDTO) {
        getById(id);

        TedarikciAltKategori entity = tedarikciAltKategoriMapper.toEntity(updateDTO);
        TedarikciAltKategori updatedEntity = tedarikciAltKategoriRepository.save(entity);
        return tedarikciAltKategoriMapper.toDTO(updatedEntity);
    }

    public void deleteTedarikciAltKategori(Integer id) {
        tedarikciAltKategoriRepository.deleteById(id);
    }
}
