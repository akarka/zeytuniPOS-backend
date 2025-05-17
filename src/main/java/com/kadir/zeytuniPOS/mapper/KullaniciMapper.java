package com.kadir.zeytuniPOS.mapper;

import com.kadir.zeytuniPOS.data.Kullanici;
import com.kadir.zeytuniPOS.dto.KullaniciDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring") // ✔️ BU SATIR ZORUNLU
public interface KullaniciMapper {

    @Mapping(source = "rol.rolAdi", target = "rol")
    KullaniciDTO toDTO(Kullanici kullanici);

    List<KullaniciDTO> toDTOList(List<Kullanici> kullanicilar);
}