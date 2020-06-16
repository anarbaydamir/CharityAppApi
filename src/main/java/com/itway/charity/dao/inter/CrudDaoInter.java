package com.itway.charity.dao.inter;

import java.util.List;

public interface CrudDaoInter<T> {

    public List<T> getAll();

    public T getById(int id);

    public Integer insert(T t);

    public Boolean update(T t);

    public Boolean delete(int id);
}
