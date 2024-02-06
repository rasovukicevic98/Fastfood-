/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ps.view.components;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import kontroler.Controller;
import rs.ac.bg.fon.ps.domain.Product;

/**
 *
 * @author Raso
 */
public class TableModelViewProduct extends AbstractTableModel{
    
    List<Product> products;

    public TableModelViewProduct(List<Product> products) {
        this.products = products;
    }

    public TableModelViewProduct() {
        this.products = Controller.getInstance().getAllProducts();
    }
    
    public TableModelViewProduct(Product product){
        products = new ArrayList<>();
    }
    
    
    @Override
    public int getRowCount() {
        return products.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Product product = products.get(rowIndex);
        
        switch(columnIndex){
            case 0: return product.getId();
            case 1: return product.getName();
            case 2: return product.getDescription();
            case 3: return product.getPrice();
            case 4: return product.getMeasurementUnit();
            case 5: return product.getAmount();
            case 6: return product.getSavedByUser();
            
            default: System.out.println("GRESKA"); return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0: return "ID";
            case 1: return "Name";
            case 2: return "Desc";
            case 3: return "Price";
            case 4: return "Unit";
            case 5: return "Amount";
            
            case 6: return "Saved by:";
            default: System.out.println("GRESKA"); return null;
        }
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
    
    
    
}
