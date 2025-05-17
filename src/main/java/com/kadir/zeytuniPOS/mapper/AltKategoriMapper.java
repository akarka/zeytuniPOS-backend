package com.kadir.zeytuniPOS.mapper;

import com.kadir.zeytuniPOS.data.AltKategori;
import com.kadir.zeytuniPOS.dto.AltKategoriDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AltKategoriMapper {
    AltKategoriDTO toDTO(AltKategori altKategori);

    List<AltKategoriDTO> toDTOList(List<AltKategori> altKategoriler);
}