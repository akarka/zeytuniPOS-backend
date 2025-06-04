package com.kadir.zeytuniPOS.core;

import com.kadir.zeytuniPOS.core.logging.LogIslem;
import com.kadir.zeytuniPOS.data.Kullanici;
import com.kadir.zeytuniPOS.data.KullaniciRepository;
import com.kadir.zeytuniPOS.data.Rol;
import com.kadir.zeytuniPOS.dto.KullaniciCreateDTO;
import com.kadir.zeytuniPOS.dto.KullaniciDTO;
import com.kadir.zeytuniPOS.dto.KullaniciUpdateDTO;
import com.kadir.zeytuniPOS.dto.SifreGuncelleDTO;
import com.kadir.zeytuniPOS.mapper.KullaniciMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KullaniciService extends AbstractService<Kullanici, Integer> {

    private final KullaniciRepository kullaniciRepository;
    private final KullaniciMapper kullaniciMapper;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public KullaniciService(KullaniciRepository kullaniciRepository,
            KullaniciMapper kullaniciMapper,
            PasswordEncoder passwordEncoder) {
        super(kullaniciRepository);
        this.kullaniciRepository = kullaniciRepository;
        this.kullaniciMapper = kullaniciMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @LogIslem(islemTuru = "CREATE", hedefTablo = "Kullanicilar", aciklama = "Kullanıcı eklendi", hedefIdGetterMetodu = "getKullaniciId")
    public KullaniciDTO createFromDTO(KullaniciCreateDTO dto) {
        Kullanici entity = kullaniciMapper.toEntity(dto);
        entity.setSifreHash(passwordEncoder.encode(dto.getSifre()));
        Kullanici saved = kullaniciRepository.save(entity);
        return kullaniciMapper.toDTO(saved);
    }

    public List<KullaniciDTO> getAllKullanicilar() {
        return kullaniciMapper.toDTOList(kullaniciRepository.findAll());
    }

    public KullaniciDTO getKullaniciById(Integer id) {
        return kullaniciMapper.toDTO(getById(id));
    }

    public void guncelleSifre(SifreGuncelleDTO dto) {
        Kullanici kullanici = getById(dto.getKullaniciId());
        kullanici.setSifreHash(passwordEncoder.encode(dto.getYeniSifre()));
        kullaniciRepository.save(kullanici);
    }

    @LogIslem(islemTuru = "UPDATE", hedefTablo = "Kullanicilar", aciklama = "Kullanıcı güncellendi", hedefIdGetterMetodu = "getKullaniciId")
    public KullaniciDTO update(KullaniciUpdateDTO dto) {
        Kullanici entity = getById(dto.getKullaniciId());
        entity.setKullaniciAdi(dto.getKullaniciAdi());
        entity.setAktif(dto.getAktif());

        if (dto.getRolId() != null) {
            Rol rol = new Rol();
            rol.setRolId(dto.getRolId());
            entity.setRol(rol);
        }

        Kullanici updated = kullaniciRepository.save(entity);
        return kullaniciMapper.toDTO(updated);
    }

    @LogIslem(islemTuru = "DELETE", hedefTablo = "Kullanicilar", aciklama = "Kullanıcı silindi", hedefIdGetterMetodu = "getKullaniciId")
    public void delete(Integer id) {
        kullaniciRepository.deleteById(id);
    }
}
