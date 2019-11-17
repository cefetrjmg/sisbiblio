/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetrj.mg.bsi.sisbiblio.rn;

import br.cefetrj.mg.bsi.sisbiblio.view.Dashboard;
import java.util.ArrayList;

/**
 *
 * @author cristian
 */
public class ObraRN {
    ArrayList<String> erros=new ArrayList<>();
    public ArrayList<String> validarForm(Dashboard view){
        erros.clear();
        if(view.getTxtTitulo().getText().equals(""))
            erros.add("Título não pode estar em branco.");
        if(view.getTxtTitulo().getText().trim().length() < 5 || view.getTxtTitulo().getText().trim().length() > 50)
            erros.add("Título deve ter entre 5 e 50 caracteres.");
        if(view.getTxtISBN().getText().trim().length() != 13)
            erros.add("ISBN deve ter 13 caracteres.");
        return erros;
    }
}
