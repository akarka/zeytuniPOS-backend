package com.kadir.zeytuniPOS.mapper;

import com.kadir.zeytuniPOS.data.*;
import com.kadir.zeytuniPOS.dto.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import java.util.List;

@Mapper(componentModel = "spring")
public interface UrunMapper {
    @Mapping(source = "birim.birimId", target = "birimId")
    @Mapping(source = "birim.birimAdi", target = "birimAdi")
    @Mapping(source = "altKategori.altkId", target = "altKategoriId")
    @Mapping(source = "altKategori.altkAdi", target = "altKategoriAdi")
    @Mapping(source = "guncelSatisFiyati", target = "guncelSatisFiyati")
    UrunDTO toDTO(Urun urun);

    List<UrunDTO> toDTOList(List<Urun> urunler);

    @Mapping(target = "urunId", ignore = true)
    @Mapping(source = "birimId", target = "birim", qualifiedByName = "mapBirimFromId")
    @Mapping(source = "altKategoriId", target = "altKategori", qualifiedByName = "mapAltKategoriFromId")
    @Mapping(source = "guncelSatisFiyati", target = "guncelSatisFiyati")
    Urun toEntity(UrunDTOCreate dto);

    @Mapping(source = "birimId", target = "birim", qualifiedByName = "mapBirimFromId")
    @Mapping(source = "altKategoriId", target = "altKategori", qualifiedByName = "mapAltKategoriFromId")
    @Mapping(source = "guncelSatisFiyati", target = "guncelSatisFiyati")
    Urun toEntity(UrunDTOUpdate dto);

    @Named("mapBirimFromId")
    static Birim mapBirimFromId(Integer id) {
        if (id == null)
            return null;
        Birim b = new Birim();
        b.setBirimId(id);
        return b;
    }

    @Named("mapAltKategoriFromId")
    static AltKategori mapAltKategoriFromId(Integer id) {
        if (id == null)
            return null;
        AltKategori ak = new AltKategori();
        ak.setAltkId(id);
        return ak;
    }
}
