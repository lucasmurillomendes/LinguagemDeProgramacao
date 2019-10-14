/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpr.uitl;

import br.edu.ifpr.bean.Contato;
import br.edu.ifpr.dao.ContatoDAO;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aluno
 */
public class Teste {
    
    public static void main(String[] args) {
        
        //Contato contato = new Contato(345345, "Armando", 58, new Date());
        
        try {
            Connection con = ConnectionFactory.createConnetionToMariaDB();
            ContatoDAO dao = new ContatoDAO(con);
            //Contato contato = dao.retrieve(1);
            
            List<Contato> contatos = dao.findALL();
            for (int i = 0; i < contatos.size(); i++) {
                System.out.println("ID: " + contatos.get(i).getId());
                System.out.println("NOME: " + contatos.get(i).getNome());
            }
         
        } catch (Exception ex) {
            Logger.getLogger(Teste.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
    
}
