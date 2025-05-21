package com.kadir.zeytuniPOS.mapper;

import com.kadir.zeytuniPOS.data.Tedarikci;
import com.kadir.zeytuniPOS.data.Urun;
import com.kadir.zeytuniPOS.data.UrunTedarikci;
import com.kadir.zeytuniPOS.dto.UrunTedarikciDTO;
import com.kadir.zeytuniPOS.dto.UrunTedarikciCreateDTO;
import com.kadir.zeytuniPOS.dto.UrunTedarikciUpdateDTO;

import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface UrunTedarikciMapper {

    default UrunTedarikciDTO toDTO(UrunTedarikci entity) {
        if (entity == null)
            return null;

        UrunTedarikciDTO dto = new UrunTedarikciDTO();
        dto.setUrunTedarikciId(entity.getUrunTedarikciId());
        dto.setAlisFiyati(entity.getAlisFiyati());
        dto.setTarih(entity.getTarih());

        if (entity.getUrun() != null) {
            dto.setUrunId(entity.getUrun().getUrunId());
        }

        if (entity.getTedarikci() != null) {
            dto.setTedarikciId(entity.getTedarikci().getTedarikciId());
        }

        return dto;
    }

    default List<UrunTedarikciDTO> toDTOList(List<UrunTedarikci> entities) {
        return entities.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Mapping(target = "urunTedarikciId", ignore = true)
    @Mapping(source = "urunId", target = "urun", qualifiedByName = "mapUrunFromId")
    @Mapping(source = "tedarikciId", target = "tedarikci", qualifiedByName = "mapTedarikciFromId")
    UrunTedarikci toEntity(UrunTedarikciCreateDTO dto);

    @Mapping(source = "urunId", target = "urun", qualifiedByName = "mapUrunFromId")
    @Mapping(source = "tedarikciId", target = "tedarikci", qualifiedByName = "mapTedarikciFromId")
    UrunTedarikci toEntity(UrunTedarikciUpdateDTO dto);

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
