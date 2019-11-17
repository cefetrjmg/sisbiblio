/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetrj.mg.bsi.sisbiblio.model;

import java.lang.reflect.Field;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author cristian
 */
public class TableModel extends AbstractTableModel {

    private ArrayList<Obra> obras = null;
    private ArrayList<Autor> autores = null;
    private ArrayList<String> colunas = new ArrayList<>();

    public TableModel(ArrayList<Obra> obras, ArrayList<Autor> autores) {
        this.obras = obras;
        this.autores = autores;
        init();
    }

    private void init() {
        colunas.clear();
        if (!obras.isEmpty()) {
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
        } else if (autores != null) {
            return autores.size();
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
        if (obras != null) {
            Obra obra = getObra(rowIndex);
            switch (columnIndex) {
                case 0:
                    return obra.getId();
                case 1:
                    return obra.getIsbn();
                case 2:
                    return obra.getTitulo();

            }
        }
        return null;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Obra getObra(int pos) {
        return obras.get(pos);
    }

    public Autor getAutor(int pos) {
        return autores.get(pos);
    }
    

}
