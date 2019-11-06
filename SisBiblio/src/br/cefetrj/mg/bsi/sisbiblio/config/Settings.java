/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetrj.mg.bsi.sisbiblio.config;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

/**
 *
 * @author cristian
 */
public class Settings {

    public static String TITLE="Sistema de Biblioteca 1.0";
    protected static String MSG = "";
    protected static String NOME_ARQUIVO = "";
    protected static String EXTENSAO_ARQUIVO = "", EXTENSAO_TMP = ".tmp";
    protected static final String CAMINHO_ARQUIVO = System.getProperty("user.dir").concat("/src/br/cefetrj/mg/bsi/sisbiblio/files/");
    protected   File FILE=null;
    protected   File FILE_TMP=null;
    protected  FileWriter FILE_WRITER = null;
    protected  BufferedWriter BUFFERED_WRITER = null;
    protected  FileReader FILE_READER = null;
    protected  BufferedReader BUFFERED_READER = null;

}
