package com.athomas5.javaspring.database.dao;

import java.util.List;

public interface DAO<T> {
    List<T> get(List<Long> ids);
    List<T> list();
    T create(T t);
    T update(T t);
    void delete(long id);
}
