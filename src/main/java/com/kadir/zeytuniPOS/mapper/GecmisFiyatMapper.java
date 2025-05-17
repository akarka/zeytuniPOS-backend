package com.kadir.zeytuniPOS.mapper;

import com.kadir.zeytuniPOS.data.Gecmis;
import com.kadir.zeytuniPOS.dto.GecmisFiyatDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GecmisFiyatMapper {

    @Mapping(source = "urun.urunAdi", target = "urunAdi")
    GecmisFiyatDTO toDTO(Gecmis gecmis);

    List<GecmisFiyatDTO> toDTOList(List<Gecmis> gecmisList);
}
