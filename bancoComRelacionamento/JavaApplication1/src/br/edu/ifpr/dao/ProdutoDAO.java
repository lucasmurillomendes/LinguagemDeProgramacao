/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpr.dao;

import br.edu.ifpr.bean.Categoria;
import br.edu.ifpr.bean.Produto;
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
public class ProdutoDAO implements Dao<Integer, Produto>{
    
    protected Connection con;

    public ProdutoDAO(Connection con) {
        this.con = con;
    }

    @Override
    public void create(Produto entity) {
        String sql = "INSERT INTO Produto (descricao, Categoria_id) "
                + "VALUES (?, ?)";
        
        if (entity.getCategoria().getId() == 0) {
            CategoriaDAO dao = new CategoriaDAO(con);
            dao.create(entity.getCategoria());
        }
        
        try {
            PreparedStatement query = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            query.setString(1, entity.getDescricao());
            query.setInt(2, entity.getCategoria().getId());
            
            query.executeUpdate();
            ResultSet rs = query.getGeneratedKeys();
            
            if (rs.next()) {
                int id =rs.getInt(1);
                entity.setId(id);
            }
            
            query.close();
            
        } catch (SQLException e) {
        }
    }

    @Override
    public Produto retrieve(Integer pk) {
        Produto produto = null;
        
        String sql = "SELECT id, descricao, Categoria_id FROM Produto WHERE id = ?";
        
        try {
            PreparedStatement query = con.prepareStatement(sql);
            query.setInt(1, pk);
            
            ResultSet rs = query.executeQuery();
            
            while (rs.next()) {
                produto = new Produto();
                produto.setId(rs.getInt("id"));
                produto.setDescricao(rs.getString("descricao"));
                
                CategoriaDAO dao = new CategoriaDAO(con);
                Categoria categoria = dao.retrieve(rs.getInt("Categoria_id"));                
                produto.setCategoria(categoria);                
            }
            
            query.close();
            
        } catch (SQLException e) {
            System.out.println("SQL execption occured " + e);
        }
        
        return produto;
    }

    @Override
    public void update(Produto entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Integer pk) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Produto> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
