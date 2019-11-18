/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetrj.mg.bsi.sisbiblio.tablemodel;

import br.cefetrj.mg.bsi.sisbiblio.model.Autor;
import br.cefetrj.mg.bsi.sisbiblio.model.Obra;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author cristian
 */
public class ObraTableModel extends AbstractTableModel implements Serializable{

    private ArrayList<Obra> obras = null;
    private ArrayList<String> colunas = new ArrayList<>();

    public ObraTableModel(ArrayList<Obra> obras) {
        this.obras = obras;
        init();
    }

    public ObraTableModel() {
       
    }

    private void init() {
        colunas.clear();
        if (obras != null && !obras.isEmpty()) {
            Class<Obra> obra = Obra.class;
            for (Field atributo : obra.getDeclaredFields()) {
                if(!atributo.getName().equalsIgnoreCase("autores"))
                    colunas.add(atributo.getName());
            }
        }
    }

    @Override
    public int getRowCount() {
        if (obras != null) {
            return obras.size();
        }
        return 0;
    }

    @Override
    public int getColumnCount() {
        return colunas.size();
    }

    @Override
    public String getColumnName(int columnIndex) {
        return colunas.get(columnIndex);
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
        Obra obra = getObra(rowIndex);
        if (obras != null && !obras.isEmpty()) {
            
            switch (columnIndex) {
                case 0:
                    return obra.getId();
                case 1:
                    return obra.getIsbn();
                case 2:
                    return obra.getTitulo();

            }
        }
        return obra;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Obra getObra(int pos) {
        if(obras != null && !obras.isEmpty())
            return obras.get(pos);
        return null;
    }

    
    
    public void clear() {
        if(obras != null) obras.clear();
    }

}
