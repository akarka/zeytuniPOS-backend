package com.kadir.zeytuniPOS.mapper;

import com.kadir.zeytuniPOS.data.Rol;
import com.kadir.zeytuniPOS.dto.RolCreateDTO;
import com.kadir.zeytuniPOS.dto.RolDTO;
import com.kadir.zeytuniPOS.dto.RolUpdateDTO;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface RolMapper {

    default RolDTO toDTO(Rol entity) {
        if (entity == null)
            return null;

        RolDTO dto = new RolDTO();
        dto.setRolId(entity.getRolId());
        dto.setRolAdi(entity.getRolAdi());

        return dto;
    }

    default List<RolDTO> toDTOList(List<Rol> entities) {
        return entities.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Mapping(target = "rolId", ignore = true)
    Rol toEntity(RolCreateDTO dto);

    Rol toEntity(RolUpdateDTO dto);
}
