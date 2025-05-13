package com.kadir.zeytuniPOS.api;

import org.springframework.web.bind.annotation.*;

import com.kadir.zeytuniPOS.core.IslemLogService;
import com.kadir.zeytuniPOS.data.Tedarikci;
import com.kadir.zeytuniPOS.core.TedarikciService;

@RestController
@RequestMapping("/api/tedarikciler")
public class TedarikciController extends BaseController<Tedarikci, Integer> {

    public IslemLogService islemLogService;
    public TedarikciService tedarikciService;

    public TedarikciController(TedarikciService tedarikciService, IslemLogService islemLogService) {
        super(tedarikciService);
        this.tedarikciService = tedarikciService;
        this.islemLogService = islemLogService;
    }

    @Override
    @PostMapping
    public Tedarikci create(@RequestBody Tedarikci tedarik) {
        Tedarikci kayit = service.create(tedarik);
        islemLogService.logger(1, kayit, "CREATE"); // loglama - sabit kullanıcı

        return kayit;
    }

    @Override
    @PutMapping("/{id}")
    public Tedarikci update(@PathVariable Integer id, @RequestBody Tedarikci tedarikci) {
        Tedarikci guncellenmis = service.update(id, tedarikci);
        islemLogService.logger(1, guncellenmis, "UPDATE"); // loglama - sabit kullanıcı
        return guncellenmis;
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        Tedarikci silinmis = tedarikciService.getById(id);
        service.delete(id);
        islemLogService.logger(1, silinmis, "DELETE"); // loglama - sabit kullanıcı
    }
}
