package com.kadir.zeytuniPOS.api;

import com.kadir.zeytuniPOS.core.EnvanterService;
import com.kadir.zeytuniPOS.data.Tedarikci;
import com.kadir.zeytuniPOS.data.TedarikciRepository;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/envanter")
public class EnvanterController {

    private final EnvanterService envanterService;
    private final TedarikciRepository tedarikciRepository;

    public EnvanterController(EnvanterService envanterService, TedarikciRepository tedarikciRepository) {
        this.envanterService = envanterService;
        this.tedarikciRepository = tedarikciRepository;
    }

    @PostMapping("/giris")
    public String stokGir(
            @RequestParam Integer urunId,
            @RequestParam Integer miktar,
            @RequestParam Integer tedarikciId) {

        Tedarikci tedarikci = tedarikciRepository.findById(tedarikciId)
                .orElseThrow(() -> new RuntimeException("Tedarikçi bulunamadı"));

        envanterService.stokGir(urunId, miktar, tedarikci);
        return "Stok girişi başarılı.";
    }

    @PostMapping("/cikis")
    public String stokCik(@RequestParam Integer urunId, @RequestParam Integer miktar,
            @RequestParam Tedarikci tedarikci) {
        try {
            envanterService.stokCik(urunId, miktar, tedarikci);
            return "Stok çıkışı başarılı.";
        } catch (RuntimeException e) {
            return "Hata: " + e.getMessage();
        }
    }

    @GetMapping("/stok/{urunId}/{tedarikciId}")
    public double stokSorgula(@PathVariable Integer urunId, @PathVariable Integer tedarikciId) {
        Tedarikci tedarikci = tedarikciRepository.findById(tedarikciId)
                .orElseThrow(() -> new RuntimeException("Tedarikçi bulunamadı"));

        return envanterService.stokSorgula(urunId, tedarikci);
    }

}
