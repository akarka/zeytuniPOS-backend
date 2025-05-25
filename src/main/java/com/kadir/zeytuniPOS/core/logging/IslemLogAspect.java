package com.kadir.zeytuniPOS.core.logging;

import com.kadir.zeytuniPOS.data.IslemLog;
import com.kadir.zeytuniPOS.data.Kullanici;
import com.kadir.zeytuniPOS.data.IslemLogRepository;
import com.kadir.zeytuniPOS.core.SecurityUtil;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.time.LocalDateTime;

@Aspect
@Component
public class IslemLogAspect {

    private final IslemLogRepository islemLogRepository;

    @Autowired
    public IslemLogAspect(IslemLogRepository islemLogRepository) {
        this.islemLogRepository = islemLogRepository;
    }

    @AfterReturning(pointcut = "@annotation(com.kadir.zeytuniPOS.core.logging.LogIslem)", returning = "result")
    public void logAfterMethodExecution(JoinPoint joinPoint, Object result) {
        try {
            // Metod bilgilerini al
            MethodSignature signature = (MethodSignature) joinPoint.getSignature();
            Method method = signature.getMethod();

            // Annotation'dan bilgileri al
            LogIslem logIslem = method.getAnnotation(LogIslem.class);
            String islemTuru = logIslem.islemTuru();
            String hedefTablo = logIslem.hedefTablo();
            String aciklama = logIslem.aciklama();

            // Hedef ID'yi belirle (result objesi üzerinden)
            Integer hedefId = null;
            if (result != null) {
                try {
                    // Entity'nin ID'sini reflection ile al
                    if (result.getClass().getSimpleName().endsWith("DTO")) {
                        // DTO sınıflarından ID'yi al
                        String idFieldName = hedefTablo.substring(0, hedefTablo.length() - 1) + "Id";
                        Method getIdMethod = result.getClass().getMethod(
                                "get" + idFieldName.substring(0, 1).toUpperCase() + idFieldName.substring(1));
                        hedefId = (Integer) getIdMethod.invoke(result);
                    }
                } catch (Exception e) {
                    // ID metodu bulunamadıysa veya çağrılamazsa
                    // Metod parametrelerinden ID'yi bulmaya çalış
                    Object[] args = joinPoint.getArgs();
                    if (args != null && args.length > 0 && args[0] instanceof Integer) {
                        hedefId = (Integer) args[0];
                    }
                }
            }

            // Kullanıcı ID'sini belirle (şimdilik manuel)
            Integer kullaniciId = SecurityUtil.getCurrentUserId();

            // Açıklamayı zenginleştir
            if (result != null && result.toString().length() < 100) {
                aciklama += ": " + result.toString();
            }

            // Log kaydını oluştur
            IslemLog islemLog = new IslemLog();

            // Kullanici nesnesini oluştur
            Kullanici kullanici = new Kullanici();
            kullanici.setKullaniciId(kullaniciId);
            islemLog.setKullanici(kullanici);

            islemLog.setTarih(LocalDateTime.now());
            islemLog.setIslemTuru(islemTuru);
            islemLog.setHedefTablo(hedefTablo);
            islemLog.setHedefId(hedefId);
            islemLog.setAciklama(aciklama);

            // Log kaydını kaydet
            islemLogRepository.save(islemLog);

        } catch (Exception e) {
            // Loglama sırasında hata oluşursa, uygulamanın çalışmasını etkilememesi için
            // hatayı yakala ve logla
            System.err.println("Loglama sırasında hata oluştu: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
