/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetrj.mg.bsi.sisbiblio.model;

import java.util.ArrayList;


/**
 *
 * @author Maurício
 */
public class Obra implements Comparable<Obra>{
    private int id;
    private String isbn;
    private String titulo;
    
    @SuppressWarnings("serial")
    private ArrayList<Autor> autores =new ArrayList<>();
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public ArrayList<Autor> getAutores() {
        return autores;
    }

    public void setAutores(ArrayList<Autor> autores) {
        this.autores = autores;
    }

    @Override
    public String toString() {
        return "Obra{" + "id=" + id + ", isbn=" + isbn + ", titulo=" + titulo + ", autores=" + autores + '}';
    }

    @Override
    public int compareTo(Obra o) {
        if(this.getId() < o.getId())
            return -1;
        if(this.getId() > o.getId())
            return 1;
        return 0;
    }

   
    
    
    
}
