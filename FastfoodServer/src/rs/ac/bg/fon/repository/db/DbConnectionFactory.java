/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.repository.db;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Raso
 */
public class DbConnectionFactory {
    
    private Connection connection;
    private static DbConnectionFactory instance;
    
    private DbConnectionFactory(){
        
    }
    
    public static DbConnectionFactory getInstance(){
        if(instance == null){
            instance = new DbConnectionFactory();
        }
        return instance;
    }
    
    public Connection getConnection() throws SQLException{
        try {
             if(connection==null || connection.isClosed()){
             String url = "jdbc:mysql://localhost:3306/fastfood";
             String user = "root";
             String password = "Huawei98*";
             connection = DriverManager.getConnection(url, user, password);
             connection.setAutoCommit(false);
             System.out.println("Uspjesna konekcija");
             
             }
        } catch (SQLException ex) {
            System.out.println("Neuspjesno povezivanje na bazu.\n"+ex.getMessage());
            throw ex;
        }
        return connection;
    }
       
    
}
