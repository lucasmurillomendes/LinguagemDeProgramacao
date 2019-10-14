/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpr;

import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aluno
 */
public class CriarArquivo {
    
    private static Formatter saida;
    
    public static void main(String[] args) {       
        abrirArquivo();
        adicionarRegistros();
        fecharArquivo();
    }

    /**
     * Método responsável por abrir o arquivo clientes.txt
     */
    private static void abrirArquivo() {
        try {
            saida = new Formatter("C:\\Users\\Public\\Documents\\clientes.txt");
        } catch (FileNotFoundException ex) {
            System.err.println("Erro ao abrir arquivo. Fechando sistema.");
            System.exit(1);
        }
    }

    private static void adicionarRegistros() {
        
        while (true){
            Scanner entrada = new Scanner(System.in);

            System.out.print("Número da conta: ");
            int numConta = entrada.nextInt();
            System.out.print("Primeiro nome: ");
            String nome = entrada.next();
            System.out.print("Segundo nome: ");
            String ultimoNome = entrada.next();
            System.out.print("Saldo: ");
            double saldo = entrada.nextDouble();
            
            saida.format("%-6d %-15s %-15s %.2f%n", numConta,
                    nome, ultimoNome, saldo);
            
            System.out.println("Digite 0 para sair ou "
                    + "qualquer coisa para continuar.");
            if(entrada.next().equals("0")) {
                System.out.println("Até mais!");
                break;
            }
        }
        
    }

    private static void fecharArquivo() {
        if (saida != null) {
            saida.close();
        }
    }
}
