/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpr.uitl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aluno
 */
public class ConnectionFactory {
    
    // Nome do usuário do MariaDB
    private static final String USERNAME = "root";
    
    // Senha do MariaDB
    private static final String PASSWORD = "";
    
    // Caminho para o Banco de Dados
    // IP, porta e nome do banco de dados que deve ser conectado.
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/agenda?zeroDateTimeBehavior=convertToNull";
    
    public static Connection createConnetionToMariaDB() throws Exception{
        Connection connection = DriverManager
                .getConnection(DATABASE_URL, USERNAME, PASSWORD);
        
        return connection;
    }
    
    /**
     * Testar a conexão com o banco de dados
     * @param args 
     */
    public static void main(String[] args) {
        try {
            Connection con = createConnetionToMariaDB();
            if (con != null) {
                System.out.println("Conexão obtida com sucesso!" + con);
                con.close();
            }
        } catch (Exception ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
