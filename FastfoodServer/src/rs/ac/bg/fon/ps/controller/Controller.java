/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ps.controller;

import com.sun.corba.se.spi.activation.Repository;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import rs.ac.bg.fon.ps.domain.Ingredients;
import rs.ac.bg.fon.ps.domain.Invoice;
import rs.ac.bg.fon.ps.domain.Product;
import rs.ac.bg.fon.ps.domain.RawMaterial;
import rs.ac.bg.fon.ps.domain.Supplier;
import rs.ac.bg.fon.ps.domain.User;
import rs.ac.bg.fon.repository.db.DbRepository;
import rs.ac.bg.fon.repository.db.ProductRepository;
import rs.ac.bg.fon.repository.db.impl.IngredientsRepository;
import rs.ac.bg.fon.repository.db.impl.InvoiceRepository;
import rs.ac.bg.fon.repository.db.impl.RawMaterialRepository;
import rs.ac.bg.fon.repository.db.impl.SupplierRepository;
import rs.ac.bg.fon.repository.db.impl.UserRepository;
import transfer.ServerskiOdgovor;

/**
 *
 * @author Raso
 */
public class Controller {
    
    private static Controller instance;
    
    private final DbRepository storageUser;
    private final DbRepository storageProduct;
    private final DbRepository storageRawMaterial;
    private final DbRepository storageSupplier;
    private final DbRepository storageInvoice;
    private final DbRepository storageIngredient;
    private List<User> logedInUsers;
    private User currentUser;
    private Controller() {
        logedInUsers = new ArrayList<>();
        this.storageUser = new UserRepository();
        this.storageRawMaterial = new RawMaterialRepository();
        this.storageProduct = new ProductRepository();
        this.storageSupplier = new SupplierRepository();
        this.storageInvoice = new InvoiceRepository();
        this.storageIngredient = new IngredientsRepository();
    }
    
    
    public static Controller getInstance(){
        if(instance==null){
            instance = new Controller();
        }
        return instance;
    }
    
    
    
    public ServerskiOdgovor login(User pristigliUser) throws Exception {
        ServerskiOdgovor so = new ServerskiOdgovor();
        
        List<User> users = storageUser.getAll();
        for (User logedInUser : logedInUsers) {
            if(pristigliUser.getUsername().equals(logedInUser.getUsername())){
                so.setUspjesno(false);
                so.setPoruka("User is already loged in");
                return so;
            }
        }
        
        for (User user:users){
            if((user.getUsername().equals(pristigliUser.getUsername()) && user.getPassword().equals(pristigliUser.getPassword()))){
                pristigliUser.setId(user.getId());
                logedInUsers.add(pristigliUser);
                so.setUspjesno(true);
                return so;
            }
            
        }
        so.setUspjesno(false);
        return so;
    }
    
    public List <RawMaterial> getAllRawMaterials() throws Exception{
        
        storageRawMaterial.connect();
        List<RawMaterial> rawMaterials = storageRawMaterial.getAll();
        storageRawMaterial.disconnect();
        return rawMaterials;
    }
    
    public boolean addRawMaterial(RawMaterial rawMaterial) throws Exception{
       /* if(storageRawMaterial.getAll().contains(rawMaterial)){
            throw new Exception("Raw material already exists");
        }
        storageRawMaterial.add(rawMaterial);
*/
       storageRawMaterial.connect();
        try {
            storageRawMaterial.add(rawMaterial);
            storageRawMaterial.commit();
        } catch (Exception e) {
            storageRawMaterial.rollback();
            e.printStackTrace();
            return false;
            
        }finally{
            storageRawMaterial.disconnect();
            return true;
        }
       
    }
    
    
    public boolean addAllRawMaterials(List<RawMaterial> rawMaterials) throws Exception{
        storageRawMaterial.connect();
        try {
            ((RawMaterialRepository)storageRawMaterial).addAll(rawMaterials);
            storageRawMaterial.commit();
            
        } catch (Exception e) {
            storageRawMaterial.rollback();
            e.printStackTrace();
            return false;
        }finally{
            storageRawMaterial.disconnect();
            return true;
        }
        
    }
    public Long addAllIngredientsAndProduct(List<Ingredients> ingredients, Product product) throws Exception{
        storageIngredient.connect();
        storageProduct.connect();
        Long id=null;
        try {
            id = ((ProductRepository)storageProduct).addProductReturnKey(product);
            
            for (Ingredients ingredient : ingredients) {
                ingredient.setProductID(id);
                
            }
            ((IngredientsRepository)storageIngredient).addAll(ingredients);
            storageIngredient.commit();
            storageProduct.commit();
        } catch (Exception e) {
            
            
            storageIngredient.rollback();
            storageProduct.rollback();
            e.printStackTrace();
            throw e;
        }finally{
        storageIngredient.disconnect();
        storageProduct.disconnect();
        return id;
    }
    }
    public void addAllIngredients(List<Ingredients> ingredients) throws Exception{
        storageIngredient.connect();
        try {
            ((IngredientsRepository)storageIngredient).addAll(ingredients);
            storageIngredient.commit();
        } catch (Exception e) {
            storageIngredient.rollback();
            e.printStackTrace();
            throw e;
        }finally{
            storageIngredient.disconnect();
        }
        
    }
    public boolean addSupplier(Supplier supplier ) throws Exception{
       storageSupplier.connect();
        try {
            storageSupplier.add(supplier);
            storageSupplier.commit();
        } catch (Exception e) {
            storageSupplier.rollback();
            e.printStackTrace();
            return false;
        }finally{
            storageSupplier.disconnect();
            return true;
        }
    }
    
