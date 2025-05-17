package com.kadir.zeytuniPOS.mapper;

import com.kadir.zeytuniPOS.data.Envanter;
import com.kadir.zeytuniPOS.dto.EnvanterDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EnvanterMapper {

    @Mapping(source = "tedarikci.tedarikciId", target = "tedarikciId")
    EnvanterDTO toDTO(Envanter envanter);

    List<EnvanterDTO> toDTOList(List<Envanter> envanterList);
}
