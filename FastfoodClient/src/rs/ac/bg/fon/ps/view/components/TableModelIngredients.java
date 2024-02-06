/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ps.view.components;

import java.math.BigDecimal;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import rs.ac.bg.fon.ps.domain.Ingredients;
import rs.ac.bg.fon.ps.domain.Invoice;
import rs.ac.bg.fon.ps.domain.InvoiceItem;
import rs.ac.bg.fon.ps.domain.MeasurementUnit;
import rs.ac.bg.fon.ps.domain.Product;
import rs.ac.bg.fon.ps.domain.RawMaterial;
import rs.ac.bg.fon.ps.domain.Supplier;

/**
 *
 * @author Raso
 */
public class TableModelIngredients extends AbstractTableModel{

    //private final Product product;
    private final List <Ingredients> ingredients;
    private String[] columnNames= new String[]{"Product ID","RM ID","Unit","Quantity"};
    private Class[] columnClass= new Class[]{Long.class, Long.class, MeasurementUnit.class, BigDecimal.class};

    
    public TableModelIngredients(List<Ingredients> ingredients) {
        this.ingredients = ingredients;
    }
    
    
    
    @Override
    public int getRowCount() {
        if(ingredients==null){
            return 0;
        }else{
            return ingredients.size();
        }
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int column) {
        if(column>columnNames.length){
            return "n/a";
        }else{
            return columnNames[column];
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if(columnIndex>columnClass.length){
            return Object.class;
        }else{
            return columnClass[columnIndex];
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }
    
    

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Ingredients ingredient=ingredients.get(rowIndex);
        switch(columnIndex){
            case 0:
                return ingredient.getProductID();
            case 1:
                return ingredient.getRawMaterialID();
            case 2:
                return ingredient.getMeasurementUnit();
            case 3:
                return ingredient.getQuantity();
            
            default:
                    return "n/a";
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Ingredients ingredient =ingredients.get(rowIndex);
        switch(columnIndex){
            case 0:
                ingredient.setProductID((Long)aValue);
                break;
            case 1:
                ingredient.setRawMaterialID((Long)aValue);
                break;
            case 2:
                ingredient.setMeasurementUnit((MeasurementUnit)aValue);
                break;
            case 3:
                ingredient.setQuantity((BigDecimal)aValue);
                break;
            
        }
    }
    
    public void addIngredient(Ingredients ingredient){
        ingredients.add(ingredient);
        //fireTableDataChanged();
        fireTableRowsInserted(ingredients.size()-1, ingredients.size()-1);
    }
    
    public void removeIngredient(int rowIndex){
        ingredients.remove(rowIndex);
        fireTableDataChanged();
    }
    
    public List<Ingredients> getIngredients(){
        return ingredients;
    }
}
