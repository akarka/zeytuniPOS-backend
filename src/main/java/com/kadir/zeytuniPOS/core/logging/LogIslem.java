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
}