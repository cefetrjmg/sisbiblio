/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetrj.mg.bsi.sisbiblio.faker;

import java.util.Random;

/**
 *
 * @author cristian
 */
public class AutorFaker {
    
    public static void main(String[] args) {
        System.out.println(gerarNomeFaker());
        System.out.println(gerarEmailFaker());
    }
    public  static String gerarNomeFaker(){
        String nomeAutorFaker="";
        for (int i = 0; i < 35; i++) {
           Random r =new Random();
            int aux=r.nextInt(90);
            if(aux >=65 && aux <=90)
                nomeAutorFaker=nomeAutorFaker.concat(String.valueOf((char)aux));
        }
        return nomeAutorFaker;
    }
    public  static String gerarEmailFaker(){
        String tiposEmails[]={
            "@gmail.com",
            "@hotmail.com",
            "@yahoo.com.br",
            "@cefet-rj.br"
        };
        Random r =new Random();
        String emailAutorFaker="";
        for (int i = 0; i < 35; i++) {
           int aux=r.nextInt(90);
            if(aux >=65 && aux <=90)
                emailAutorFaker=emailAutorFaker.concat(String.valueOf((char)aux));
            
        }
        int aux=r.nextInt(4);
        
        return emailAutorFaker.concat(tiposEmails[aux]);
    }
    
    
    
}
