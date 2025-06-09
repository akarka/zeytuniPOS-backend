package com.kadir.zeytuniPOS.mapper;

import com.kadir.zeytuniPOS.data.Siparis;
import com.kadir.zeytuniPOS.dto.SiparisDTO;
import com.kadir.zeytuniPOS.dto.SiparisCreateDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = { SiparisKalemiMapper.class })
public interface SiparisMapper {

    SiparisMapper INSTANCE = Mappers.getMapper(SiparisMapper.class);

    SiparisDTO toDto(Siparis siparis);

    @Mapping(target = "siparisId", ignore = true)
    @Mapping(target = "toplamFiyat", ignore = true)
    @Mapping(target = "siparisTarihi", ignore = true)
    Siparis toEntity(SiparisCreateDTO siparisCreateDTO);
}
