/*
 * DataAccessInterface.java:
 * Developer: Nathan Meyer
 * 
 * Description: This interface specifies the methods that implementing classes must have to be a data service.
 */

package com.milestone.gcu.data;

import java.util.List;

public interface DataAccessInterface <T> {
    public List<T> findAll();
    public T findById(Long id);
    public T create(T t);
    public T update(T t, Long id);
    public boolean delete(Long id);
}
