/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.repository.db.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;
import static jdk.nashorn.internal.objects.NativeMath.random;
import rs.ac.bg.fon.ps.domain.Invoice;
import rs.ac.bg.fon.ps.domain.InvoiceItem;
import rs.ac.bg.fon.repository.db.DbConnectionFactory;
import rs.ac.bg.fon.repository.db.DbRepository;

/**
 *
 * @author Raso
 */
public class InvoiceRepository implements DbRepository<Invoice, Long>{

    @Override
    public List<Invoice> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void add(Invoice t) throws Exception {

        Connection connection = DbConnectionFactory.getInstance().getConnection();
        
        String query = "INSERT INTO invoice(number, date, total) VALUES (?, ?, ?)";
        
        PreparedStatement naredba = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        Random random = new Random();
        int broj = (int) random(1000);
        long now = System.currentTimeMillis();
         Date sqlDate = new Date(now);
        String brojRacuna = String.valueOf(sqlDate);
        
        t.setNumber(brojRacuna);
        
        
        
        naredba.setString(1, t.getNumber());
        brojRacuna = String.valueOf(sqlDate)+broj;
        naredba.setString(2, brojRacuna);
        naredba.setBigDecimal(3, t.getTotal());
        naredba.executeUpdate();
        
        
        
        ResultSet rsKey = naredba.getGeneratedKeys();
        
        if(rsKey.next()){
            Long invoiceId = rsKey.getLong(1);
            t.setId(invoiceId);
           
            query = "INSERT INTO inovice_item (orderNumber, product_id, quantity, total) VALUES (?,?,?,?)";
            naredba= connection.prepareStatement(query);
            for (InvoiceItem item : t.getItems()) {
                naredba.setLong(1, t.getId());
             
                naredba.setLong(2, item.getProduct().getId());
              
                naredba.setBigDecimal(3, item.getQuantity());
              
                naredba.setBigDecimal(4, item.getTotal());
                
                naredba.executeUpdate();
                
                
            }
             }else{
            throw new Exception("Invoice id is not generated!");
        }
        
        
    }

    @Override
    public void edit(Invoice t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Invoice t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Invoice getById(Long k) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
