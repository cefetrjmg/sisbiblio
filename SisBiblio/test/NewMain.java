
import br.cefetrj.mg.bsi.sisbiblio.config.Settings;
import br.cefetrj.mg.bsi.sisbiblio.dao.ObraDAO;
import br.cefetrj.mg.bsi.sisbiblio.model.Autor;
import br.cefetrj.mg.bsi.sisbiblio.model.Obra;
import com.google.gson.Gson;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author cristian
 */
public class NewMain extends Settings {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // System.out.println( FILE.getAbsoluteFile());
        //System.out.println( FILE.getAbsolutePath());
        System.out.println(System.getProperty("user.dir"));
        Gson gson = new Gson();
        ObraDAO dao = new ObraDAO();
        dao.listar();
        Obra o4=new Obra();
        o4.setId(4);
        o4 =(Obra) dao.buscar(o4);
        o4.setTitulo("Titulo 4");
        ArrayList<Autor> autores =new ArrayList<>();
        Autor autor =new Autor();
        autor.setEmail("autor@gmail.com");
        autor.setId(1);
        autor.setNome("Nome do Autor");
        o4.setIsbn("444");
        
        autores.add(autor);
        o4.setAutores(autores);
        
        dao.atualizar(o4);
        /*Obra o = new Obra();
        o.setId(1);
        o.setIsbn("123");
        o.setTitulo("Titulo 1");
        //System.out.println(gson.toJson(o));
        dao.inserir(o);

        // dao =new ObraDAO();
        o = new Obra();
        o.setId(2);
        o.setIsbn("321");
        o.setTitulo("Titulo 2");
        //System.out.println(gson.toJson(o));
        dao.inserir(o);
        
        
        
        
        o =new Obra();
        o.setId(3);
        o.setIsbn("3");
        o.setTitulo("Titulo 3");
        dao.inserir(o);
        
        Obra o1=(Obra) dao.buscar(dao.listar().get(1));
        o1.setTitulo("Título atualizado.");
        
        
        dao.excluir(dao.listar().get(0));
        dao.atualizar(o1);
        */
        dao.listar();

    }

}
