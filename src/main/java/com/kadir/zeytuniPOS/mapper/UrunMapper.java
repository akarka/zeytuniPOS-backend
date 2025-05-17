package com.kadir.zeytuniPOS.mapper;

import com.kadir.zeytuniPOS.data.Urun;
import com.kadir.zeytuniPOS.dto.UrunDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UrunMapper {
    UrunDTO toDTO(Urun urun);

    List<UrunDTO> toDTOList(List<Urun> urunler);
}
