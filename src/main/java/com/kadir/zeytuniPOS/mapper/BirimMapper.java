package com.kadir.zeytuniPOS.mapper;

import com.kadir.zeytuniPOS.data.Birim;
import com.kadir.zeytuniPOS.dto.BirimCreateDTO;
import com.kadir.zeytuniPOS.dto.BirimDTO;
import com.kadir.zeytuniPOS.dto.BirimUpdateDTO;

import java.util.List;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface BirimMapper {
    BirimDTO toDTO(Birim birim);

    List<BirimDTO> toDTOList(List<Birim> birim);

    @Mapping(target = "birimId", ignore = true)
    Birim toEntity(BirimCreateDTO dto);

    Birim toEntity(BirimUpdateDTO dto);

}
