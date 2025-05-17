package com.kadir.zeytuniPOS.core;

import com.kadir.zeytuniPOS.data.BaseRepository;

import jakarta.persistence.EntityNotFoundException;

import java.util.List;

public abstract class AbstractService<T, ID> implements BaseService<T, ID> {

    protected final BaseRepository<T, ID> repository;

    public AbstractService(BaseRepository<T, ID> repository) {
        this.repository = repository;
    }

    @Override
    public T create(T entity) {
        return repository.save(entity);
    }

    @Override
    public List<T> getAll() {
        return repository.findAll();
    }

    @Override
    public T update(ID id, T entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(ID id) {
        repository.deleteById(id);
    }

    public T getById(ID id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("ID bulunamadı: " + id));
    }
}