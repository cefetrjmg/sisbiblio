/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetrj.mg.bsi.sisbiblio.repository;

import br.cefetrj.mg.bsi.sisbiblio.dao.ObraDAO;
import br.cefetrj.mg.bsi.sisbiblio.model.Obra;
import java.util.ArrayList;

/**
 *
 * @author cristian
 */
public class ObraRepository implements Respository<Obra>{

    private ObraDAO dao;
    public ObraRepository(){
        dao=new ObraDAO();
    }
    @Override
    public ArrayList<Obra> findByNameOrEmail( String name, String email) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Obra> findByName( String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Obra> findByEmail( String email) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Obra findById( int id) {
        for(Obra o: dao.listar()){
            if(o.getId() == id){
                return o;
            }
            
            
        }
        return null;
    }

    @Override
    public ArrayList<Obra> findByISBN( String isbn) {
        ArrayList<Obra> obras= new ArrayList<>();
        dao.listar().stream().filter((o) -> (o.getIsbn().contains(isbn))).forEachOrdered((o) -> {
            obras.add(o);
        });
        return obras;
    }

    @Override
    public ArrayList<Obra> findByTitulo( String titulo) {
        ArrayList<Obra> obras= new ArrayList<>();
        dao.listar().stream().filter((o) -> (o.getTitulo().toLowerCase().contains(titulo.toLowerCase()))).forEachOrdered((o) -> {
            obras.add(o);
        });
        return obras;
    }

    @Override
    public ArrayList<Obra> findByISBNOrTitulo(String isbn, String titulo) {
        ArrayList<Obra> obras=new ArrayList<>();
        dao.listar().stream().filter((obra) -> (obra.getIsbn().toLowerCase().contains(isbn.toLowerCase()) || obra.getTitulo().toLowerCase().contains(titulo.toLowerCase()))).forEachOrdered((obra) -> {
            obras.add(obra);
        });
        return obras;
    }
    
}
