/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.repository.db;

import com.sun.xml.internal.bind.v2.runtime.output.SAXOutput;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import rs.ac.bg.fon.repository.memory.*;
import rs.ac.bg.fon.repository.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import rs.ac.bg.fon.ps.controller.Controller;
import rs.ac.bg.fon.ps.domain.Ingredients;
import rs.ac.bg.fon.ps.domain.MeasurementUnit;
import rs.ac.bg.fon.ps.domain.Product;
import rs.ac.bg.fon.ps.domain.RawMaterial;
import rs.ac.bg.fon.ps.domain.Supplier;
import rs.ac.bg.fon.ps.domain.User;
import rs.ac.bg.fon.repository.db.impl.IngredientsRepository;

/**
 *
 * @author Raso
 */
public class ProductRepository implements DbRepository<Product, Long> {
    
    Connection connection;

    private List<Product> products;
    
    public ProductRepository() {
        
        products = new ArrayList<>();
        
    }
    public List<Product> getAllBeverageProducts() throws Exception{
        try {
            List<Product> products = new ArrayList<>();
            
            String upit = "SELECT id , NAME,  DESCRIPTION,  price, savedbyuser , measurementunit, isItFood FROM product  WHERE isItFood=0";
            System.out.println(upit);
            connection=DbConnectionFactory.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(upit);
            
            
             while(rs.next()){
                 System.out.println("Da li  ulazi u ptelju");
                Product product = new Product();
                product.setId(rs.getLong("id"));
                product.setName(rs.getString("NAME"));
                product.setMeasurementUnit(MeasurementUnit.valueOf(rs.getString("measurementunit")));
                product.setPrice(rs.getBigDecimal("price"));
                product.setDescription(rs.getString("DESCRIPTION"));
                
               
                
                products.add(product);
            }
             
             rs.close();
            statement.close();
            
            System.out.println("Uspjesno ucitana lista pica");
            
            return products;
            
        }catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Neuspjesno ucitana lista proizvoda");
            throw ex; 
        }
        
    }
    public List<Product> getAllFood() throws Exception{
        try {
            List<Product> products = new ArrayList<>();
            
            String upit = "SELECT"
                    + " pr.id AS prid, "
                    + " pr.name AS prname, "
                    + " pr.description AS prdesc, "
                    + " pr.price AS price, "
                    + " pr.savedbyuser AS user, "
                    + " pr.measurementunit AS unit, "
                    + " pr.amount AS amount, "
                    + " u.id AS uid, "
                    + " u.firstname AS uname, "
                    + " u.lastname AS ulast, "
                    + " u.password AS upass, "
                    + " u.username AS uuname "
                    + "FROM product pr INNER JOIN user u ON pr.savedbyuser=u.id WHERE isItFood=1";
                    connection=DbConnectionFactory.getInstance().getConnection();
                    System.out.println(upit);
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(upit);
            
            
            while(rs.next()){
                Product product = new Product();
                product.setId(rs.getLong("prid"));
                product.setName(rs.getString("prname"));
                product.setMeasurementUnit(MeasurementUnit.valueOf(rs.getString("unit")));
                product.setPrice(rs.getBigDecimal("price"));
                product.setDescription(rs.getString("prdesc"));
                product.setAmount(rs.getBigDecimal("amount"));
                User user = new User();
                user.setId(rs.getLong("user"));
                user.setFirstName(rs.getString("uname"));
                user.setLastName(rs.getString("ulast"));
                user.setUsername(rs.getString("uuname"));
                user.setPassword(rs.getString("upass"));
               
                product.setSavedByUser(user);
                products.add(product);
                System.out.println(product.getName());
            }
            rs.close();
            statement.close();
            
            System.out.println("Uspjesno ucitana lista hrane");
            
            return products;
            
            
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Neuspjesno ucitana lista proizvoda");
            throw ex; 
        }
    }
    
    public List<Product> getAll() throws Exception{
        try {
            List<Product> products = new ArrayList<>();
            
            String upit = "SELECT"
                    + " pr.id AS prid, "
                    + " pr.name AS prname, "
                    + " pr.description AS prdesc, "
                    + " pr.price AS price, "
                    + " pr.savedbyuser AS user, "
                    + " pr.measurementunit AS unit, "
                    + " pr.amount AS amount, "
                    + " u.id AS uid, "
                    + " u.firstname AS uname, "
                    + " u.lastname AS ulast, "
                    + " u.password AS upass, "
                    + " u.username AS uuname "
                    + "FROM product pr INNER JOIN user u ON pr.savedbyuser=u.id  ";
                    connection=DbConnectionFactory.getInstance().getConnection();
                    System.out.println(upit);
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(upit);
            
            
            while(rs.next()){
                Product product = new Product();
                product.setId(rs.getLong("prid"));
                product.setName(rs.getString("prname"));
                product.setMeasurementUnit(MeasurementUnit.valueOf(rs.getString("unit")));
                product.setPrice(rs.getBigDecimal("price"));
                product.setDescription(rs.getString("prdesc"));
                product.setAmount(rs.getBigDecimal("amount"));
                User user = new User();
                user.setId(rs.getLong("user"));
                user.setFirstName(rs.getString("uname"));
                user.setLastName(rs.getString("ulast"));
                user.setUsername(rs.getString("uuname"));
                user.setPassword(rs.getString("upass"));
               
                product.setSavedByUser(user);
                
                products.add(product);
                System.out.println(product.getName());
            }
            rs.close();
            statement.close();
            
            System.out.println("Uspjesno ucitana lista hrane");
            
            return products;
            
            
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Neuspjesno ucitana lista proizvoda");
            throw ex; 
        }
    }
    
    
    
   

    @Override
    public void edit(Product t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Product t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Product getById(Long k) throws Exception {
        List<Product> products = new ArrayList<>();
        products= Controller.getInstance().getAllProducts();
        for (Product product : products) {
            if(product.getId().equals(k))return product;
            
        }
        return null;
        
    }

    @Override
    public void add(Product product) throws SQLException{
         try {
            String upit = "INSERT INTO product (name,description, price, measurementunit, savedbyuser) VALUES (?,?,?,?,?)";
            //Kada koristimo ? umjesto onog gore nacina tada korstimo PreparedStatement umjesto statement
            //connection=DbConnectionFactory.getInstance().getConnection();
            connection=DbConnectionFactory.getInstance().getConnection();

            PreparedStatement statement = connection.prepareStatement(upit,Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, product.getName());
            statement.setString(2, product.getDescription());
            statement.setString(4, product.getMeasurementUnit().toString());
            statement.setDouble(3, product.getPrice().doubleValue());
            statement.setLong(5, product.getSavedByUser().getId());
            
            
            statement.executeUpdate();
            statement.close();
            
            System.out.println("Ingredient successfully created!");
        } catch (SQLException ex) {
                System.out.println("Unseccessfully created ingredientl!\n"+ex.getMessage());
                throw ex;

        }
    }
    public Long getByName(String productName) throws Exception{
       Long ID;
        try {
            String query = "SELECT id FROM product WHERE name= "+ productName ;
        connection=DbConnectionFactory.getInstance().getConnection();

            PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = statement.executeQuery(query);
            ID = rs.getLong("id");
        return ID;
        } catch (Exception e) {
            throw new Exception("Failed to retirve Product ID");
        }
       
    }
    
     public long addProductReturnKey(Product product) throws SQLException{
        
        
     try {
         
            String upit = "INSERT INTO product (name,description, price, measurementunit, savedbyuser, isItFood, amount) VALUES (?,?,?,?,?,?,?)";
            //Kada koristimo ? umjesto onog gore nacina tada korstimo PreparedStatement umjesto statement
            //connection=DbConnectionFactory.getInstance().getConnection();
            connection=DbConnectionFactory.getInstance().getConnection();

            PreparedStatement statement = connection.prepareStatement(upit,Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, product.getName());
            statement.setString(2, product.getDescription());
            statement.setString(4, product.getMeasurementUnit().toString());
            statement.setDouble(3, product.getPrice().doubleValue());
            statement.setLong(5, product.getSavedByUser().getId());
            statement.setBoolean(6, product.isIsItFood());
            statement.setDouble(7, product.getAmount().doubleValue());
            
            long productId=-1;
            
            statement.executeUpdate();
            ResultSet rs= statement.getGeneratedKeys();
            while(rs.next()){
                System.out.println(rs.getLong(1));
                 productId = rs.getLong(1);
                 
            } 
            
            
            //long productId = rs.getLong(1);
            statement.close();
            System.out.println("Ingredient successfully created!");
            return productId;
        } catch (SQLException ex) {
                System.out.println("Unseccessfully created ingredientl!\n"+ex.getMessage());
                throw ex;

        }
    
}

    public void updateProduct(Product product) throws SQLException {
        try {
            String query = "UPDATE PRODUCT set name='"+product.getName()+"', description='"+product.getDescription()+"', price="+product.getPrice()+", measurementUnit='"+product.getMeasurementUnit()+
                    "', savedByUser="+product.getSavedByUser().getId()+", isItFood="+product.isIsItFood()+", amount="+product.getAmount()+" WHERE id="+product.getId();
            connection = DbConnectionFactory.getInstance().getConnection();
            System.out.println(query);
            PreparedStatement statement = connection.prepareStatement(query);
            statement.executeUpdate(query);
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProductRepository.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }

    public void deleteAndInsertIngredients(Product product) throws SQLException {
        try{
        String query = "DELETE FROM ingredients WHERE productId ="+product.getId();
        
        
        PreparedStatement statement = connection.prepareStatement(query);
        statement.executeUpdate();
        List<Ingredients> ingredientsList = product.getIngredients();
        
        String upit = "INSERT INTO ingredients VALUES (?,?,?,?)";
        statement = connection.prepareStatement(upit,Statement.RETURN_GENERATED_KEYS);
        for (Ingredients t : ingredientsList) {
            
            //Kada koristimo ? umjesto onog gore nacina tada korstimo PreparedStatement umjesto statement
            //connection=DbConnectionFactory.getInstance().getConnection();
            System.out.println("Da li ulazi u petlju");
            System.out.println(t.getRawMaterialID());
            
            statement.setLong(1, t.getProductID());
            statement.setLong(2, t.getRawMaterialID());
            statement.setString(3,t.getMeasurementUnit().toString());
            statement.setBigDecimal(4, t.getQuantity());
            
            ResultSet rs = statement.getGeneratedKeys();
           
            statement.executeUpdate();
            
        }
        statement.close();
        }catch(Exception ex){
            ex.printStackTrace();
            throw ex;
        }
        
    }

    public void deleteBeverageProduct(Product product) {
        try {
            String query = "DELETE FROM product where id="+product.getId();
            connection = DbConnectionFactory.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            
            statement.executeUpdate();
            
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProductRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteFoodProduct(Product product) {
        try {
            String query ="DELETE FROM ingredients where productId="+product.getId();
            connection = DbConnectionFactory.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            
            statement.executeUpdate();
            
            query = "DELETE FROM product WHERE id="+product.getId();
            statement = connection.prepareStatement(query);
            statement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(ProductRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