    public List <Supplier> getAllSuppliers() throws Exception{
        storageSupplier.connect();
        
        List<Supplier> suppliers = storageSupplier.getAll();
        storageSupplier.disconnect();
        return suppliers;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }
public void addInvoice(Invoice invoice ) throws Exception{
       storageInvoice.connect();
        try {
            storageInvoice.add(invoice);
            storageInvoice.commit();
        } catch (Exception e) {
            storageInvoice.rollback();
            e.printStackTrace();
            throw e;
        }finally{
            storageInvoice.disconnect();
        }
    }
   public long addProduct(Product product) throws Exception{
        //storageProduct.connect();
        ProductRepository pr = new ProductRepository();

        Long id=null;
        try {
             pr.connect();
             id = pr.addProductReturnKey(product);
            //storageProduct.add(product);
            pr.commit();
            //storageProduct.commit();
        } catch (Exception e) {
            //storageProduct.rollback();
            pr.rollback();
            e.printStackTrace();
            throw e;
        }finally{
            //storageProduct.disconnect();
            pr.disconnect();
            return id;
        }
   }
  
   
   public List<Product> getAllFoodProducts() throws Exception{
       
       ProductRepository pr = new ProductRepository();
       pr.connect();
       List<Product> products;
       products = pr.getAllFood();
       pr.disconnect();
       return products;
   }

    public List<Product> getAllBeverageProducts() throws Exception {
        
       ProductRepository pr = new ProductRepository();
       List<Product> products= new ArrayList<>();
       try{
           pr.getAllBeverageProducts();
       
       products = pr.getAllBeverageProducts();
       
       }catch(Exception e){
           e.printStackTrace();
           throw e;
       }finally{
            //storageProduct.disconnect();
            pr.disconnect();
            return products;
        }
       
    }

    public List<Product> getAllProducts() throws Exception {
        storageProduct.connect();
        List<Product> products = storageProduct.getAll();
        storageProduct.disconnect();
        return products;
    }
    
    public List<Ingredients> getAllIngredients() throws Exception{
        storageIngredient.connect();
        List<Ingredients> ingredients = storageIngredient.getAll();
        storageIngredient.disconnect();
        return ingredients;
    }

    public boolean updateProductFood(Product product) throws Exception {
        ProductRepository pr = new ProductRepository();
        IngredientsRepository ir = new IngredientsRepository();
        pr.connect();
        ir.connect();
        try{
            System.out.println("Dosli smo do fije");
            pr.updateProduct(product);
            pr.deleteAndInsertIngredients(product);
            pr.commit();
            ir.commit();
            return true;
        }catch(Exception e){
            pr.rollback();
            ir.rollback();
            return false;
        }
        
    }

    public boolean deleteBeverageProduct(Product product) throws Exception {
        ProductRepository pr = new ProductRepository();
        try {
            
            pr.connect();
            pr.deleteBeverageProduct(product);
            pr.commit();
            pr.disconnect();
            return true;
        } catch (Exception ex) {
            pr.rollback();
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            pr.disconnect();
            return false;
        }
        
    }

    public boolean deleteRawMaterial(RawMaterial rawMaterial) throws Exception {
        RawMaterialRepository rmr = new RawMaterialRepository();

        try {
            rmr.connect();
            rmr = new RawMaterialRepository();
            
            rmr.deleteRawMaterial(rawMaterial);
           rmr.commit();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            rmr.rollback();
            return false;
            
        }
        
    }

    public boolean deleteFoodProduct(Product product) throws Exception {
        ProductRepository pr = new ProductRepository();
        
        try {
            pr.connect();
            pr.deleteFoodProduct(product);
            pr.commit();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            pr.rollback();
            return false;
            
        }
    }
    
    

    
    
    
    
}
