package com.kadir.zeytuniPOS.mapper;

import com.kadir.zeytuniPOS.data.Satis;
import com.kadir.zeytuniPOS.dto.SatisUpdateDTO;
import com.kadir.zeytuniPOS.data.Urun;
import com.kadir.zeytuniPOS.dto.*;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SatisMapper {

    @Mapping(source = "urun.urunId", target = "urunId")
    SatisDTO toDTO(Satis satis);

    List<SatisDTO> toDTOList(List<Satis> satislar);

    @Mapping(target = "satisId", ignore = true)
    @Mapping(source = "urunId", target = "urun", qualifiedByName = "mapUrunFromId")
    Satis toEntity(SatisCreateDTO dto);

    @Mapping(source = "urunId", target = "urun", qualifiedByName = "mapUrunFromId")
    Satis toEntity(SatisUpdateDTO dto);

    @Named("mapUrunFromId")
    static Urun mapUrunFromId(Integer id) {
        if (id == null)
            return null;
        Urun u = new Urun();
        u.setUrunId(id);
        return u;
    }
}