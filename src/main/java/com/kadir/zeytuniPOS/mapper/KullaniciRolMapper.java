package com.kadir.zeytuniPOS.mapper;

import com.kadir.zeytuniPOS.data.KullaniciRol;
import com.kadir.zeytuniPOS.data.Kullanici;
import com.kadir.zeytuniPOS.data.Rol;
import com.kadir.zeytuniPOS.dto.KullaniciRolCreateDTO;
import com.kadir.zeytuniPOS.dto.KullaniciRolDTO;
import com.kadir.zeytuniPOS.dto.KullaniciRolUpdateDTO;

import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface KullaniciRolMapper {

    default KullaniciRolDTO toDTO(KullaniciRol entity) {
        if (entity == null)
            return null;

        KullaniciRolDTO dto = new KullaniciRolDTO();
        dto.setKullaniciRolId(entity.getKullaniciRolId());
        
        if (entity.getKullanici() != null) {
            dto.setKullaniciId(entity.getKullanici().getKullaniciId());
        }
        
        if (entity.getRol() != null) {
            dto.setRolId(entity.getRol().getRolId());
        }

        return dto;
    }

    default List<KullaniciRolDTO> toDTOList(List<KullaniciRol> entities) {
        return entities.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Mapping(target = "kullaniciRolId", ignore = true)
    @Mapping(source = "kullaniciId", target = "kullanici", qualifiedByName = "mapKullaniciFromId")
    @Mapping(source = "rolId", target = "rol", qualifiedByName = "mapRolFromId")
    KullaniciRol toEntity(KullaniciRolCreateDTO dto);

    @Mapping(source = "kullaniciId", target = "kullanici", qualifiedByName = "mapKullaniciFromId")
    @Mapping(source = "rolId", target = "rol", qualifiedByName = "mapRolFromId")
    KullaniciRol toEntity(KullaniciRolUpdateDTO dto);

    @Named("mapKullaniciFromId")
    static Kullanici mapKullaniciFromId(Integer id) {
        if (id == null)
            return null;
        Kullanici kullanici = new Kullanici();
        kullanici.setKullaniciId(id);
        return kullanici;
    }

    @Named("mapRolFromId")
    static Rol mapRolFromId(Integer id) {
        if (id == null)
            return null;
        Rol rol = new Rol();
        rol.setRolId(id);
        return rol;
    }
}
