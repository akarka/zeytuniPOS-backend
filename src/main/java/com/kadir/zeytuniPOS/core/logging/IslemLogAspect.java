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
            int hedefIdParametreIndeksi = logIslem.hedefIdParametreIndeksi();
            String hedefIdGetterMetodu = logIslem.hedefIdGetterMetodu();

            // Hedef ID'yi belirle
            Integer hedefId = null;
            Object[] args = joinPoint.getArgs();

            // CREATE işlemi için, dönen sonuçtan ID'yi al
            if (islemTuru.equals("CREATE") && result != null) {
                hedefId = extractIdFromObject(result, hedefTablo, hedefIdGetterMetodu);
            }
            // UPDATE işlemi için, parametre veya dönen sonuçtan ID'yi al
            else if (islemTuru.equals("UPDATE")) {
                // Önce parametreden ID'yi almaya çalış
                if (args != null && args.length > 0 && args[0] != null) {
                    hedefId = extractIdFromObject(args[0], hedefTablo, hedefIdGetterMetodu);
                }

                // Eğer parametreden ID alınamazsa, sonuçtan almaya çalış
                if (hedefId == null && result != null) {
                    hedefId = extractIdFromObject(result, hedefTablo, hedefIdGetterMetodu);
                }
            }
            // DELETE işlemi için, parametre indeksinden ID'yi al
            else if (islemTuru.equals("DELETE")) {
                if (args != null && args.length > 0) {
                    // Annotation'da belirtilen parametre indeksini kullan
                    if (hedefIdParametreIndeksi >= 0 && hedefIdParametreIndeksi < args.length) {
                        Object arg = args[hedefIdParametreIndeksi];
                        if (arg instanceof Integer) {
                            hedefId = (Integer) arg;
                        }
                    }
                    // İlk parametre Integer ise (deleteById gibi metodlar için)
                    else if (args[0] instanceof Integer) {
                        hedefId = (Integer) args[0];
                    }
                }
            }

            // Kullanıcı ID'sini belirle
            Integer kullaniciId = SecurityUtil.getCurrentUserId();
            if (kullaniciId == null) {
                kullaniciId = 2; // varsayılan admin ID
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

            // Loglama bilgisini konsola yaz (debug için)
            System.out.println("İşlem loglandı: " + islemTuru + " - " + hedefTablo + " - ID: " + hedefId);

        } catch (Exception e) {
            // Loglama sırasında hata oluşursa, uygulamanın çalışmasını etkilememesi için
            // hatayı yakala ve logla
            System.err.println("Loglama sırasında hata oluştu: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Bir nesneden ID değerini çıkarır
     * 
     * @param obj            ID'si çıkarılacak nesne
     * @param tableName      Tablo adı (getter metodu oluşturmak için kullanılır)
     * @param idGetterMethod Belirtilmişse, kullanılacak getter metodu
     * @return Çıkarılan ID değeri, bulunamazsa null
     */
    private Integer extractIdFromObject(Object obj, String tableName, String idGetterMethod) {
        if (obj == null)
            return null;

        try {
            Method getterMethod = null;

            // Belirtilen getter metodunu kullan
            if (idGetterMethod != null && !idGetterMethod.isEmpty()) {
                try {
                    getterMethod = obj.getClass().getMethod(idGetterMethod);
                } catch (NoSuchMethodException e) {
                    // Belirtilen metod bulunamadı, diğer yöntemleri dene
                }
            }

            // Tablo adına göre getter metodunu dene
            if (getterMethod == null) {
                String entityName = tableName.endsWith("s") ? tableName.substring(0, tableName.length() - 1)
                        : tableName;
                String getterName = "get" + entityName + "Id";

                try {
                    getterMethod = obj.getClass().getMethod(getterName);
                } catch (NoSuchMethodException e) {
                    // Tablo adına göre metod bulunamadı, diğer yöntemleri dene
                }
            }

            // Genel getId metodunu dene
            if (getterMethod == null) {
                try {
                    getterMethod = obj.getClass().getMethod("getId");
                } catch (NoSuchMethodException e) {
                    // getId metodu bulunamadı, son yöntemi dene
                }
            }

            // getUrunId metodunu dene
            if (getterMethod == null) {
                try {
                    getterMethod = obj.getClass().getMethod("getUrunId");
                } catch (NoSuchMethodException e) {
                    // getUrunId metodu bulunamadı, ID bulunamadı
                    return null;
                }
            }

            // Getter metodunu çağır ve ID'yi döndür
            if (getterMethod != null) {
                Object idObj = getterMethod.invoke(obj);
                if (idObj instanceof Integer) {
                    return (Integer) idObj;
                }
            }
        } catch (Exception e) {
            // ID getter metodu bulunamadı veya çağrılamadı
        }

        return null;
    }
}
