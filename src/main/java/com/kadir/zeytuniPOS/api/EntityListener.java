package com.kadir.zeytuniPOS.api;

import com.kadir.zeytuniPOS.core.IslemLogService;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import jakarta.persistence.*;

@Component
public class EntityListener {

    @Autowired
    private IslemLogService islemLogService;

    @PrePersist
    public void prePersist (Object entity){
        islemLogService.logger(entity, "CREATE");
    }

    @PreUpdate
    public void preUpdate(Object entity){
        islemLogService.logger(entity, "UPDATE");
    }

    @PreRemove
    public void preRemove(Object entity){
        islemLogService.logger(entity, "DELETE");
    }
}
