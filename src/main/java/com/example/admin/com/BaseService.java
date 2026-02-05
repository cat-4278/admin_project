package com.example.admin.com;

import org.springframework.data.jpa.repository.JpaRepository;

public abstract class BaseService<T, ID> {
    
    protected JpaRepository<T, ID> repository;
    
    // 생성자 - Repository를 받음
    public BaseService(JpaRepository<T, ID> repository) {
        this.repository = repository;
    }
    
    public T save(T entity) {
        return repository.save(entity);
    }
    
    public T findById(ID id) {
        return repository.findById(id).orElse(null);
    }
    
    public void delete(ID id) {
        repository.deleteById(id);
    }
}