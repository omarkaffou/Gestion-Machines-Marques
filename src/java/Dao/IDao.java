/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;
import java.util.List;

/**
 *
 * @author omarc
 * @param <T>
 */
public interface  IDao<T> {
     boolean create(T o);
     boolean update(T o);
     boolean Delete(T o);
     T findById(int i);
     List<T> findAll();
}
