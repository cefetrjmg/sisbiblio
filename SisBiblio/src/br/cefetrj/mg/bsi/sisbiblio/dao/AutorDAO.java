package br.cefetrj.mg.bsi.sisbiblio.dao;

import br.cefetrj.mg.bsi.sisbiblio.config.Settings;
import br.cefetrj.mg.bsi.sisbiblio.model.Autor;
import br.cefetrj.mg.bsi.sisbiblio.model.Obra;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AutorDAO extends Settings implements DAO<Autor>{
    
    private Gson gson = null;
    private Autor autor = null;
    private static ArrayList<Autor> autores = new ArrayList<>();
    
    public AutorDAO(){
        gson = new Gson();
        setEnv();
    }
    
    private void setEnv() {
        NOME_ARQUIVO = "autores";
        EXTENSAO_ARQUIVO = ".json";
        EXTENSAO_TMP = ".tmp";
        FILE = new File (CAMINHO_ARQUIVO.concat(NOME_ARQUIVO.concat(EXTENSAO_ARQUIVO)));
        FILE_TMP = new File (CAMINHO_ARQUIVO);
    }
    
    private void init(){
        try {
            if(!FILE.exists())
                FILE.createNewFile();
        } catch(IOException ex){
            Logger.getLogger(AutorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean inserir(Object o) {
        autor = (Autor) o;
        listar();
        
        if(AutorDAO.autores.add(autor)){
            try{
                
                init();
                FILE_WRITER = new FileWriter(FILE,false);
                BUFFERED_WRITER = new BufferedWriter(FILE_WRITER);
                String aux = gson.toJson(autores);
                BUFFERED_WRITER.write(aux);
                BUFFERED_WRITER.close();
                FILE_WRITER.close();
                MSG = "O autor '" + autor.getNome() + "' foi inserido com sucesso.";
                
                return true;
                
            } catch (IOException ex) {
                autores.remove(autor);
                Logger.getLogger(AutorDAO.class.getName()).log(Level.SEVERE, null, ex);
                MSG = "Erro ao cadastrar autor";
                
                return false;
            }
        }else{
            MSG = "Erro ao cadastrar autor";

            return false;
        }
    }

    @Override
    public boolean atualizar(Object o) {
        int pos = getPos(o);
        
        if(pos != -1){
            autor = (Autor) o;
            
            if(autores.set(pos, autor) != null){
                try{
                    FILE.delete();
                    FILE.createNewFile();
                    FILE_WRITER = new FileWriter(FILE);
                    BUFFERED_WRITER = new BufferedWriter(FILE_WRITER);
                    BUFFERED_WRITER.write(gson.toJson(autores));
                    BUFFERED_WRITER.close();
                    FILE_WRITER.close();

                    MSG = "Autor atualizada com sucesso!";
                    
                    return true;
                } catch (IOException ex) {
                    autores.remove(pos);
                    Logger.getLogger(AutorDAO.class.getName()).log(Level.SEVERE, null, ex);
                    
                    return false;
                }
            }else{
                autores.remove(pos);
                MSG = "Erro ao atualizar o autor";
                
                return false;
            }
        }else{
            MSG = "Erro ao atualizar o autor";
            
            return false;
        }
    }

    @Override
    public boolean excluir(Object o) {
        int pos = getPos(o);
        
        if(pos != -1){
            if(autores.remove(pos) != null){
                try{
                    
                    init();
                    FILE_WRITER = new FileWriter(FILE);
                    BUFFERED_WRITER = new BufferedWriter(FILE_WRITER);
                    BUFFERED_WRITER.write(gson.toJson(autores));
                    BUFFERED_WRITER.close();
                    FILE_WRITER.close();
                    MSG = "Autor removido com sucesso!";
                    
                    return true;
                    
                } catch (IOException ex) {
                    autores.remove(pos);
                    Logger.getLogger(AutorDAO.class.getName()).log(Level.SEVERE, null, ex);
                    
                    return false;
                }
            }else{
                autores.remove(pos);
                MSG = "Erro ao excluir o autor";
                
                return false;
            }
        }else{
            MSG = "Erro ao excluir o autor";
            
            return false;
        }
    }

    @Override
    public Object buscar(Object o) {
        listar();
        
        Autor aux = (Autor) o;
        
        for(Autor autor : autores){
            if(aux.getId() != 0){
                if(aux.getId() == autor.getId()){
                    return autor;
                }
            }
            
            if(aux.getEmail() != null){
                if(aux.getEmail().equalsIgnoreCase(autor.getEmail())){
                         return autor;
                }
            }
            
            if(aux.getNome() != null){
                if(aux.getNome().equalsIgnoreCase(autor.getNome())){
                    return autor;
                }
            }
        }
        
        MSG = "Autor Inexistente";
        
        return null;
    }

    @Override
    public ArrayList<Autor> listar() {
        try{
            
            init();
            FILE_READER = new FileReader(FILE);
            BUFFERED_READER = new BufferedReader(FILE_READER);
            autores.clear();
            Autor[] autores = gson.fromJson(FILE_READER, Autor[].class);
            if (autores != null) {
                for (Autor o : autores) {
                    AutorDAO.autores.add(o);
                }
            }
            MSG = AutorDAO.autores.isEmpty() ? "Nenhum autor cadastrado" : "";
            BUFFERED_READER.close();
            FILE_READER.close();
            Collections.sort(AutorDAO.autores);
            
            return AutorDAO.autores;
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AutorDAO.class.getName()).log(Level.SEVERE, null, ex);
            
            return null;
        } catch (IOException ex) {
            Logger.getLogger(AutorDAO.class.getName()).log(Level.SEVERE, null, ex);
            
            return null;
        }
    }

    @Override
    public int getPos(Object o) {
       return autores.indexOf(buscar(o));
    }

    @Override
    public int getLastId() {
        listar();
        
        if(AutorDAO.autores != null && !AutorDAO.autores.isEmpty() && AutorDAO.autores.size() > 0){
            return AutorDAO.autores.get(AutorDAO.autores.size()-1).getId();
        }
        
        return 0;
    }

}
