/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.abbasadel.smava.core;

import java.util.List;


/**
 *
 * @author abbasadel
 * @param <T> Type of the model
 */
public interface RESTService<T> {	
    
    List<T> get();
    T get(long id);
    T post(T t);
    T put(T t);
    boolean delete(long id);
    
}
