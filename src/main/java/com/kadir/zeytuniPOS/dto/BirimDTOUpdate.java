package com.kadir.zeytuniPOS.dto;

import jakarta.validation.constraints.*;

public class BirimDTOUpdate {
    @NotBlank(message = "Birim adı boş olamaz")
    @Size(max = 30, message = "Birim adı en fazla 30 karakter olabilir")
    private Integer birimId;
    private String birimAdi;

    public Integer getBirimId() {
        return birimId;
    }

    public void setBirimId(Integer birimId) {
        this.birimId = birimId;
    }

    public String getBirimAdi() {
        return birimAdi;
    }

    public void setBirimAdi(String birimAdi) {
        this.birimAdi = birimAdi;
    }
}
