package com.kadir.zeytuniPOS.mapper;

import com.kadir.zeytuniPOS.data.SiparisKalemi;
import com.kadir.zeytuniPOS.data.Urun;
import com.kadir.zeytuniPOS.dto.SiparisKalemiCreateDTO;
import com.kadir.zeytuniPOS.dto.SiparisKalemiDTO;
import com.kadir.zeytuniPOS.dto.SiparisKalemiUpdateDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface SiparisKalemiMapper {

    SiparisKalemiMapper INSTANCE = Mappers.getMapper(SiparisKalemiMapper.class);

    @Mapping(source = "urun.urunAdi", target = "urunAdi")
    @Mapping(source = "urun.urunId", target = "urunId")
    @Mapping(source = "siparis.siparisId", target = "siparisId")
    SiparisKalemiDTO toDto(SiparisKalemi siparisKalemi);

    @Mapping(target = "siparisKalemId", ignore = true)
    @Mapping(target = "eklenmeTarihi", ignore = true)
    @Mapping(target = "siparis", ignore = true)
    @Mapping(source = "urunId", target = "urun", qualifiedByName = "mapUrunIdToUrun")
    SiparisKalemi toEntity(SiparisKalemiCreateDTO siparisKalemiCreateDTO);

    @Mapping(target = "eklenmeTarihi", ignore = true)
    @Mapping(target = "siparis", ignore = true)
    @Mapping(source = "urunId", target = "urun", qualifiedByName = "mapUrunIdToUrun")
    SiparisKalemi toEntity(SiparisKalemiUpdateDTO siparisKalemiUpdateDTO);

    @Named("mapUrunIdToUrun")
    default Urun mapUrunIdToUrun(Integer urunId) {
        if (urunId == null) {
            return null;
        }
        Urun urun = new Urun();
        urun.setUrunId(urunId);
        return urun;
    }
}


