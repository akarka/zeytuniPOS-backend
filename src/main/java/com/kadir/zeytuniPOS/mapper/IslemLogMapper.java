package com.kadir.zeytuniPOS.mapper;

import com.kadir.zeytuniPOS.data.IslemLog;
import com.kadir.zeytuniPOS.dto.IslemLogDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IslemLogMapper {

    @Mapping(source = "kullanici.kullaniciAdi", target = "kullaniciAdi")
    IslemLogDTO toDTO(IslemLog log);

    List<IslemLogDTO> toDTOList(List<IslemLog> loglar);
}
