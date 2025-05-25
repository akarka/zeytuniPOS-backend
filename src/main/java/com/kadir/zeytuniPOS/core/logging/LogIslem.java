package com.kadir.zeytuniPOS.core.logging;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface LogIslem {

    String islemTuru() default "BILINMEYEN";

    String hedefTablo() default "";

    String aciklama() default "";

    /**
     * Hedef ID'nin metod parametrelerindeki indeksi
     * Örneğin: deleteById(Integer id) metodu için 0
     * Eğer -1 ise, aspect otomatik olarak ID'yi bulmaya çalışır
     */
    int hedefIdParametreIndeksi() default -1;

    /**
     * Hedef ID'nin DTO içindeki getter metod adı
     * Örneğin: "getUrunId"
     * Eğer boş ise, aspect otomatik olarak ID'yi bulmaya çalışır
     */
    String hedefIdGetterMetodu() default "";
}
