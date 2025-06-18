package com.kadir.zeytuniPOS.mapper;

import com.kadir.zeytuniPOS.data.Kullanici;
import com.kadir.zeytuniPOS.data.Rol;
import com.kadir.zeytuniPOS.dto.KullaniciCreateDTO;
import com.kadir.zeytuniPOS.dto.KullaniciDTO;
import com.kadir.zeytuniPOS.dto.KullaniciUpdateDTO;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface KullaniciMapper {

    // ENTITY → DTO
    default KullaniciDTO toDTO(Kullanici entity) {
        if (entity == null)
            return null;

        KullaniciDTO dto = new KullaniciDTO();
        dto.setKullaniciId(entity.getKullaniciId());
        dto.setKullaniciAdi(entity.getKullaniciAdi());
        dto.setAktif(entity.getAktif());

        if (entity.getRol() != null) {
            dto.setRolId(entity.getRol().getRolId());
            dto.setRolAdi(entity.getRol().getRolAdi());
        }

        return dto;
    }

    default List<KullaniciDTO> toDTOList(List<Kullanici> entities) {
        return entities.stream().map(this::toDTO).collect(Collectors.toList());
    }

    @Mapping(target = "kullaniciId", ignore = true)
    @Mapping(target = "sifreHash", ignore = true) // Şifre hash işlemi servis katmanında
    @Mapping(source = "rolId", target = "rol", qualifiedByName = "mapRolFromId")
    Kullanici toEntity(KullaniciCreateDTO dto);

    @Mapping(target = "sifreHash", ignore = true)
    @Mapping(source = "rolId", target = "rol", qualifiedByName = "mapRolFromId")
    Kullanici toEntity(KullaniciUpdateDTO dto);

    @Named("mapRolFromId")
    static Rol mapRolFromId(Integer id) {
        if (id == null)
            return null;
        Rol rol = new Rol();
        rol.setRolId(id);
        return rol;
    }
}
