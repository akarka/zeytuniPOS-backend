package com.kadir.zeytuniPOS.mapper;

import com.kadir.zeytuniPOS.data.AltKategori;
import com.kadir.zeytuniPOS.data.UrunKategorileri;
import com.kadir.zeytuniPOS.dto.AltKategoriDTO;
import com.kadir.zeytuniPOS.dto.AltKategoriCreateDTO;
import com.kadir.zeytuniPOS.dto.AltKategoriUpdateDTO;

import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface AltKategoriMapper {

    default AltKategoriDTO toDTO(AltKategori entity) {
        if (entity == null)
            return null;

        AltKategoriDTO dto = new AltKategoriDTO();
        dto.setAltkId(entity.getAltkId());
        dto.setAltkAdi(entity.getAltkAdi());

        if (entity.getUrunKategorileri() != null) {
            dto.setUrunKategoriId(entity.getUrunKategorileri().getUrunKategoriId());
        }

        return dto;
    }

    default List<AltKategoriDTO> toDTOList(List<AltKategori> entities) {
        return entities.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Mapping(target = "altkId", ignore = true)
    @Mapping(source = "urunKategoriId", target = "urunKategorileri", qualifiedByName = "mapKategoriFromId")
    AltKategori toEntity(AltKategoriCreateDTO dto);

    @Mapping(source = "urunKategoriId", target = "urunKategorileri", qualifiedByName = "mapKategoriFromId")
    AltKategori toEntity(AltKategoriUpdateDTO dto);

    @Named("mapKategoriFromId")
    static UrunKategorileri mapKategoriFromId(Integer id) {
        if (id == null)
            return null;
        UrunKategorileri k = new UrunKategorileri();
        k.setUrunKategoriId(id);
        return k;
    }
}
