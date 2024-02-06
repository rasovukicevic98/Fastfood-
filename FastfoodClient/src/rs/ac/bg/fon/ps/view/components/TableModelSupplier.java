/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ps.view.components;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import rs.ac.bg.fon.ps.domain.Supplier;

/**
 *
 * @author Raso
 */
public class TableModelSupplier extends AbstractTableModel{
    List<Supplier> suppliers = kontroler.Controller.getInstance().getAllSuppliers();
    
    @Override
    public int getRowCount() {
        return suppliers.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Supplier supplier = suppliers.get(rowIndex);
        switch(columnIndex){
            case 0: return supplier.getId();
            case 1: return supplier.getName();
            default: return "GRESKA!";
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0: return "ID";
            case 1: return "Name";
            default: return "GRESKA";
        }
    }
    
    
    
}
