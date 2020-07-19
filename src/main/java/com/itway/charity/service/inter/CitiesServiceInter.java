package com.itway.charity.service.inter;

import com.itway.charity.entity.Cities;

import java.util.List;

public interface CitiesServiceInter {
    List<Cities> getAll();

    Cities getById(int id);

    Integer insert(Cities cities);

    Boolean update(Cities cities);

    Boolean delete(int id);
}
