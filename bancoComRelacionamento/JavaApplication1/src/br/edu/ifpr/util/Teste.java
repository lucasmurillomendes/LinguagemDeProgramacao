/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpr.util;

import br.edu.ifpr.bean.Categoria;
import br.edu.ifpr.bean.Produto;
import br.edu.ifpr.dao.CategoriaDAO;
import br.edu.ifpr.dao.ProdutoDAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aluno
 */
public class Teste {
    public static void main(String[] args) {
        try {
            
            ProdutoDAO dao = new ProdutoDAO(ConnectionFactory.createConnectionToMySQL());
            
            Produto p = dao.retrieve(1);
            
            System.out.println("Produto descricao " + p.getDescricao());
            System.out.println("Descricao da categoria " + p.getCategoria().getDescricao());
            
            /*
            Categoria categoria = new Categoria(0, "Periféricos");
            Produto produto = new Produto(0, "Teclado HP", categoria);
            
            dao.create(produto);
            */
            
            System.out.println("Id da categoria " + p.getCategoria().getId());
            System.out.println("Id do produto " + p.getId());
            
        } catch (SQLException ex) {
            Logger.getLogger(Teste.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
