package com.kadir.zeytuniPOS.api;

import com.kadir.zeytuniPOS.data.Kullanici;
import com.kadir.zeytuniPOS.dto.LoginRequestDTO;
import com.kadir.zeytuniPOS.dto.LoginResponseDTO;
import com.kadir.zeytuniPOS.data.KullaniciRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class LoginController {

    @Autowired
    private KullaniciRepository kullaniciRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDTO request) {
        Kullanici kullanici = kullaniciRepository.findByKullaniciAdi(request.getKullaniciAdi());
        if (kullanici == null || !passwordEncoder.matches(request.getSifre(), kullanici.getSifreHash())) {
            return ResponseEntity.status(401).body("Geçersiz kullanıcı adı veya şifre");
        }

        return ResponseEntity.ok(new LoginResponseDTO(
                kullanici.getKullaniciId(),
                kullanici.getKullaniciAdi(),
                kullanici.getRol().getRolAdi()));
    }
}
