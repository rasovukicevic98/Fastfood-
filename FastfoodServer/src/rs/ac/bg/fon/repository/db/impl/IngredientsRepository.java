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
import java.util.ArrayList;
import java.util.List;
import rs.ac.bg.fon.ps.domain.Ingredients;
import rs.ac.bg.fon.ps.domain.MeasurementUnit;
import rs.ac.bg.fon.ps.domain.Product;
import rs.ac.bg.fon.ps.domain.RawMaterial;
import rs.ac.bg.fon.ps.domain.Supplier;
import rs.ac.bg.fon.ps.domain.User;
import rs.ac.bg.fon.repository.db.DbConnectionFactory;
import rs.ac.bg.fon.repository.db.DbRepository;

/**
 *
 * @author Raso
 */
public class IngredientsRepository implements DbRepository<Ingredients, Long>{
    
            Connection connection;
            private List<Ingredients> ingredients;

    @Override
    public List<Ingredients> getAll() throws Exception {
        
        try {
            
            String upit = "SELECT productId, rawMaterialId, measurementUnit, quantity FROM ingredients ";
            connection=DbConnectionFactory.getInstance().getConnection();

            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(upit);
            List<Ingredients> ingredientsList = new ArrayList<>();
            
            while(rs.next()){
                 
                
               
                
//                RawMaterial rawMaterial = new RawMaterial();
//                rawMaterial.setId(rs.getLong("rmid"));
//                rawMaterial.setName(rs.getString("rmname"));
//                rawMaterial.setMeasurementUnit(MeasurementUnit.valueOf(rs.getString("rmmu")));
//                rawMaterial.setAlarm(rs.getDouble("rma"));
                
                
                
               
                
//                Product product = new Product();
//                product.setId(rs.getLong("prid"));
//                product.setName(rs.getString("prname"));
//                product.setDescription(rs.getString("prdesc"));
//                product.setPrice(rs.getBigDecimal("prprice"));
//                product.setMeasurementUnit(MeasurementUnit.valueOf(rs.getString("prunit")));
               
                
              Ingredients ingredient = new Ingredients();
                ingredient.setProductID(rs.getLong("productId"));
                ingredient.setRawMaterialID(rs.getLong("rawMaterialId"));
                ingredient.setMeasurementUnit(MeasurementUnit.valueOf(rs.getString("measurementUnit")));
                ingredient.setQuantity(rs.getBigDecimal("quantity"));
                
                ingredientsList.add(ingredient);
            }
            rs.close();
            statement.close();
            
            System.out.println("Uspjesno ucitana lista sirovina");
            
            return ingredientsList;
            
            
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Neuspjesno ucitana lista sirovi");
            throw ex; 
        }
    }

    @Override
    public void add(Ingredients t) throws Exception {
        
         try {
            String upit = "INSERT INTO ingredient VALUES (?,?,?,?)";
            //Kada koristimo ? umjesto onog gore nacina tada korstimo PreparedStatement umjesto statement
            //connection=DbConnectionFactory.getInstance().getConnection();
            connection=DbConnectionFactory.getInstance().getConnection();

            PreparedStatement statement = connection.prepareStatement(upit,Statement.RETURN_GENERATED_KEYS);
            statement.setLong(1, t.getProductID());
            statement.setLong(2, t.getRawMaterialID());
            statement.setString(3,t.getMeasurementUnit().toString());
            statement.setBigDecimal(4, t.getQuantity());
            
            ResultSet rs = statement.getGeneratedKeys();
           
            statement.executeUpdate();
            statement.close();
            
            System.out.println("Ingredient successfully created!");
        } catch (SQLException ex) {
                System.out.println("Unseccessfully created ingredient!\n"+ex.getMessage());
                throw ex;

        }
    
    }
    
    
   
        
   
  
    public void addAll(List<Ingredients> ingredients) throws SQLException{
        
         
         
         try {
            String upit = "INSERT INTO ingredients VALUES (?,?,?,?)";
            //Kada koristimo ? umjesto onog gore nacina tada korstimo PreparedStatement umjesto statement
            //connection=DbConnectionFactory.getInstance().getConnection();
            connection=DbConnectionFactory.getInstance().getConnection();

            PreparedStatement statement = connection.prepareStatement(upit);

            
        for (Ingredients ingredient : ingredients) {
           
            statement.setLong(1, ingredient.getProductID());
            statement.setLong(2, ingredient.getRawMaterialID());
            statement.setString(3,ingredient.getMeasurementUnit().toString());
            statement.setBigDecimal(4, ingredient.getQuantity());
           
            statement.executeUpdate();
            
            System.out.println("Ingredient successfully created!");
        }
                    statement.close();

        } catch (Exception ex) {
                System.out.println("Unseccessfully created ingredient!\n"+ex.getMessage());
                throw ex;

        }
       
        
    }

    @Override
    public void edit(Ingredients t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Ingredients t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Ingredients getById(Long k) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
         

    }

   
            
            

