package com.kadir.zeytuniPOS.mapper;

import com.kadir.zeytuniPOS.data.IslemLog;
import com.kadir.zeytuniPOS.data.Kullanici;
import com.kadir.zeytuniPOS.dto.IslemLogCreateDTO;
import com.kadir.zeytuniPOS.dto.IslemLogDTO;
import com.kadir.zeytuniPOS.dto.IslemLogUpdateDTO;

import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface IslemLogMapper {

    default IslemLogDTO toDTO(IslemLog entity) {
        if (entity == null)
            return null;

        IslemLogDTO dto = new IslemLogDTO();
        dto.setLogId(entity.getLogId());
        dto.setTarih(entity.getTarih());
        dto.setIslemTuru(entity.getIslemTuru());
        dto.setHedefTablo(entity.getHedefTablo());
        dto.setHedefId(entity.getHedefId());
        dto.setAciklama(entity.getAciklama());
        
        if (entity.getKullanici() != null) {
            dto.setKullaniciId(entity.getKullanici().getKullaniciId());
        }

        return dto;
    }

    default List<IslemLogDTO> toDTOList(List<IslemLog> entities) {
        return entities.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Mapping(target = "logId", ignore = true)
    @Mapping(source = "kullaniciId", target = "kullanici", qualifiedByName = "mapKullaniciFromId")
    IslemLog toEntity(IslemLogCreateDTO dto);

    @Mapping(source = "kullaniciId", target = "kullanici", qualifiedByName = "mapKullaniciFromId")
    IslemLog toEntity(IslemLogUpdateDTO dto);

    @Named("mapKullaniciFromId")
    static Kullanici mapKullaniciFromId(Integer id) {
        if (id == null)
            return null;
        Kullanici kullanici = new Kullanici();
        kullanici.setKullaniciId(id);
        return kullanici;
    }
}
