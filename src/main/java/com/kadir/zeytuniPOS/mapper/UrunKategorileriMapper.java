package com.kadir.zeytuniPOS.mapper;

import com.kadir.zeytuniPOS.data.UrunKategorileri;
import com.kadir.zeytuniPOS.dto.*;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UrunKategorileriMapper {
    UrunKategorileriDTO toDTO(UrunKategorileri entity);

    List<UrunKategorileriDTO> toDTOList(List<UrunKategorileri> list);

    UrunKategorileri toEntity(UrunKategorileriCreateDTO dto);

    UrunKategorileri toEntity(UrunKategorileriUpdateDTO dto);
}
