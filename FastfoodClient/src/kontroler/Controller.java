/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler;

import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import komunikacija.Communication;
import rs.ac.bg.fon.ps.domain.Ingredients;
import rs.ac.bg.fon.ps.domain.Invoice;
import rs.ac.bg.fon.ps.domain.InvoiceItem;
import rs.ac.bg.fon.ps.domain.Product;
import rs.ac.bg.fon.ps.domain.RawMaterial;
import rs.ac.bg.fon.ps.domain.Supplier;
import rs.ac.bg.fon.ps.domain.User;
import transfer.KlijentskiZahtjev;
import transfer.Operacija;
import transfer.ServerskiOdgovor;

/**
 *
 * @author Raso
 */
public class Controller {
    private static Controller instance;
    Socket klijentskiSocket;
    User ulogovaniUser;
    String currentTable;
    private Invoice[] invoicePerTable;
    public static Controller getInstance(){
        if(instance==null){
            instance=new Controller();
        }
        return instance;
    }

    public Controller() {
        invoicePerTable = new Invoice[6];
        for (Invoice invoice : invoicePerTable) {
            invoice = new Invoice();
        }
        invoicePerTable[1]=new Invoice();
        invoicePerTable[2]=new Invoice();
        invoicePerTable[3]=new Invoice();
        invoicePerTable[4]=new Invoice();
        invoicePerTable[5]=new Invoice();
    }
    public void saveTableOrder(Invoice invoiceFromTable, int number){
        invoicePerTable[number] =  invoiceFromTable;
        
    }

    public String getCurrentTable() {
        return currentTable;
    }

    public Invoice[] getInvoicePerTable() {
        return invoicePerTable;
    }
    
    
    

    public Socket getKlijentskiSocket() {
        return klijentskiSocket;
    }

    public void setKlijentskiSocket(Socket klijentskiSocket) {
        this.klijentskiSocket = klijentskiSocket;
    }
    
    public ServerskiOdgovor login(User user){
        KlijentskiZahtjev kz = new KlijentskiZahtjev();
        kz.setObjekat(user);
        kz.setOperacija(Operacija.LOGIN);
        Communication.getInstance().posaljiZahtjev(kz);
        ServerskiOdgovor so = Communication.getInstance().primiOdgovor();
        return so;
    }

    public User getUlogovaniUser() {
        return ulogovaniUser;
    }

    public void setUlogovaniUser(User ulogovaniUser) {
        this.ulogovaniUser = ulogovaniUser;
    }
    

    public Socket getSocket() {
        return klijentskiSocket;
    }

    public void setCurrentUser(User user) {
        ulogovaniUser = user;
    }

    public List<Product> getAllFoodProducts() {
        
        KlijentskiZahtjev kz = new KlijentskiZahtjev();
        kz.setOperacija(Operacija.GET_ALL_FOOD_PRODUCTS);
        Communication.getInstance().posaljiZahtjev(kz);
        ServerskiOdgovor so =Communication.getInstance().primiOdgovor();
        List<Product> products =(List<Product>) so.getObject();
        return products;
    }

    public ServerskiOdgovor addProductAndIngredients(Product product) {
        KlijentskiZahtjev kz = new KlijentskiZahtjev();
        kz.setObjekat(product);
        kz.setOperacija(Operacija.ADD_PRODUCT_AND_INGREDIENTS);
        Communication.getInstance().posaljiZahtjev(kz);
        ServerskiOdgovor so =Communication.getInstance().primiOdgovor();
        return so;
    }

    public ServerskiOdgovor addAllIngredients(List<Ingredients> ingredients) {
        KlijentskiZahtjev kz = new KlijentskiZahtjev();
        kz.setObjekat(ingredients);
        kz.setOperacija(Operacija.ADD_ALL_INGREDIENTS);
        Communication.getInstance().posaljiZahtjev(kz);
        ServerskiOdgovor so =Communication.getInstance().primiOdgovor();
        return so;
    }

    public List<RawMaterial> getAllRawMaterials() {
        KlijentskiZahtjev kz = new KlijentskiZahtjev();
        kz.setOperacija(Operacija.GET_ALL_RAW_MATERIALS);
        Communication.getInstance().posaljiZahtjev(kz);
        ServerskiOdgovor so =Communication.getInstance().primiOdgovor();
        List<RawMaterial> rawMaterials =(List<RawMaterial>) so.getObject();
        return rawMaterials;
    }

    public ServerskiOdgovor addRawMaterial(RawMaterial rawMaterial) {
        KlijentskiZahtjev kz = new KlijentskiZahtjev();
        kz.setObjekat(rawMaterial);
        kz.setOperacija(Operacija.ADD_RAW_MATERIAL);
        Communication.getInstance().posaljiZahtjev(kz);
        ServerskiOdgovor so =Communication.getInstance().primiOdgovor();
        return so;   
    }

