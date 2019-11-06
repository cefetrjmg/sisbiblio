/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetrj.mg.bsi.sisbiblio.controller;

import br.cefetrj.mg.bsi.sisbiblio.dao.ObraDAO;
import br.cefetrj.mg.bsi.sisbiblio.model.Obra;
import br.cefetrj.mg.bsi.sisbiblio.view.Dashboard;

/**
 *
 * @author cristian
 */
public class ObraController implements Controller{
    
    private final ObraDAO dao;
    private Obra obra;
    private final Dashboard view;
    private int lastId=0;
    public ObraController(Dashboard view){
        this.view=view;
        dao =new ObraDAO();
        lastId=dao.getLastId();
        
    }
    @Override
    public boolean inserir() {
        obra=new Obra();
        obra.setIsbn(view.getTxtISBN().getText());
        obra.setTitulo(view.getTxtTitulo().getText());
        obra.setId(++lastId);
        return dao.inserir(dao);
        
    }

    @Override
    public boolean atualizar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean excluir() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object buscar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean getObrasByTituloOrISBN() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
