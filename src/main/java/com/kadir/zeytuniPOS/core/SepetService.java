package com.kadir.zeytuniPOS.core;

import com.kadir.zeytuniPOS.data.Sepet;
import com.kadir.zeytuniPOS.data.SepetRepository;
import com.kadir.zeytuniPOS.data.Urun;
import com.kadir.zeytuniPOS.data.UrunRepository;
import com.kadir.zeytuniPOS.dto.SepetCreateDTO;
import com.kadir.zeytuniPOS.dto.SepetDTO;
import com.kadir.zeytuniPOS.dto.SepetUpdateDTO;
import com.kadir.zeytuniPOS.mapper.SepetMapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class SepetService extends AbstractService<Sepet, Integer> {

    private final SepetRepository sepetRepository;
    private final SepetMapper sepetMapper;
    private final UrunRepository urunRepository;

    public SepetService(SepetRepository sepetRepository, SepetMapper sepetMapper, UrunRepository urunRepository) {
        super(sepetRepository);
        this.sepetRepository = sepetRepository;
        this.sepetMapper = sepetMapper;
        this.urunRepository = urunRepository;
    }

    public List<SepetDTO> getAllDTO() {
        return sepetRepository.findAll().stream()
                .map(sepetMapper::toDto)
                .collect(Collectors.toList());
    }

    public SepetDTO createFromDTO(SepetCreateDTO dto) {
        Urun urun = urunRepository.findById(dto.getUrunId())
                .orElseThrow(() -> new RuntimeException("Ürün bulunamadı"));
        Sepet entity = sepetMapper.toEntity(dto, urun);
        return sepetMapper.toDto(sepetRepository.save(entity));
    }

    public SepetDTO update(SepetUpdateDTO dto) {
        Sepet entity = sepetRepository.findById(dto.getSepetId())
                .orElseThrow(() -> new RuntimeException("Sepet kaydı bulunamadı"));
        Urun urun = urunRepository.findById(dto.getUrunId())
                .orElseThrow(() -> new RuntimeException("Ürün bulunamadı"));
        sepetMapper.updateEntity(entity, dto, urun);
        return sepetMapper.toDto(sepetRepository.save(entity));
    }

    public void deleteById(Integer id) {
        sepetRepository.deleteById(id);
    }
}
