package com.kadir.zeytuniPOS.core;

import java.util.List;

public interface BaseService<T, ID> {
    
    T create(T entity);

    List<T> getAll();
    
    T update(ID id, T entity);

    void delete (ID id);

}
