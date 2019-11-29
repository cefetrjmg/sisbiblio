/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetrj.mg.bsi.sisbiblio.tablemodel;

import br.cefetrj.mg.bsi.sisbiblio.model.Autor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author cristian
 */
public class AutorTableModel extends AbstractTableModel {

    private ArrayList<Autor> autores = null;
    private ArrayList<String> colunas = new ArrayList<>();

    public AutorTableModel(ArrayList<Autor> autores) {
        this.autores = autores;
        init();
    }

    private void init() {
        Class<Autor> autor = Autor.class;
        for (Field atributo : autor.getDeclaredFields()) {
            if (!atributo.getName().equalsIgnoreCase("obras")) {
                colunas.add(atributo.getName());
            }
        }

    }

    @Override
    public int getRowCount() {
        return autores.size();
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }
    
    @Override
    public int getColumnCount() {
        return colunas.size();
    }

    @Override
    public String getColumnName(int column) {
        return colunas.get(column);
    }
    

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Autor autor=getAutor(rowIndex);
        if(autor != null){
            switch(columnIndex){
                case 0: return autor.getId();
                case 1: return autor.getNome();
                case 2: return autor.getEmail();
            }
        }
        return null;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Autor a=getAutor(rowIndex);
        switch(columnIndex){
            case 0:
                a.setId(Integer.parseInt(aValue.toString()));
                break;
            case 1 :
                a.setNome(aValue.toString());
                break;
            case 2:
                a.setEmail(aValue.toString());
                break;
                
        }
    }
    
    public Autor getAutor(int pos) {
        if(autores != null && !autores.isEmpty())
            return autores.get(pos);
        return null;
    }
    public void clear(){
        if(autores != null) autores.clear();
    }

}
