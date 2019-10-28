/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetrj.mg.bsi.sisbiblio.model;

import java.util.ArrayList;

/**
 *
 * @author Maurício
 */
public class Autor {
    private int id;
    private String nome;
    private String email;
    private  ArrayList<Obra> obras =new ArrayList<>();
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<Obra> getObras() {
        return obras;
    }

    public void setObras(ArrayList<Obra> obras) {
        this.obras = obras;
    }

    @Override
    public String toString() {
        return "Autor{" + "id=" + id + ", nome=" + nome + ", email=" + email + ", obras=" + obras + '}';
    }
    
    
}
