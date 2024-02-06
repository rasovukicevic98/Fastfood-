/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ps.view.components;

import java.math.BigDecimal;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import rs.ac.bg.fon.ps.domain.MeasurementUnit;
import rs.ac.bg.fon.ps.domain.RawMaterial;
import rs.ac.bg.fon.ps.domain.Supplier;

/**
 *
 * @author Raso
 */
public class TableModelRawMaterial extends AbstractTableModel{

    List<RawMaterial> rawMaterials;
    private String[] columnNames= new String[]{"ID","Name","Unit","Alarm","supplier"};
    private Class[] columnClass = new Class[]{Long.class, String.class ,MeasurementUnit.class ,Double.class, Supplier.class};

    public TableModelRawMaterial(List<RawMaterial> rawMaterials) {
        this.rawMaterials=rawMaterials;
    }
    @Override
    public int getRowCount() {
        if(rawMaterials==null){
            return 0;
        }else{
            return rawMaterials.size();
        }
    }

    @Override
    public int getColumnCount() {

        return columnNames.length; 
    }
    @Override
    public String getColumnName(int column){
        if(column>columnNames.length){
            return "n/a";
        }else{
            return columnNames[column];
        }
        
        
    }
    @Override
    public Class<?> getColumnClass(int columnIndex){
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
        RawMaterial rawMaterial = rawMaterials.get(rowIndex);
        switch(columnIndex){
            case 0: 
                return rawMaterial.getId();
            case 1:
                return rawMaterial.getName();
            case 2:
                return rawMaterial.getMeasurementUnit();
            case 3:
                return rawMaterial.getAlarm();
            case 4: 
                return rawMaterial.getSupplier();
            default:
                return"m/a";
            
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        RawMaterial rawMaterial = rawMaterials.get(rowIndex);
        
        switch(columnIndex){
            case 0: 
                 rawMaterial.setId((Long)aValue);
                 break;
            case 1:
                rawMaterial.setName(aValue.toString());
                break;
            case 2:
                rawMaterial.setMeasurementUnit((MeasurementUnit)aValue);
                break;
            case 3:
                rawMaterial.setAlarm((Double)aValue);
                break;
            case 4: 
                rawMaterial.setSupplier((Supplier)aValue);
                break;
                
        }

    }
    public void addRawMaterial(RawMaterial rawMaterial){
        
        rawMaterials.add(rawMaterial);
        fireTableRowsInserted(rawMaterials.size()-1, rawMaterials.size()-1);
    }
    
    public void removeRawMaterial(int rowIndex){
        
        rawMaterials.remove(rowIndex);
        fireTableDataChanged();
    }
    
    public List<RawMaterial> getRawMaterials(){
        return rawMaterials;
    }
            
        
    
}
