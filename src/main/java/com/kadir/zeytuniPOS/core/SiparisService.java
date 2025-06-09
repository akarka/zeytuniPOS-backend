package com.kadir.zeytuniPOS.core;

import com.kadir.zeytuniPOS.data.Siparis;
import com.kadir.zeytuniPOS.data.SiparisKalemi;
import com.kadir.zeytuniPOS.dto.SiparisCreateDTO;
import com.kadir.zeytuniPOS.dto.SiparisDTO;
import com.kadir.zeytuniPOS.dto.SiparisKalemiCreateDTO;
import com.kadir.zeytuniPOS.dto.SatisCreateDTO;
import com.kadir.zeytuniPOS.mapper.SiparisMapper;
import com.kadir.zeytuniPOS.mapper.SiparisKalemiMapper;
import com.kadir.zeytuniPOS.data.SiparisRepository;
import com.kadir.zeytuniPOS.data.SiparisKalemiRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SiparisService {

    private final SiparisRepository siparisRepository;
    private final SiparisKalemiRepository siparisKalemiRepository;
    private final SiparisMapper siparisMapper;
    private final SiparisKalemiMapper siparisKalemiMapper;
    private final UrunService urunService; // UrunService enjekte edildi
    private final SatisService satisService; // SatisService enjekte edildi

    public SiparisService(SiparisRepository siparisRepository, SiparisKalemiRepository siparisKalemiRepository,
            SiparisMapper siparisMapper, SiparisKalemiMapper siparisKalemiMapper, UrunService urunService,
            SatisService satisService) {
        this.siparisRepository = siparisRepository;
        this.siparisKalemiRepository = siparisKalemiRepository;
        this.siparisMapper = siparisMapper;
        this.siparisKalemiMapper = siparisKalemiMapper;
        this.urunService = urunService;
        this.satisService = satisService;
    }

    public List<SiparisDTO> getAllSiparisDTOs() {
        return siparisRepository.findAll().stream()
                .map(siparisMapper::toDto)
                .collect(Collectors.toList());
    }

    public SiparisDTO getSiparisDTOById(Integer id) {
        return siparisRepository.findById(id)
                .map(siparisMapper::toDto)
                .orElse(null); // Or throw an exception
    }

    @Transactional
    public SiparisDTO createSiparisFromDTO(SiparisCreateDTO siparisCreateDTO) {
        Siparis siparis = siparisMapper.toEntity(siparisCreateDTO);
        siparis.setToplamFiyat(BigDecimal.ZERO);

        // Save Siparis first to get siparisId
        siparis = siparisRepository.save(siparis);

        BigDecimal totalOrderPrice = BigDecimal.ZERO;
        if (siparisCreateDTO.getSiparisKalemleri() != null) {
            for (SiparisKalemiCreateDTO kalemiDTO : siparisCreateDTO.getSiparisKalemleri()) {
                // Eğer satisFiyati belirtilmemişse, UrunService'den guncelSatisFiyati'ni çek
                if (kalemiDTO.getSatisFiyati() == null) {
                    kalemiDTO.setSatisFiyati(urunService.getByIdDTO(kalemiDTO.getUrunId()).getGuncelSatisFiyati());
                }

                SiparisKalemi siparisKalemi = siparisKalemiMapper.toEntity(kalemiDTO);
                siparisKalemi.setSiparis(siparis);
                siparisKalemiRepository.save(siparisKalemi);
                totalOrderPrice = totalOrderPrice
                        .add(siparisKalemi.getSatisFiyati().multiply(BigDecimal.valueOf(siparisKalemi.getMiktar())));

                // Sipariş onaylandığında Satis tablosuna kayıt at
                SatisCreateDTO satisCreateDTO = new SatisCreateDTO();
                satisCreateDTO.setUrunId(siparisKalemi.getUrun().getUrunId());
                satisCreateDTO.setMiktar(siparisKalemi.getMiktar());
                satisCreateDTO.setSatisFiyati(siparisKalemi.getSatisFiyati().longValue());
                satisCreateDTO.setSatisTarihi(LocalDateTime.now());
                satisService.createFromDTO(satisCreateDTO);
            }
        }
        siparis.setToplamFiyat(totalOrderPrice);
        siparisRepository.save(siparis); // Update total price

        return siparisMapper.toDto(siparis);
    }

    @Transactional
    public SiparisDTO updateSiparis(Integer siparisId, SiparisCreateDTO siparisUpdateDTO) {
        Siparis existingSiparis = siparisRepository.findById(siparisId)
                .orElseThrow(() -> new RuntimeException("Sipariş bulunamadı"));

        // Update main order details
        existingSiparis.setMusteriId(siparisUpdateDTO.getMusteriId());
        existingSiparis.setSiparisDurumu(siparisUpdateDTO.getSiparisDurumu());

        // Handle order items (SiparisKalemleri)
        // This is a simplified update. A more robust solution would handle additions,
        // deletions, and updates of individual items.
        // For now, we'll clear existing items and add new ones.
        siparisKalemiRepository.deleteAll(existingSiparis.getSiparisKalemleri());
        existingSiparis.getSiparisKalemleri().clear();

        BigDecimal totalOrderPrice = BigDecimal.ZERO;
        if (siparisUpdateDTO.getSiparisKalemleri() != null) {
            for (SiparisKalemiCreateDTO kalemiDTO : siparisUpdateDTO.getSiparisKalemleri()) {
                // Eğer satisFiyati belirtilmemişse, UrunService'den guncelSatisFiyati'ni çek
                if (kalemiDTO.getSatisFiyati() == null) {
                    kalemiDTO.setSatisFiyati(urunService.getByIdDTO(kalemiDTO.getUrunId()).getGuncelSatisFiyati());
                }

                SiparisKalemi siparisKalemi = siparisKalemiMapper.toEntity(kalemiDTO);
                siparisKalemi.setSiparis(existingSiparis);
                siparisKalemiRepository.save(siparisKalemi);
                existingSiparis.getSiparisKalemleri().add(siparisKalemi);
                totalOrderPrice = totalOrderPrice
                        .add(siparisKalemi.getSatisFiyati().multiply(BigDecimal.valueOf(siparisKalemi.getMiktar())));

                // Sipariş onaylandığında Satis tablosuna kayıt at (güncelleme senaryosunda da)
                SatisCreateDTO satisCreateDTO = new SatisCreateDTO();
                satisCreateDTO.setUrunId(siparisKalemi.getUrun().getUrunId());
                satisCreateDTO.setMiktar(siparisKalemi.getMiktar());
                satisCreateDTO.setSatisFiyati(siparisKalemi.getSatisFiyati().longValue());
                satisCreateDTO.setSatisTarihi(LocalDateTime.now());
                satisCreateDTO.setNotlar("Sipariş ID: " + existingSiparis.getSiparisId() + ", Kalem ID: "
                        + siparisKalemi.getSiparisKalemId() + " (Güncellendi)");
                satisService.createFromDTO(satisCreateDTO);
            }
        }
        existingSiparis.setToplamFiyat(totalOrderPrice);

        return siparisMapper.toDto(siparisRepository.save(existingSiparis));
    }

    public void deleteSiparisById(Integer id) {
        siparisRepository.deleteById(id);
    }
}
