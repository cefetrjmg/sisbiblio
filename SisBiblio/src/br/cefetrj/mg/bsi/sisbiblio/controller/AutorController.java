package br.cefetrj.mg.bsi.sisbiblio.controller;

import br.cefetrj.mg.bsi.sisbiblio.dao.AutorDAO;
import br.cefetrj.mg.bsi.sisbiblio.model.Autor;
import br.cefetrj.mg.bsi.sisbiblio.model.Obra;
import br.cefetrj.mg.bsi.sisbiblio.view.Dashboard;
import br.cefetrj.mg.bsi.sisbiblio.repository.AutorRepository;
import br.cefetrj.mg.bsi.sisbiblio.tablemodel.AutorTableModel;
import java.util.ArrayList;
import javax.swing.JTable;

public class AutorController implements Controller<Autor> {

    private final AutorRepository repository;
    private final AutorDAO dao;
    private Autor autor;
    private final Dashboard view;
    private int lastId = 0;
    private AutorTableModel model = null;
    
    public AutorController(Dashboard view){
        this.view = view;
        dao = new AutorDAO();
        repository = new AutorRepository();
        lastId = dao.getLastId();
    }
    
    @Override
    public boolean inserir() {
        autor = new Autor();
        autor.setEmail(view.getTxtEmail().getText());
        autor.setNome(view.getTxtNome().getText());
        autor.setId(++lastId);
        
        return dao.inserir(autor);
    }

    @Override
    public boolean atualizar() {
        autor = new Autor();
        autor.setEmail(view.getTxtEmail().getText());
        autor.setNome(view.getTxtNome().getText());
        autor.setId(Integer.parseInt(view.getLblId().getText()));
        return dao.atualizar(autor);
    }
    
    @Override
    public boolean excluir() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean excluir(int id) {
        autor = new Autor();
        autor.setId(id);
        
        return dao.excluir(autor);
    }
    
    @Override
    public boolean buscar() {

        return false;
    }

    public boolean buscar(int id) {
        autor = repository.findById(id);
        
        if(autor != null){
            view.getLblId().setText(String.valueOf(autor.getId()));
            view.getTxtEmail().setText(autor.getEmail());
            view.getTxtNome().setText(autor.getNome());
            view.getBtnCadastrarAtualizar().setText("Atualizar");
            renderizar(view.getTable(), autor.getObras());
            view.showFormAutor();
            
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean listar() {
        return false;
    }

    @Override
    public void renderizar(JTable table, Object model) {
        if(model instanceof Obra){
            
        }else if(model instanceof Autor){
            table.setModel(new AutorTableModel(dao.listar()));
        }
        
        dimensionar();
    }
    
    /**
     *
     * @param autores
     */

    @Override
    public void renderizar(ArrayList<Autor> autores) {
        view.getTable().setModel(new AutorTableModel(autores));
        dimensionar();
    }

    @Override
    public void renderizar(JTable table, ArrayList<? extends Object> list) {
        if(list != null && !list.isEmpty()){
            if(list.get(0) instanceof Autor){
                table.setModel(new AutorTableModel((ArrayList<Autor>) list));
            }else{
                table.setModel(new AutorTableModel((ArrayList<Autor>) list));
            }
        }
        dimensionar();
    }
    
    public void findByNameOrEmail(String name, String email){
        renderizar(repository.findByNameOrEmail(name, email));
        dimensionar();
    }

    private void dimensionar() {
        if(view.getTableAutor() != null && view.getTableAutor().getColumnCount() > 0) {
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
