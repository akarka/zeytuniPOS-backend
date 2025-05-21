package com.kadir.zeytuniPOS.mapper;

import com.kadir.zeytuniPOS.data.Kullanici;
import com.kadir.zeytuniPOS.dto.KullaniciCreateDTO;
import com.kadir.zeytuniPOS.dto.KullaniciDTO;
import com.kadir.zeytuniPOS.dto.KullaniciUpdateDTO;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface KullaniciMapper {

    default KullaniciDTO toDTO(Kullanici entity) {
        if (entity == null)
            return null;

        KullaniciDTO dto = new KullaniciDTO();
        dto.setKullaniciId(entity.getKullaniciId());
        dto.setKullaniciAdi(entity.getKullaniciAdi());
        dto.setSifreHash(entity.getSifreHash());
        dto.setAktif(entity.getAktif());

        return dto;
    }

    default List<KullaniciDTO> toDTOList(List<Kullanici> entities) {
        return entities.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Mapping(target = "kullaniciId", ignore = true)
    Kullanici toEntity(KullaniciCreateDTO dto);

    Kullanici toEntity(KullaniciUpdateDTO dto);
}
