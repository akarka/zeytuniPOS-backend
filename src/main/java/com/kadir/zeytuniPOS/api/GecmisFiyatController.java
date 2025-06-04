package com.kadir.zeytuniPOS.api;

import com.kadir.zeytuniPOS.core.GecmisFiyatService;
import com.kadir.zeytuniPOS.core.security.SecurityUtil;
import com.kadir.zeytuniPOS.data.GecmisFiyat;
import com.kadir.zeytuniPOS.dto.GecmisFiyatCreateDTO;
import com.kadir.zeytuniPOS.dto.GecmisFiyatDTO;
import com.kadir.zeytuniPOS.dto.GecmisFiyatUpdateDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/gecmisfiyat")
public class GecmisFiyatController extends BaseController<GecmisFiyat, Integer> {

    private final GecmisFiyatService gecmisFiyatService;

    @Autowired
    public GecmisFiyatController(GecmisFiyatService gecmisFiyatService) {
        super(gecmisFiyatService);
        this.gecmisFiyatService = gecmisFiyatService;
    }

    @GetMapping("/dto")
    public List<GecmisFiyatDTO> getAllGecmisFiyatlar() {
        try {
            return gecmisFiyatService.getAllGecmisFiyatlar();
        } finally {
            SecurityUtil.clear();
        }
    }

    @GetMapping("/dto/{id}")
    public GecmisFiyatDTO getGecmisFiyatById(@PathVariable Integer id) {
        SecurityUtil.setCurrentUserId(2); // İleride oturumdan alınacak
        try {
            return gecmisFiyatService.getGecmisFiyatById(id);
        } finally {
            SecurityUtil.clear();
        }
    }

    @GetMapping("/dto/urun/{urunId}")
    public List<GecmisFiyatDTO> getUrunDetayi(@PathVariable("urunId") Integer urunId) {
        SecurityUtil.setCurrentUserId(2); // İleride oturumdan alınacak
        try {
            return gecmisFiyatService.getUrunDetayi(urunId);
        } finally {
            SecurityUtil.clear();
        }
    }

    @PostMapping("/dto")
    public GecmisFiyatDTO create(@RequestBody GecmisFiyatCreateDTO createDTO) {
        SecurityUtil.setCurrentUserId(2); // İleride oturumdan alınacak
        try {
            return gecmisFiyatService.createGecmisFiyat(createDTO);
        } finally {
            SecurityUtil.clear();
        }
    }

    @PutMapping("/dto")
    public GecmisFiyatDTO update(@RequestBody GecmisFiyatUpdateDTO updateDTO) {
        SecurityUtil.setCurrentUserId(2); // İleride oturumdan alınacak
        try {
            return gecmisFiyatService.updateGecmisFiyat(updateDTO.getGecmisFiyatId(), updateDTO);
        } finally {
            SecurityUtil.clear();
        }
    }

}
