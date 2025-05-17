package com.kadir.zeytuniPOS.mapper;

import com.kadir.zeytuniPOS.data.UrunKategorileri;
import com.kadir.zeytuniPOS.dto.UrunKategoriDTO;

import java.util.List;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface UrunKategoriMapper {
    UrunKategoriDTO toDTO(UrunKategorileri kategori);

    List<UrunKategoriDTO> toDTOList(List<UrunKategorileri> kategoriler);
}