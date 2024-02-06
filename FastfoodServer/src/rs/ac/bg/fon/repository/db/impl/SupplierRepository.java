package rs.ac.bg.fon.repository.db.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import rs.ac.bg.fon.ps.domain.Supplier;
import rs.ac.bg.fon.repository.db.DbConnectionFactory;
import rs.ac.bg.fon.repository.db.DbRepository;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Raso
 */
public class SupplierRepository implements DbRepository <Supplier, Long>{
        Connection connection;

    
    public void createSupplier(Supplier supplier) throws SQLException{
        try {
            String upit = "INSERT INTO supplier (id,name) VALUES ("+supplier.getId()+", '"+supplier.getName()+"')";
            connection=DbConnectionFactory.getInstance().getConnection();
            Statement statement = connection.createStatement();
            statement.executeUpdate(upit);
            statement.close();
            
            System.out.println("Supplier successfully created!");
        } catch (SQLException ex) {
                System.out.println("Unseccessfully created spplier!\n"+ex.getMessage());
                throw ex;

        }
    }
    @Override
     public List<Supplier> getAll() throws SQLException{
         try {
            List<Supplier> suppliers = new ArrayList<>();
            String upit = "SELECT id,name FROM supplier";
            System.out.println(upit);
            
            connection=DbConnectionFactory.getInstance().getConnection();
            Statement statement = connection.createStatement();
            
            ResultSet rs =statement.executeQuery(upit);
            while(rs.next()){
                Supplier supplier = new Supplier();
                supplier.setId(rs.getLong("id"));
                supplier.setName(rs.getString("name"));
                suppliers.add(supplier);
            }
            rs.close();
            statement.close();
            System.out.println("Successfully loaded suppliers list.");
            return suppliers;
        } catch (SQLException ex) {
           System.out.println("Unsuccessfully loaded supplierss list. ");
            throw ex;
        }
     }
     @Override
    public void add(Supplier supplier) throws SQLException {
        try {
            String upit = "INSERT INTO supplier (id,name) VALUES ("+supplier.getId()+", '"+supplier.getName()+"')";
            connection=DbConnectionFactory.getInstance().getConnection();
            Statement statement = connection.createStatement();
            statement.executeUpdate(upit);
            statement.close();
            
            System.out.println("Supplier successfully created!");
        } catch (SQLException ex) {
                System.out.println("Unseccessfully created spplier!\n"+ex.getMessage());
                throw ex;

        }
    }

    @Override
    public void edit(Supplier t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Supplier t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Supplier getById(Long k) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
