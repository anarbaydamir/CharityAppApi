package com.itway.charity.dao.inter;

import com.itway.charity.entity.Cities;

import java.util.List;

public interface CitiesDaoInter {
    List<Cities> getAll();

    Cities getById(int id);

    Integer insert(Cities cities);

    Boolean update(Cities cities);

    Boolean delete(int id);
}
