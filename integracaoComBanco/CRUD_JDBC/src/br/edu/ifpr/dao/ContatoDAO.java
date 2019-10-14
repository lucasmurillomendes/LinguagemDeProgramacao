/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpr.dao;

import br.edu.ifpr.bean.Contato;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author aluno
 */
public class ContatoDAO implements Dao<Integer, Contato>{

    private Connection con;

    public ContatoDAO(Connection con) {
        this.con = con;
    }
    
    @Override
    public void create(Contato entity) {
        
        String sql = "INSERT INTO contato (nome, idade, dataCadastro)"
                + " VALUES (?, ?, ?)";
        
        try {
            PreparedStatement query = con.prepareStatement(sql);
            query.setString(1, entity.getNome());
            query.setInt(2, entity.getIdade());
            query.setDate(3, new Date(entity.getDataCadastro().getTime()));
            
            query.execute();
            query.close();
            
        } catch (SQLException ex) {
            System.out.println("SQL exception ocorreu" + ex);
        }
        
    }

    @Override
    public Contato retrieve(Integer pk) {
        // Cria novo objeto
        Contato contato = new Contato();
        
        // Definir a SQL
        String sql = "SELECT id, nome, idade, dataCadastro FROM "
                + "contato where id = ?";
        
        try {
            PreparedStatement query = con.prepareStatement(sql);
            query.setInt(1, pk);
            
            // Executa o SQL (Query) de obtém o resultado da query.
            ResultSet rs = query.executeQuery();
            
            // Recuperar os dados retornados
            while(rs.next()) {
                contato.setId(rs.getInt("id"));
                contato.setNome(rs.getString("nome"));
                contato.setIdade(rs.getInt("idade"));
                contato.setDataCadastro(rs.getDate("dataCadastro"));
            }
            query.close();
        } catch (SQLException ex) {
        }
        
        return contato;
    }

    @Override
    public void update(Contato entity) {
        
        String sql = "UPDATE contato SET nome = ?, idade = ?, "
                + "dataCadastro = ? WHERE id = ?";
        
        try {
            PreparedStatement query = con.prepareStatement(sql);
            query.setString(1, entity.getNome());
            query.setInt(2, entity.getIdade());
            query.setDate(3, new Date(entity.getDataCadastro().getTime()));
            query.setInt(4, entity.getId());
            
            query.executeUpdate();
            query.close();
        } catch (SQLException ex) {
            System.out.println("SQL exception ocorreu " + ex);
        }
    }

    @Override
    public void delete(Integer pk) {
        String sql = "DELETE FROM contato WHERE id = ?";

        try{
            PreparedStatement query = con.prepareStatement(sql);
            query.setInt(1, pk);
            
            query.executeUpdate();
            query.close();            
        } catch (SQLException ex) {
            System.out.println("SQL exception ocorreu " + ex);
        }
    }

    @Override
    public List<Contato> findALL() {
        String sql = "SELECT id, nome, idade, dataCadastro FROM contato";
        List<Contato> contatos = new LinkedList<>();                
        try{
            Statement query = con.createStatement();
            ResultSet rs = query.executeQuery(sql);
            
            // Recupera dados do conjunto
            while(rs.next()) {
                Contato contato = new Contato();
                contato.setId(rs.getInt("id"));
                contato.setNome(rs.getString("nome"));
                contato.setIdade(rs.getInt("idade"));
                contato.setDataCadastro(rs.getDate("dataCadastro"));
                contatos.add(contato);
            }
            
            query.close();
        }catch(SQLException ex) {
            System.out.println("SQL exception ocorreu " + ex);
        }
        
        return contatos;
    }
    
}
