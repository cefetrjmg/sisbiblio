/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author cristian
 */
public class ObraDAO extends Settings implements DAO<Obra>{

    private Gson gson = null;
    private Obra obra = null;
    private static ArrayList<Obra> obras = new ArrayList<>();

    public ObraDAO() {
        gson = new Gson();
        setEnv();
    }

    private void setEnv() {
        NOME_ARQUIVO = "obras";
        EXTENSAO_ARQUIVO = ".json";
        EXTENSAO_TMP = ".tmp";
        FILE = new File(CAMINHO_ARQUIVO.concat(NOME_ARQUIVO.concat(EXTENSAO_ARQUIVO)));
        FILE_TMP = new File(CAMINHO_ARQUIVO);
    }

    private void init() {

        try {
            if (!FILE.exists()) 
                FILE.createNewFile();
        } catch (IOException ex) {
            Logger.getLogger(ObraDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /*
    * @param Object o
    * @return boolean
     */
    @Override
    public boolean inserir(Object o) {

        obra = (Obra) o;
        listar();
        if (ObraDAO.obras.add(obra)) {
            try {
                init();
                FILE_WRITER = new FileWriter(FILE,false);
                BUFFERED_WRITER = new BufferedWriter(FILE_WRITER);
                String aux = gson.toJson(obras);
                BUFFERED_WRITER.write(aux);
                BUFFERED_WRITER.close();
                FILE_WRITER.close();
                MSG = "O obra '" + obra.getTitulo() + "' inserido com sucesso.";
                return true;
            } catch (IOException ex) {
                obras.remove(obra);
                Logger.getLogger(ObraDAO.class.getName()).log(Level.SEVERE, null, ex);
                MSG = "Error ao cadastrar obra.";
                return false;
            }
        } else {
            MSG = "Error ao cadastrar a obra.";
            return false;
        }

    }

    @Override
    public boolean atualizar(Object o) {
        int pos = getPos(o);
        if (pos != -1) {
            obra = (Obra) o;
            if (obras.set(pos, obra) != null) {
                try {
                    FILE.delete();
                    FILE.createNewFile();
                    FILE_WRITER = new FileWriter(FILE);
                    BUFFERED_WRITER = new BufferedWriter(FILE_WRITER);
                    BUFFERED_WRITER.write(gson.toJson(obras));
                    BUFFERED_WRITER.close();
                    FILE_WRITER.close();

                    MSG = "Obra atualizada com sucesso!";
                    return true;
                } catch (IOException ex) {
                    obras.remove(pos);
                    Logger.getLogger(ObraDAO.class.getName()).log(Level.SEVERE, null, ex);
                    return false;
                }
            } else {
                obras.remove(pos);
                MSG = "Error ao atualizar a obra.";
                return false;
            }

        } else {
            MSG = "Error ao atualizar a obra.";
            return false;
        }

    }

    @Override
    public boolean excluir(Object o) {
        int pos = getPos(o);
        if (pos != -1) {
            if (obras.remove(pos) != null) {
                try {
                    init();
                    FILE_WRITER = new FileWriter(FILE);
                    BUFFERED_WRITER = new BufferedWriter(FILE_WRITER);
                    BUFFERED_WRITER.write(gson.toJson(obras));
                    BUFFERED_WRITER.close();
                    FILE_WRITER.close();
                    MSG = "Obra removida com sucesso!";
                    return true;
                } catch (IOException ex) {
                    obras.remove(pos);
                    Logger.getLogger(ObraDAO.class.getName()).log(Level.SEVERE, null, ex);
                    return false;
                }
            } else {
                obras.remove(pos);
                MSG = "Error ao excluir a obra.";
                return false;
            }
        } else {
            MSG = "Error ao excluir a obra.";
            return false;
        }
    }

    @Override
    public Object buscar(Object o) {
        listar();
        Obra aux = (Obra) o;
        for (Obra obra : obras) {
            if(aux.getId() != 0)
              if(aux.getId() == obra.getId())
                return obra;
            if(aux.getIsbn() != null)    
                if(aux.getIsbn().equalsIgnoreCase(obra.getIsbn()))
                    return obra;
            if(aux.getTitulo() != null)
                if(aux.getTitulo().equalsIgnoreCase(obra.getTitulo()))
                    return obra;
            
        }
        MSG = "Obra inexistente.";
        return null;
    }

    @Override
    public ArrayList<Obra> listar() {
        try {
            init();
            FILE_READER = new FileReader(FILE);
            BUFFERED_READER = new BufferedReader(FILE_READER);
            obras.clear();
            Obra[] obras = gson.fromJson(FILE_READER, Obra[].class);
            if (obras != null) {
                for (Obra o : obras) {
                    ObraDAO.obras.add(o);
                }
            }
            MSG = ObraDAO.obras.isEmpty() ? "Nenhuma obra cadastrada" : "";
            BUFFERED_READER.close();
            FILE_READER.close();
            Collections.sort(ObraDAO.obras);
            return ObraDAO.obras;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ObraDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (IOException ex) {
            Logger.getLogger(ObraDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    @Override
    public int getPos(Object o) {
        return obras.indexOf(buscar(o));
    }

    @Override
    public int getLastId() {
        listar();
        if(ObraDAO.obras != null && !ObraDAO.obras.isEmpty() && ObraDAO.obras.size()>0){
            return ObraDAO.obras.get(ObraDAO.obras.size()-1).getId();
        }
        return 0;
    }
    

}
