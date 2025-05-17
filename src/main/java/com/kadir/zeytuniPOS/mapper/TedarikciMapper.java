package com.kadir.zeytuniPOS.mapper;

import com.kadir.zeytuniPOS.data.Tedarikci;
import com.kadir.zeytuniPOS.dto.TedarikciDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TedarikciMapper {
    TedarikciDTO toDTO(Tedarikci tedarikci);

    List<TedarikciDTO> toDTOList(List<Tedarikci> tedarikciler);
}
