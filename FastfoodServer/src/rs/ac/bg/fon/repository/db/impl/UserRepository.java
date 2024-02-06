/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.repository.db.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import rs.ac.bg.fon.repository.*;
import java.util.ArrayList;
import java.util.List;
import rs.ac.bg.fon.ps.domain.Supplier;
import rs.ac.bg.fon.ps.domain.User;
import rs.ac.bg.fon.repository.db.DbConnectionFactory;
import rs.ac.bg.fon.repository.db.DbRepository;

/**
 *
 * @author Raso
 */
public class UserRepository implements DbRepository <User, Long>{
        Connection connection;

  //  private List<User> users;

   /* public UserRepository() {
        users = new ArrayList<>();
        users.add(new User(1L, "Admin", "Admin", "admin", "admin"));
    }
*/
    
    public List<User> getAll() throws SQLException{
        
        try {
            List<User> users = new ArrayList<>();
            String upit = "SELECT id, firstname,lastname, password, username FROM user";
            System.out.println(upit);
            connection=DbConnectionFactory.getInstance().getConnection();

            Statement statement = connection.createStatement();
            
            ResultSet rs =statement.executeQuery(upit);
            while(rs.next()){
                User user = new User();
                user.setId(rs.getLong("id"));
                user.setFirstName(rs.getString("firstname"));
                user.setLastName(rs.getString("lastname"));
                user.setPassword(rs.getString("password"));
                user.setUsername(rs.getString("username"));
                 users.add(user);
            }
            rs.close();
            statement.close();
            System.out.println("Successfully loaded users list.");
            return users;
        } catch (SQLException ex) {
           System.out.println("Unsuccessfully loaded users list. ");
            throw ex;
        }
    }
    
    public void createUser(User user) throws SQLException{
        
        try {
            String upit = "INSERT INTO user (firstname, lastname, password, username) VALUES (?,?,?,?)";
            //Kada koristimo ? umjesto onog gore nacina tada korstimo PreparedStatement umjesto statement
            connection=DbConnectionFactory.getInstance().getConnection();

            PreparedStatement statement = connection.prepareStatement(upit, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, user.getFirstName());
            statement.setString(2, user.getLastName());
            statement.setString(3, user.getPassword());
            statement.setString(4, user.getUsername());
            
            ResultSet rs = statement.getGeneratedKeys();
            if(rs.next()){
                user.setId(rs.getLong(1 ));
            }
            
            statement.executeUpdate();
            statement.close();
            
            System.out.println("User successfully created!");
        } catch (SQLException ex) {
                System.out.println("Unseccessfully created user!\n"+ex.getMessage());
                throw ex;

        }
    }

    @Override
    public void add(User t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void edit(User t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(User t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User getById(Long k) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
