/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetrj.mg.bsi.sisbiblio.controller;

import br.cefetrj.mg.bsi.sisbiblio.dao.ObraDAO;
import br.cefetrj.mg.bsi.sisbiblio.model.Autor;
import br.cefetrj.mg.bsi.sisbiblio.model.Obra;
import br.cefetrj.mg.bsi.sisbiblio.tablemodel.ObraTableModel;
import br.cefetrj.mg.bsi.sisbiblio.reports.Report;
import br.cefetrj.mg.bsi.sisbiblio.view.Dashboard;
import br.cefetrj.mg.bsi.sisbiblio.repository.ObraRepository;
import br.cefetrj.mg.bsi.sisbiblio.tablemodel.AutorTableModel;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JTable;

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
    private ObraTableModel model = null;

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
        obra = new Obra();
        obra.setIsbn(view.getTxtISBN().getText());
        obra.setTitulo(view.getTxtTitulo().getText());
        obra.setId(Integer.parseInt(view.getLblId().getText()));
        if (view.getTableAutor().getRowCount() > 0 && view.getTableAutor().getColumnCount() > 0 && view.getTableAutor().getValueAt(0, 0) != null) {
            for (int i = 0; i < view.getTableAutor().getRowCount(); i++) {
                Autor autor = new Autor();
                autor.setId((int) view.getTableAutor().getValueAt(i, 0));
                autor.setNome((String) view.getTableAutor().getValueAt(i, 1));
                autor.setEmail((String) view.getTableAutor().getValueAt(i, 1));
                obra.getAutores().add(autor);
            }
        }
        return dao.atualizar(obra);
    }

    @Override
    public boolean excluir() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean excluir(int id) {
        obra = new Obra();
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
            renderizar(view.getTableAutor(), obra.getAutores());
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

    public void gerarRelatorioAutoresPorObras() throws IOException {
        Report.authorsByBook(dao.listar());
    }

    /**
     *
     * @param obras
     */
    @Override
    public void renderizar(ArrayList<Obra> obras) {
        view.getTable().setModel(new ObraTableModel(obras));
        dimensionar();
    }

    @Override
    public void renderizar(JTable table, Object model) {
        if (model instanceof Autor) {

        } else if (model instanceof Obra) {
            table.setModel(new ObraTableModel(dao.listar()));
        }
        dimensionar();
    }

    @Override
    public void renderizar(JTable table, ArrayList<? extends Object> list) {
        if (list != null && !list.isEmpty()) {
            if (list.get(0) instanceof Obra) {
                table.setModel(new ObraTableModel((ArrayList<Obra>) list));
            } else {
                table.setModel(new AutorTableModel((ArrayList<Autor>) list));
            }

        }
        dimensionar();

    }

    public void findByISBNOrTitulo(String isbn, String titulo) {
        renderizar(repository.findByISBNOrTitulo(isbn, titulo));
        dimensionar();
    }

    private void dimensionar() {
        if (view.getTableAutor() != null && view.getTableAutor().getColumnCount() > 0) {
            view.getTableAutor().getColumnModel().getColumn(0).setPreferredWidth(2);
            view.getTableAutor().getColumnModel().getColumn(1).setPreferredWidth(300);
            view.getTableAutor().getColumnModel().getColumn(2).setPreferredWidth(150);
        }

        if (view.getTable() != null && view.getTable().getColumnCount()> 0) {
            view.getTable().getColumnModel().getColumn(0).setPreferredWidth(2);
            view.getTable().getColumnModel().getColumn(1).setPreferredWidth(100);
            view.getTable().getColumnModel().getColumn(2).setPreferredWidth(300);
        }

    }

}
