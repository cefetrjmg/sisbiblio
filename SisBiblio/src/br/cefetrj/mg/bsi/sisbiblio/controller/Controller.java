/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetrj.mg.bsi.sisbiblio.controller;

import java.util.ArrayList;
import javax.swing.JTable;

/**
 *
 * @author cristian
 */
public interface Controller<T> {
    public  boolean inserir();
    public boolean atualizar();
    public boolean excluir();
    public boolean buscar();
    public boolean listar();
    public void renderizar(JTable table, Object model);
    public void renderizar(ArrayList<T> list);
    public void renderizar(JTable table, ArrayList<? extends Object> list);
    
    
}
