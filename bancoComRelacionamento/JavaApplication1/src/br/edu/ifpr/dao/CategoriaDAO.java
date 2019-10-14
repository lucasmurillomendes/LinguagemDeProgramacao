/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpr.dao;

import br.edu.ifpr.bean.Categoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author aluno
 */
public class CategoriaDAO implements Dao<Integer, Categoria>{
    
    protected Connection con;

    public CategoriaDAO(Connection con) {
        this.con = con;
    }

    @Override
    public void create(Categoria entity) {
        String sql = "INSERT INTO Categoria (descricao) VALUES (?)";
        
        try {
            PreparedStatement query = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            query.setString(1, entity.getDescricao());
            
            query.executeUpdate();
            ResultSet rs = query.getGeneratedKeys();
            
            if (rs.next()) {
                int id = rs.getInt(1);
                entity.setId(id);
            }
            
            query.close();
            
        } catch (Exception e) {
            System.out.println("SQL exception ocorred " + e);
        }
    }

    @Override
    public Categoria retrieve(Integer pk) {
        Categoria categoria = null;
        
        String sql = "SELECT id, descricao FROM Categoria WHERE id = ?";
        
        try {
            PreparedStatement query = con.prepareStatement(sql);
            query.setInt(1, pk);
            
            ResultSet rs = query.executeQuery();
            
            while(rs.next()) {
                categoria = new Categoria();
                categoria.setId(rs.getInt("id"));
                categoria.setDescricao(rs.getString("descricao"));
            }
            query.close();
        } catch (SQLException e) {
            System.out.println("SQL Exception occured " + e);
        }
        
        return categoria;
    }

    @Override
    public void update(Categoria entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Integer pk) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Categoria> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
