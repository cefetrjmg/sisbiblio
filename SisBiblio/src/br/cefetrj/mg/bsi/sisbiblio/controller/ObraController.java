/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetrj.mg.bsi.sisbiblio.controller;

import br.cefetrj.mg.bsi.sisbiblio.dao.ObraDAO;
import br.cefetrj.mg.bsi.sisbiblio.model.Obra;
import br.cefetrj.mg.bsi.sisbiblio.model.TableModel;
import br.cefetrj.mg.bsi.sisbiblio.reports.Report;
import br.cefetrj.mg.bsi.sisbiblio.view.Dashboard;
import br.cefetrj.mg.bsi.sisbiblio.repository.ObraRepository;
import java.util.ArrayList;

/**
 *
 * @author cristian
 */
public class ObraController implements Controller<Obra> {

    private final ObraRepository repository;
    private final ObraDAO dao;
    private Obra obra;
    private final Dashboard view;
    private int lastId = 0;

    /**
     * @author Cristian Madeira de Souza Pereira
     * @param view instância do formulário principal
     */
    public ObraController(Dashboard view) {
        this.view = view;
        dao = new ObraDAO();
        repository = new ObraRepository();
        lastId = dao.getLastId();

    }

    @Override
    public boolean inserir() {
        obra = new Obra();
        obra.setIsbn(view.getTxtISBN().getText());
        obra.setTitulo(view.getTxtTitulo().getText());
        obra.setId(++lastId);
        return dao.inserir(obra);

    }

    @Override
    public boolean atualizar() {
        obra =new Obra();
        obra.setIsbn(view.getTxtISBN().getText());
        obra.setTitulo(view.getTxtTitulo().getText());
        obra.setId(Integer.parseInt(view.getLblId().getText()));
        return dao.atualizar(obra);
    }

    @Override
    public boolean excluir() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public boolean excluir(int id){
        obra=new Obra();
        obra.setId(id);
        return dao.excluir(obra);
    }

    @Override
    public boolean buscar() {

        return false;
    }

    public boolean buscar(int id) {
        obra = repository.findById(id);
        if (obra != null) {
            view.getLblId().setText(String.valueOf(obra.getId()));
            view.getTxtISBN().setText(obra.getIsbn());
            view.getTxtTitulo().setText(obra.getTitulo());
            view.getBtnCadastrarAtualizar().setText("Atualizar");
            view.showFormObra();
            return true;
        } else {
            return false;
        }

    }

    @Override
    public boolean listar() {
        return false;
    }

    public void gerarRelatorioAutoresPorObras() {
        Report.authorsByBook(dao.listar());
    }

    @Override
    public void renderizar() {
        TableModel model = new TableModel(dao.listar(), null);
        view.getTable().setModel(model);

    }

    public void renderizar(ArrayList<Obra> obras) {
        view.getTable().setModel(new TableModel(obras, null));
    }

    public void findByISBNOrTitulo(String isbn, String titulo) {
        renderizar(repository.findByISBNOrTitulo(isbn, titulo));
    }

}
