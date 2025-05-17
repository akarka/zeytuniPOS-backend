package com.kadir.zeytuniPOS.mapper;

import com.kadir.zeytuniPOS.data.Birim;
import com.kadir.zeytuniPOS.dto.BirimDTO;

import java.util.List;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface BirimMapper {
    BirimDTO toDTO(Birim birim);

    List<BirimDTO> toDTOList(List<Birim> birim);
}
