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
import java.util.logging.Level;
import java.util.logging.Logger;
import rs.ac.bg.fon.ps.domain.MeasurementUnit;
import rs.ac.bg.fon.ps.domain.RawMaterial;
import rs.ac.bg.fon.ps.domain.Supplier;
import rs.ac.bg.fon.ps.domain.User;
import rs.ac.bg.fon.repository.db.DbConnectionFactory;
import rs.ac.bg.fon.repository.db.DbRepository;

/**
 *
 * @author Raso
 */
public class RawMaterialRepository implements DbRepository<RawMaterial, Long>{
    
    Connection connection;
    List <RawMaterial> rawMaterials;

    public RawMaterialRepository() {
        rawMaterials = new ArrayList<>();
    }
    
    public List <RawMaterial> getAll() throws Exception{
       try {
            List<RawMaterial> rawMaterials = new ArrayList<>();
            
            String upit = "SELECT"
                    + " rm.id AS rmid, "
                    + " rm.name AS rmname, "
                    + " rm.measurementunit AS rmmu, "
                    + " rm.alarm AS rma, "
                    + " rm.savedbyuser AS user, "
                    + " rm.supplier AS rms, "
                    + " s.id AS sid, "
                    + " s.name AS sname, "
                    + " u.id AS uid, "
                    + " u.firstname AS uname, "
                    + " u.lastname AS ulast, "
                    + " u.password AS upass, "
                    + " u.username AS uuname "
                    + "FROM rawmaterial rm INNER JOIN supplier s ON rm.supplier=s.id INNER JOIN user u ON rm.savedbyuser=u.id ORDER BY rm.id";
                    connection=DbConnectionFactory.getInstance().getConnection();

            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(upit);
            
            
            while(rs.next()){
                RawMaterial rawMaterial = new RawMaterial();
                rawMaterial.setId(rs.getLong("rmid"));
                rawMaterial.setName(rs.getString("rmname"));
                rawMaterial.setMeasurementUnit(MeasurementUnit.valueOf(rs.getString("rmmu")));
                rawMaterial.setAlarm(rs.getDouble("rma"));
                User user = new User();
                user.setId(rs.getLong("user"));
                user.setFirstName(rs.getString("uname"));
                user.setLastName(rs.getString("ulast"));
                user.setUsername(rs.getString("uuname"));
                user.setPassword(rs.getString("upass"));
                Supplier supplier = new Supplier();
                supplier.setId(rs.getLong("sid"));
                supplier.setName(rs.getString("sname"));
                rawMaterial.setSavedByUser(user);
                rawMaterial.setSupplier(supplier);
                rawMaterials.add(rawMaterial);
             
            }
            rs.close();
            statement.close();
            
            System.out.println("Uspjesno ucitana lista sirovina");
            
            return rawMaterials;
            
            
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Neuspjesno ucitana lista sirovi");
            throw ex; 
        }
    }
    
    public void add(RawMaterial rawMaterial) throws SQLException{
         try {
            String upit = "INSERT INTO rawmaterial (name,measurementunit,alarm, savedbyuser,supplier) VALUES (?,?,?,?,?)";
            //Kada koristimo ? umjesto onog gore nacina tada korstimo PreparedStatement umjesto statement
            //connection=DbConnectionFactory.getInstance().getConnection();
            connection=DbConnectionFactory.getInstance().getConnection();

            PreparedStatement statement = connection.prepareStatement(upit);
         //   statement.setLong(1, rawMaterial.getId());
            statement.setString(1, rawMaterial.getName());
            statement.setString(2, rawMaterial.getMeasurementUnit().toString());
            statement.setDouble(3, rawMaterial.getAlarm());
            statement.setLong(4, rawMaterial.getSavedByUser().getId());
            statement.setLong(5, rawMaterial.getSupplier().getId());
            
            statement.executeUpdate();
            statement.close();
            
            System.out.println("Raw material successfully created!");
        } catch (SQLException ex) {
                System.out.println("Unseccessfully created raw material!\n"+ex.getMessage());
                throw ex;

        }
    }
    
    public void addAll(List<RawMaterial> rawMaterials) throws SQLException{
        
         try {
            String upit = "INSERT INTO rawmaterial (name,measurementunit,alarm, savedbyuser,supplier) VALUES (?,?,?,?,?)";
            //Kada koristimo ? umjesto onog gore nacina tada korstimo PreparedStatement umjesto statement
            //connection=DbConnectionFactory.getInstance().getConnection();
            connection=DbConnectionFactory.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(upit);

            for(RawMaterial rawMaterial:rawMaterials){
            //statement.setLong(1, rawMaterial.getId());
            statement.setString(1, rawMaterial.getName());
            statement.setString(2, rawMaterial.getMeasurementUnit().toString());
            statement.setDouble(3, rawMaterial.getAlarm());
            statement.setLong(4, rawMaterial.getSavedByUser().getId());
            statement.setLong(5, rawMaterial.getSupplier().getId());
            
            statement.executeUpdate();
            
            System.out.println("Raw material successfully created!");
            }
            statement.close();

        } catch (SQLException ex) {
                System.out.println("Unseccessfully created raw material!\n"+ex.getMessage());
                throw ex;

        }
        
        
        
    }

    @Override
    public void edit(RawMaterial t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(RawMaterial t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public RawMaterial getById(Long k) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void deleteRawMaterial(RawMaterial rawMaterial) throws SQLException {
        try {
            String upit = "DELETE FROM rawmaterial where id = "+rawMaterial.getId();
            
            connection = DbConnectionFactory.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(upit);
            
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(RawMaterialRepository.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
        
    }
    
    
    
}
