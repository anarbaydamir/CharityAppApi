/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itway.charity.service.inter;

import java.util.List;

/**
 *
 * @author anarbaydamirov
 */
public interface CrudServiceInter<T> {
    
    public List<T> getAll();

    public T getById(int id);

    public Integer insert(T t);

    public Boolean update(T t);

    public Boolean delete(int id);
}
