package com.kadir.zeytuniPOS.mapper;

import com.kadir.zeytuniPOS.data.Rol;
import com.kadir.zeytuniPOS.dto.RolDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RolMapper {
    RolDTO toDTO(Rol rol);

    List<RolDTO> toDTOList(List<Rol> roller);
}
