/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetrj.mg.bsi.sisbiblio.dao;

import java.util.ArrayList;

/**
 *
 * @author cristian
 */
public  interface  DAO {
    public  boolean inserir(Object o);
    public boolean atualizar(Object o);
    public boolean excluir(Object o);
    public Object buscar(Object o);
    public ArrayList<?> listar();
    //public boolean criarOuAtualizarArquivo(Object o);
    public int getPos(Object o);
    
    
}
