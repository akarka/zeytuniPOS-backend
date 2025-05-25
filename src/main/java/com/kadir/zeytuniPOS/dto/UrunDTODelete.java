package com.kadir.zeytuniPOS.dto;

public class UrunDTODelete {

    private Integer urunId;
    private String silmeNedeni;
    private Boolean iliskiliKayitlariSil;
    private String onayKodu;

    public UrunDTODelete() {
    }

    public Integer getUrunId() {
        return urunId;
    }

    public void setUrunId(Integer urunId) {
        this.urunId = urunId;
    }

    public String getSilmeNedeni() {
        return silmeNedeni;
    }

    public void setSilmeNedeni(String silmeNedeni) {
        this.silmeNedeni = silmeNedeni;
    }

    public Boolean getIliskiliKayitlariSil() {
        return iliskiliKayitlariSil;
    }

    public void setIliskiliKayitlariSil(Boolean iliskiliKayitlariSil) {
        this.iliskiliKayitlariSil = iliskiliKayitlariSil;
    }

    public String getOnayKodu() {
        return onayKodu;
    }

    public void setOnayKodu(String onayKodu) {
        this.onayKodu = onayKodu;
    }
}
