package br.cefetrj.mg.bsi.sisbiblio.repository;

import br.cefetrj.mg.bsi.sisbiblio.dao.AutorDAO;
import br.cefetrj.mg.bsi.sisbiblio.model.Autor;
import java.util.ArrayList;

public class AutorRepository implements Respository<Autor> {

    private AutorDAO dao;
    
    public AutorRepository(){
        dao = new AutorDAO();
    }
    
    @Override
    public ArrayList<Autor> findByNameOrEmail(String name, String email) {
        ArrayList<Autor> autores = new ArrayList<>();
        dao.listar().stream().filter((autor) -> (autor.getNome().toLowerCase().contains(name.toLowerCase()) || autor.getEmail().toLowerCase().contains(email.toLowerCase()))).forEachOrdered((autor) -> {
            autores.add(autor);
        });
        
        return autores;
    }

    @Override
    public ArrayList<Autor> findByName(String name) {
        ArrayList<Autor> autores = new ArrayList<>();
        dao.listar().stream().filter((o) -> (o.getNome().toLowerCase().contains(name.toLowerCase()))).forEachOrdered((o) -> {
            autores.add(o);
        });
        
        return autores;
    }

    @Override
    public ArrayList<Autor> findByEmail(String email) {
        ArrayList<Autor> autores = new ArrayList<>();
        dao.listar().stream().filter((o) -> (o.getEmail().toLowerCase().contains(email.toLowerCase()))).forEachOrdered((o) -> {
            autores.add(o);
        });
        
        return autores;
    }

    @Override
    public Autor findById(int id) {
        for(Autor o: dao.listar()){
            if(o.getId() == id){
                return o;
            }


        }
        
        return null;    
    }

    @Override
    public ArrayList<Autor> findByISBN(String isbn) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Autor> findByTitulo(String titulo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Autor> findByISBNOrTitulo(String isbn, String titulo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
