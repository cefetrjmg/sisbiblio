/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetrj.mg.bsi.sisbiblio.repository;

import java.util.ArrayList;

/**
 *
 * @author cristian
 * @param <T>
 */
public interface Respository<T> {
    
    public ArrayList<T> findByNameOrEmail(String name, String email);
    public ArrayList<T> findByName(String name);
    public ArrayList<T> findByEmail(String email);
    public T findById(int id);
    public ArrayList<T> findByISBN(String isbn);
    public ArrayList<T> findByTitulo(String titulo);
    public ArrayList<T> findByISBNOrTitulo(String isbn, String titulo);
    
}
