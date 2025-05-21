package com.kadir.zeytuniPOS.mapper;

import com.kadir.zeytuniPOS.data.AltKategori;
import com.kadir.zeytuniPOS.data.Tedarikci;
import com.kadir.zeytuniPOS.data.TedarikciAltKategori;
import com.kadir.zeytuniPOS.dto.TedarikciAltKategoriDTO;
import com.kadir.zeytuniPOS.dto.TedarikciAltKategoriCreateDTO;
import com.kadir.zeytuniPOS.dto.TedarikciAltKategoriUpdateDTO;

import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface TedarikciAltKategoriMapper {

    default TedarikciAltKategoriDTO toDTO(TedarikciAltKategori entity) {
        if (entity == null)
            return null;

        TedarikciAltKategoriDTO dto = new TedarikciAltKategoriDTO();
        dto.setTedarikciAltKategoriId(entity.getTedarikciAltKategoriId());
        
        if (entity.getTedarikci() != null) {
            dto.setTedarikciId(entity.getTedarikci().getTedarikciId());
        }
        
        if (entity.getAltKategori() != null) {
            dto.setAltKategoriId(entity.getAltKategori().getAltkId());
        }

        return dto;
    }

    default List<TedarikciAltKategoriDTO> toDTOList(List<TedarikciAltKategori> entities) {
        return entities.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Mapping(target = "tedarikciAltKategoriId", ignore = true)
    @Mapping(source = "tedarikciId", target = "tedarikci", qualifiedByName = "mapTedarikciFromId")
    @Mapping(source = "altKategoriId", target = "altKategori", qualifiedByName = "mapAltKategoriFromId")
    TedarikciAltKategori toEntity(TedarikciAltKategoriCreateDTO dto);

    @Mapping(source = "tedarikciId", target = "tedarikci", qualifiedByName = "mapTedarikciFromId")
    @Mapping(source = "altKategoriId", target = "altKategori", qualifiedByName = "mapAltKategoriFromId")
    TedarikciAltKategori toEntity(TedarikciAltKategoriUpdateDTO dto);

    @Named("mapTedarikciFromId")
    static Tedarikci mapTedarikciFromId(Integer id) {
        if (id == null)
            return null;
        Tedarikci tedarikci = new Tedarikci();
        tedarikci.setTedarikciId(id);
        return tedarikci;
    }

    @Named("mapAltKategoriFromId")
    static AltKategori mapAltKategoriFromId(Integer id) {
        if (id == null)
            return null;
        AltKategori altKategori = new AltKategori();
        altKategori.setAltkId(id);
        return altKategori;
    }
}
