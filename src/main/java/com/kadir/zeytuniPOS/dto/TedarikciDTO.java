package com.kadir.zeytuniPOS.dto;

public class TedarikciDTO {
    private Integer tedarikciId;
    private String tedarikciAdi;
    private String tedarikciIletisim;
    private String tedarikciAdres;

    public Integer getTedarikciId() {
        return tedarikciId;
    }

    public void setTedarikciId(Integer tedarikciId) {
        this.tedarikciId = tedarikciId;
    }

    public String getTedarikciAdi() {
        return tedarikciAdi;
    }

    public void setTedarikciAdi(String tedarikciAdi) {
        this.tedarikciAdi = tedarikciAdi;
    }

    public String getTedarikciIletisim() {
        return tedarikciIletisim;
    }

    public void setTedarikciIletisim(String tedarikciIletisim) {
        this.tedarikciIletisim = tedarikciIletisim;
    }

    public String getTedarikciAdres() {
        return tedarikciAdres;
    }

    public void setTedarikciAdres(String tedarikciAdres) {
        this.tedarikciAdres = tedarikciAdres;
    }
}
