package com.kadir.zeytuniPOS.mapper;

import com.kadir.zeytuniPOS.data.Sepet;
import com.kadir.zeytuniPOS.data.Urun;
import com.kadir.zeytuniPOS.dto.SepetCreateDTO;
import com.kadir.zeytuniPOS.dto.SepetDTO;
import com.kadir.zeytuniPOS.dto.SepetUpdateDTO;

import org.springframework.stereotype.*;

@Component
public class SepetMapper {

    public SepetDTO toDto(Sepet entity) {
        SepetDTO dto = new SepetDTO();
        dto.setSepetId(entity.getSepetId());
        dto.setUrunId(entity.getUrun().getUrunId());
        dto.setUrunAdi(entity.getUrun().getUrunAdi()); // DTO'da var
        dto.setMiktar(entity.getMiktar());
        dto.setSatisFiyati(entity.getSatisFiyati());
        dto.setEklenmeTarihi(entity.getEklenmeTarihi());
        return dto;
    }

    public Sepet toEntity(SepetCreateDTO dto, Urun urun) {
        Sepet entity = new Sepet();
        entity.setUrun(urun);
        entity.setMiktar(dto.getMiktar());
        entity.setSatisFiyati(dto.getSatisFiyati());
        entity.setEklenmeTarihi(dto.getEklenmeTarihi());
        return entity;
    }

    public void updateEntity(Sepet entity, SepetUpdateDTO dto, Urun urun) {
        entity.setUrun(urun);
        entity.setMiktar(dto.getMiktar());
        entity.setSatisFiyati(dto.getSatisFiyati());
        entity.setEklenmeTarihi(dto.getEklenmeTarihi());
    }
}