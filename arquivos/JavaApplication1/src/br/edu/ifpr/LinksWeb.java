/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpr;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author aluno
 */
public class LinksWeb {
    
    private static Scanner entrada;
    private static LinkedList<EnderecoWeb> enderecos;
    
    public static void main(String[] args) {
        enderecos = new LinkedList<>();
        abrirArquivo();
        lerRegistros();
        fecharArquivo();
        
        for (Iterator<EnderecoWeb> iterator = enderecos.iterator(); iterator.hasNext();) {
            EnderecoWeb next = iterator.next();
            System.out.println(next);
        }
    }
    
    
    private static void abrirArquivo() {
        
        Path caminhoArquivo = Paths.get(
                "C:\\Users\\aluno\\Documents\\sites.txt");
        try {
            entrada = new Scanner(caminhoArquivo);            
        } catch (IOException ex) {
            System.err.println("Erro ao abrir arquivo. Terminando.");
            System.exit(1);
        }
    }
    
    private static void lerRegistros() {
     
        try {
            while(entrada.hasNext()) {
               String nome = entrada.next();
               String link = entrada.next();
               EnderecoWeb web = new EnderecoWeb(nome, link);
               enderecos.add(web);
            }
        } catch (InputMismatchException e) {
            System.err.println("Arquivo indevidamente formatado."
                    + "Termando.");
            System.exit(1);
        } catch (IllegalStateException e) {
            System.err.println("Erro de leitura do arquivo."
                    + "Terminando.");
            System.exit(1);
        }
    }
    
    private static void fecharArquivo() {
        if (entrada != null) {
            entrada.close();
        }
    }
}
