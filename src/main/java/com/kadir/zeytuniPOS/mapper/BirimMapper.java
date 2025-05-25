package com.kadir.zeytuniPOS.mapper;

import com.kadir.zeytuniPOS.data.Birim;
import com.kadir.zeytuniPOS.dto.BirimDTOCreate;
import com.kadir.zeytuniPOS.dto.BirimDTO;
import com.kadir.zeytuniPOS.dto.BirimDTOUpdate;

import java.util.List;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface BirimMapper {
    BirimDTO toDTO(Birim birim);

    List<BirimDTO> toDTOList(List<Birim> birim);

    @Mapping(target = "birimId", ignore = true)
    Birim toEntity(BirimDTOCreate dto);

    @Mapping(target = "birimId", ignore = true)
    Birim toEntity(BirimDTOUpdate dto);

}
