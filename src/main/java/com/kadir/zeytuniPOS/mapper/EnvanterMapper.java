package com.kadir.zeytuniPOS.mapper;

import com.kadir.zeytuniPOS.data.Envanter;
import com.kadir.zeytuniPOS.data.Tedarikci;
import com.kadir.zeytuniPOS.data.Urun;
import com.kadir.zeytuniPOS.dto.EnvanterCreateDTO;
import com.kadir.zeytuniPOS.dto.EnvanterDTO;
import com.kadir.zeytuniPOS.dto.EnvanterUpdateDTO;

import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface EnvanterMapper {

    default EnvanterDTO toDTO(Envanter entity) {
        if (entity == null)
            return null;

        EnvanterDTO dto = new EnvanterDTO();
        dto.setEnvanterId(entity.getEnvanterId());
        dto.setStokMiktari(entity.getStokMiktari());
        dto.setGirisTarihi(entity.getGirisTarihi());
        
        if (entity.getUrun() != null) {
            dto.setUrunId(entity.getUrun().getUrunId());
        }
        
        if (entity.getTedarikci() != null) {
            dto.setTedarikciId(entity.getTedarikci().getTedarikciId());
        }

        return dto;
    }

    default List<EnvanterDTO> toDTOList(List<Envanter> entities) {
        return entities.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Mapping(target = "envanterId", ignore = true)
    @Mapping(source = "urunId", target = "urun", qualifiedByName = "mapUrunFromId")
    @Mapping(source = "tedarikciId", target = "tedarikci", qualifiedByName = "mapTedarikciFromId")
    Envanter toEntity(EnvanterCreateDTO dto);

    @Mapping(source = "urunId", target = "urun", qualifiedByName = "mapUrunFromId")
    @Mapping(source = "tedarikciId", target = "tedarikci", qualifiedByName = "mapTedarikciFromId")
    Envanter toEntity(EnvanterUpdateDTO dto);

    @Named("mapUrunFromId")
    static Urun mapUrunFromId(Integer id) {
        if (id == null)
            return null;
        Urun urun = new Urun();
        urun.setUrunId(id);
        return urun;
    }

    @Named("mapTedarikciFromId")
    static Tedarikci mapTedarikciFromId(Integer id) {
        if (id == null)
            return null;
        Tedarikci tedarikci = new Tedarikci();
        tedarikci.setTedarikciId(id);
        return tedarikci;
    }
}
