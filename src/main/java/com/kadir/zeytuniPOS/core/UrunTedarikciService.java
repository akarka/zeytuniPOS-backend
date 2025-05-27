package com.kadir.zeytuniPOS.core;

import com.kadir.zeytuniPOS.core.logging.LogIslem;
import com.kadir.zeytuniPOS.data.UrunTedarikci;
import com.kadir.zeytuniPOS.data.UrunTedarikciRepository;
import com.kadir.zeytuniPOS.dto.UrunTedarikciCreateDTO;
import com.kadir.zeytuniPOS.dto.UrunTedarikciDTO;
import com.kadir.zeytuniPOS.dto.UrunTedarikciUpdateDTO;
import com.kadir.zeytuniPOS.mapper.UrunTedarikciMapper;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UrunTedarikciService extends AbstractService<UrunTedarikci, Integer> {

    private final UrunTedarikciRepository urunTedarikciRepository;
    private final UrunTedarikciMapper urunTedarikciMapper;

    public UrunTedarikciService(UrunTedarikciRepository urunTedarikciRepository,
            UrunTedarikciMapper urunTedarikciMapper) {
        super(urunTedarikciRepository);
        this.urunTedarikciRepository = urunTedarikciRepository;
        this.urunTedarikciMapper = urunTedarikciMapper;
    }

    @LogIslem(islemTuru = "CREATE", hedefTablo = "Ürün Tedarikçi", aciklama = "Ürün tedarikçi ilişkisi eklendi", hedefIdGetterMetodu = "getUrunTedarikciId")
    public UrunTedarikciDTO createUrunTedarikci(UrunTedarikciCreateDTO createDTO) {
        UrunTedarikci entity = urunTedarikciMapper.toEntity(createDTO);
        UrunTedarikci savedEntity = urunTedarikciRepository.save(entity);
        return urunTedarikciMapper.toDTO(savedEntity);
    }

    public List<UrunTedarikciDTO> getAllUrunTedarikciler() {
        List<UrunTedarikci> entities = urunTedarikciRepository.findAll();
        return urunTedarikciMapper.toDTOList(entities);
    }

    public UrunTedarikciDTO getUrunTedarikciById(Integer id) {
        UrunTedarikci entity = getById(id);
        return urunTedarikciMapper.toDTO(entity);
    }

    @LogIslem(islemTuru = "UPDATE", hedefTablo = "Ürün Tedarikçi", aciklama = "Ürün tedarikçi ilişkisi güncellendi", hedefIdGetterMetodu = "getUrunTedarikciId")
    public UrunTedarikciDTO updateUrunTedarikci(Integer id, UrunTedarikciUpdateDTO updateDTO) {
        getById(id);

        UrunTedarikci entity = urunTedarikciMapper.toEntity(updateDTO);
        UrunTedarikci updatedEntity = urunTedarikciRepository.save(entity);
        return urunTedarikciMapper.toDTO(updatedEntity);
    }

    @LogIslem(islemTuru = "DELETE", hedefTablo = "Ürün Tedarikçi", aciklama = "Ürün tedarikçi ilişkisi silindi", hedefIdGetterMetodu = "getUrunTedarikciId")
    public void deleteUrunTedarikci(Integer id) {
        urunTedarikciRepository.deleteById(id);
    }
}
