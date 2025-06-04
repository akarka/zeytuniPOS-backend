package com.kadir.zeytuniPOS.mapper;

import com.kadir.zeytuniPOS.data.GecmisFiyat;
import com.kadir.zeytuniPOS.data.Urun;
import com.kadir.zeytuniPOS.dto.GecmisFiyatCreateDTO;
import com.kadir.zeytuniPOS.dto.GecmisFiyatDTO;
import com.kadir.zeytuniPOS.dto.GecmisFiyatUpdateDTO;

import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface GecmisFiyatMapper {

    default GecmisFiyatDTO toDTO(GecmisFiyat entity) {
        if (entity == null)
            return null;

        GecmisFiyatDTO dto = new GecmisFiyatDTO();
        dto.setGecmisFiyatId(entity.getGecmisFiyatId());
        dto.setSatisFiyati(entity.getSatisFiyati());
        dto.setTarih(entity.getTarih());

        if (entity.getUrun() != null) {
            dto.setUrunId(entity.getUrun().getUrunId());
            dto.setUrunAdi(entity.getUrun().getUrunAdi());
        }

        return dto;
    }

    default List<GecmisFiyatDTO> toDTOList(List<GecmisFiyat> entities) {
        return entities.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Mapping(target = "gecmisFiyatId", ignore = true)
    @Mapping(source = "urunId", target = "urun", qualifiedByName = "mapUrunFromId")
    GecmisFiyat toEntity(GecmisFiyatCreateDTO dto);

    @Mapping(source = "urunId", target = "urun", qualifiedByName = "mapUrunFromId")
    GecmisFiyat toEntity(GecmisFiyatUpdateDTO dto);

    @Named("mapUrunFromId")
    static Urun mapUrunFromId(Integer id) {
        if (id == null)
            return null;
        Urun urun = new Urun();
        urun.setUrunId(id);
        return urun;
    }
}
