package com.kadir.zeytuniPOS.core;

/*
 * Güvenlik işlemleri için yardımcı sınıf
 */
public class SecurityUtil {

    private static ThreadLocal<Integer> currentUserId = new ThreadLocal<>();

    /**
     * Mevcut kullanıcı ID'sini ayarlar
     * 
     * @param userId Kullanıcı ID'si
     */
    public static void setCurrentUserId(Integer userId) {
        currentUserId.set(userId);
    }

    /**
     * Mevcut kullanıcı ID'sini döndürür
     * 
     * @return Kullanıcı ID'si, yoksa varsayılan olarak 1
     */
    public static Integer getCurrentUserId() {
        return currentUserId.get() != null ? currentUserId.get() : 2; // Varsayılan olarak 1
    }

    /**
     * ThreadLocal'ı temizler
     */
    public static void clear() {
        currentUserId.remove();
    }
}
