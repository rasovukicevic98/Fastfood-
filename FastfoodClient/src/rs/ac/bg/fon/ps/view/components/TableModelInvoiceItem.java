/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ps.view.components;

import java.math.BigDecimal;
import javax.swing.table.AbstractTableModel;
import rs.ac.bg.fon.ps.domain.Invoice;
import rs.ac.bg.fon.ps.domain.InvoiceItem;
import rs.ac.bg.fon.ps.domain.Product;

/**
 *
 * @author Raso
 */
public class TableModelInvoiceItem extends AbstractTableModel{

    private String [] columnNames = new String[]{"Product", "Quantity", "Price","Total"};
    private  Invoice invoice;

    public TableModelInvoiceItem(Invoice invoice) {
        this.invoice = invoice;
    }

    @Override
    public int getRowCount() {
        return invoice.getItems().size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }
    
    

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
     InvoiceItem invoiceItem = invoice.getItems().get(rowIndex);
        
        switch (columnIndex) {
            
            case 0:
                return invoiceItem.getProduct().getName();
            case 1:
                return invoiceItem.getQuantity();
            case 2:
                return invoiceItem.getProduct().getPrice();
            case 3:
                return invoiceItem.getTotal();
            case 4:
                return invoiceItem.getQuantity();
            case 5:
                return invoiceItem.getTotal();
            default:
                return "n/a";            
        }
    }

    public Invoice getInvoice() {
        return invoice;
    }
    
    public void addItem(Product product, BigDecimal quantity, BigDecimal price) {
        
        InvoiceItem item = new InvoiceItem();
      //  item.setOrderNumber(invoice.getItems().size() + 1);
        for (InvoiceItem item1 : invoice.getItems()) {
            if(item1.getProduct().equals(product)){
                
                item1.setQuantity(item1.getQuantity().add(new BigDecimal("1")));
                item1.setTotal(item1.getTotal().add(item1.getProduct().getPrice()));
                fireTableDataChanged();
                return;
            }
        }
        item.setProduct(product);
        
        item.setQuantity(quantity);
        
        item.setTotal(item.getQuantity().multiply(product.getPrice()));
        item.setInvoice(invoice);
        invoice.getItems().add(item);
//        invoice.setTotal(invoice.getTotal().add(item.getPrice().multiply(item.getQuantity())));
        fireTableRowsInserted(invoice.getItems().size() - 1, invoice.getItems().size() - 1);
        
    } 
    
    public void removeInvoiceItem(int rowIndex) {
        InvoiceItem item = invoice.getItems().get(rowIndex);
        invoice.getItems().remove(rowIndex);
       // invoice.setTotal(invoice.getTotal().subtract(item.getPrice().multiply(item.getQuantity())));
     //   setOrderNumbers();
     fireTableDataChanged();
        //fireTableRowsDeleted(invoice.getItems().size() - 1, invoice.getItems().size() - 1);
    }

    private void setOrderNumbers() {
        int orderNo = 0;
//        for (InvoiceItem item : invoice.getItems()) {
//            item.(++orderNo);
//        }
    }
     
    public void editInvoiceItem(InvoiceItem item, int row) {
      //  item.setTotal(item.getQuantity().multiply(item.getPrice()));
        this.invoice.getItems().set(row, item);
        fireTableRowsUpdated(row, row);
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }
    
    public InvoiceItem getDataForRow(int row) {
        return this.invoice.getItems().get(row);
    }

}
