package com.kadir.zeytuniPOS.mapper;

import com.kadir.zeytuniPOS.data.Tedarikci;
import com.kadir.zeytuniPOS.dto.*;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TedarikciMapper {
    TedarikciDTO toDTO(Tedarikci tedarikci);

    List<TedarikciDTO> toDTOList(List<Tedarikci> tedarikciler);

    Tedarikci toEntity(TedarikciCreateDTO dto);

    Tedarikci toEntity(TedarikciUpdateDTO dto);
}
