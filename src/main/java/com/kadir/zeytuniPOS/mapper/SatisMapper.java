package com.kadir.zeytuniPOS.mapper;

import com.kadir.zeytuniPOS.data.Satis;
import com.kadir.zeytuniPOS.dto.SatisDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SatisMapper {
    SatisDTO toDTO(Satis satis);

    List<SatisDTO> toDTOList(List<Satis> satislar);
}