    public List<Supplier> getAllSuppliers() {
        KlijentskiZahtjev kz = new KlijentskiZahtjev();
        kz.setOperacija(Operacija.GET_ALL_SUPPLIERS);
        Communication.getInstance().posaljiZahtjev(kz);
        ServerskiOdgovor so =Communication.getInstance().primiOdgovor();
        List<Supplier> suppliers =(List<Supplier>) so.getObject();
        return suppliers;
    }

    public boolean addAllRawMaterials(List<RawMaterial> rawMaterials) {
        KlijentskiZahtjev kz = new KlijentskiZahtjev();
        kz.setObjekat(rawMaterials);
        kz.setOperacija(Operacija.ADD_ALL_RAW_MATERIALS);
        Communication.getInstance().posaljiZahtjev(kz);
        ServerskiOdgovor so =Communication.getInstance().primiOdgovor();
        return so.isUspjesno();   
    }

    public boolean addSupplier(Supplier supplier) {
        KlijentskiZahtjev kz = new KlijentskiZahtjev();
        kz.setObjekat(supplier);
        kz.setOperacija(Operacija.ADD_SUPPLIER);
        Communication.getInstance().posaljiZahtjev(kz);
        ServerskiOdgovor so =Communication.getInstance().primiOdgovor();
        return so.isUspjesno();   
    }

    public void setCurrentTable(String table1) {
        currentTable = table1;
    }

    public void saveInvoice(Invoice invoice) {
        KlijentskiZahtjev kz = new KlijentskiZahtjev();
        kz.setObjekat(invoice);
        kz.setOperacija(Operacija.SAVE_INVOICE);
        Communication.getInstance().posaljiZahtjev(kz);
        ServerskiOdgovor so =Communication.getInstance().primiOdgovor();
           
    }

    public ServerskiOdgovor addProduct(Product product) {
        KlijentskiZahtjev kz = new KlijentskiZahtjev();
        kz.setObjekat(product);
        kz.setOperacija(Operacija.ADD_PRODUCT);
        Communication.getInstance().posaljiZahtjev(kz);
        ServerskiOdgovor so =Communication.getInstance().primiOdgovor();
        return so;
    }

    public List<Product> getAllBeverageProducts() {
        KlijentskiZahtjev kz = new KlijentskiZahtjev();
        kz.setOperacija(Operacija.GET_ALL_BEVERAE_PRODUCTS);
        Communication.getInstance().posaljiZahtjev(kz);
        ServerskiOdgovor so =Communication.getInstance().primiOdgovor();
        List<Product> products =(List<Product>) so.getObject();
        return products;
    }

    public List<Product> getAllProducts() {
        KlijentskiZahtjev kz = new KlijentskiZahtjev();
        kz.setOperacija(Operacija.GET_ALL_PRODUCTS);
        Communication.getInstance().posaljiZahtjev(kz);
        ServerskiOdgovor so =Communication.getInstance().primiOdgovor();
        List<Product> products =(List<Product>) so.getObject();
        return products;
    }

    public List<Ingredients> getAllIngredients() {
        KlijentskiZahtjev kz = new KlijentskiZahtjev();
        kz.setOperacija(Operacija.GET_ALL_INGREDIENTS);
        Communication.getInstance().posaljiZahtjev(kz);
        ServerskiOdgovor so =Communication.getInstance().primiOdgovor();
        List<Ingredients> ingredients =(List<Ingredients>) so.getObject();
        return ingredients;
    }

    public ServerskiOdgovor updateProductFood(Product ptbu) {
        KlijentskiZahtjev kz = new KlijentskiZahtjev();
        kz.setOperacija(Operacija.UPDATE_PRODUCT_FOOD);
        kz.setObjekat(ptbu);
        Communication.getInstance().posaljiZahtjev(kz);
        ServerskiOdgovor so =Communication.getInstance().primiOdgovor();
        return so;
    }

    public ServerskiOdgovor deleteFoodProduct(Product product) {
        KlijentskiZahtjev kz = new KlijentskiZahtjev();
        kz.setOperacija(Operacija.DELETE_FOOD_PRODUCT);
        kz.setObjekat(product);
        Communication.getInstance().posaljiZahtjev(kz);
        ServerskiOdgovor so =Communication.getInstance().primiOdgovor();
        return so;
    }

    public ServerskiOdgovor deleteBeverageProduct(Product product) {
        KlijentskiZahtjev kz = new KlijentskiZahtjev();
        kz.setOperacija(Operacija.DELETE_BEVERAGE_PRODUCT);
        kz.setObjekat(product);
        Communication.getInstance().posaljiZahtjev(kz);
        ServerskiOdgovor so =Communication.getInstance().primiOdgovor();
        return so;
    }

    public ServerskiOdgovor deleteRawMaterial(RawMaterial rawMaterial) {
         KlijentskiZahtjev kz = new KlijentskiZahtjev();
        kz.setOperacija(Operacija.DELETE_RAW_MATERIAL);
        kz.setObjekat(rawMaterial);
        Communication.getInstance().posaljiZahtjev(kz);
        ServerskiOdgovor so =Communication.getInstance().primiOdgovor();
        return so;
    }
}
