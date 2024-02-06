/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ps.view.form;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.LayoutManager;
import java.awt.ScrollPane;
import java.math.BigDecimal;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.border.Border;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.table.TableModel;
import kontroler.Controller;
import rs.ac.bg.fon.ps.domain.Invoice;
import rs.ac.bg.fon.ps.domain.InvoiceItem;
import rs.ac.bg.fon.ps.domain.Product;
import rs.ac.bg.fon.ps.view.components.TableModelInvoiceItem;

/**
 *
 * @author Raso
 */
public class FrmNewInvoice implements Runnable{
     public static void main(String[] args) {
        SwingUtilities.invokeLater(new FrmNewInvoice());
    }
    private String tableNumber;
    private JFrame frame;
    private List<Product> products;
    private JPanel buttonPanel;
    private JPanel inputPanel;
    private JButton buttonPice;
    private JButton buttonHrana;
    private JTextField buttonCountField;
    JTable tabela;
    TableModelInvoiceItem tmii;
    JLabel total;
    List<InvoiceItem> invoiceItems;
    int tableNumberToReset;
    Invoice invoice;
    @Override
    public void run() {
        
        frame = new JFrame("Button Grid");
        JPanel mainPanel = new JPanel(new BorderLayout());
       mainPanel.setName("Main invoice panel");
         JTextArea total = new JTextArea("Total:");
         total.setWrapStyleWord(true);
         total.setPreferredSize(new Dimension(40, 100));
       // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //products = kontroler.Controller.getInstance().getAllProducts();
        this.inputPanel = createInputPanel();
        mainPanel.add(total);
         mainPanel.add(inputPanel,BorderLayout.WEST);
      //  frame.add(inputPanel, BorderLayout.BEFORE_FIRST_LINE);
      
        this.buttonPanel = createButtonPanel(30);
        mainPanel.add(buttonPanel, BorderLayout.CENTER);
    //    frame.add(buttonPanel, BorderLayout.CENTER);
        frame.setPreferredSize(new Dimension(1900, 1000));
        frame.add(mainPanel);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }
    
    private JPanel createInputPanel() {
        JPanel panel = new JPanel(new GridLayout());
        
        panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        JButton buttonPice = new JButton("Beverages");
        JButton buttonHrana = new JButton("Food");
        JPanel inputPanel = new JPanel();
        inputPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        inputPanel.add(buttonHrana);
        inputPanel.add(buttonPice);
        JLabel totalString = new JLabel("Total price:");
        total = new JLabel();
        total.setText("0");
        
        JButton removeButton = new JButton("Remove item");
        JButton confirmOrder = new JButton("Confirm order");
        JButton finalReceipt = new JButton("Final receipt");
        inputPanel.add(totalString);
        inputPanel.add(total);
        inputPanel.add(removeButton);
        inputPanel.add(confirmOrder);
        inputPanel.add(finalReceipt);
//        JLabel label = new JLabel("How many buttons? (1 - 30):");
//        inputPanel.add(label);
        
//        buttonCountField = new JTextField(5);
//        inputPanel.add(buttonCountField);
        
        panel.add(inputPanel, BorderLayout.SOUTH);
//        
//        JButton button = new JButton("Submit");
//        panel.add(button, BorderLayout.AFTER_LAST_LINE);
        JTextArea total = new JTextArea("Total: 0");
        total.setWrapStyleWord(true);
        total.setEditable(false);
        
        
        invoice = new Invoice();
        tabela = new JTable();
        String currentTable = Controller.getInstance().getCurrentTable();
        currentTable = currentTable.substring(5);
        int tableNumber = Integer.valueOf(currentTable);
        tableNumberToReset = tableNumber;
        System.out.println("Trentno obradjujemo STO BROJ: "+tableNumber);
        
        Invoice[] invoices =Controller.getInstance().getInvoicePerTable();
        Invoice invoice = invoices[tableNumber];
        tmii = new TableModelInvoiceItem(invoice);        
        tabela.setModel(tmii);
        
        total();
        JScrollPane scrollPane = new JScrollPane(tabela);
        
        
        panel.add(new JScrollPane(tabela),BorderLayout.CENTER);
      //  panel.add(total);
        //panel.add(totalPrice);
        
     //   panel.add(new JScrollPane(tabela),BorderLayout.EAST);
        
        finalReceipt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                invoice.setTotal(total());
                Controller.getInstance().saveInvoice(invoice);
                JOptionPane.showMessageDialog(frame, "Amount to charge:\n"+total()+"Invoice successfully created");
                Invoice newInvoice = new Invoice();
                
                Controller.getInstance().saveTableOrder(newInvoice, tableNumberToReset);
                frame.dispose();
                
            }
        });
     
        confirmOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                String currentTable = Controller.getInstance().getCurrentTable();
                currentTable = currentTable.substring(5);
                int tableNumber = Integer.valueOf(currentTable);
                invoice.setTotal(total());
                kontroler.Controller.getInstance().saveTableOrder(invoice, tableNumber);
           //     System.out.println("Pokusavamo da sacuvamo invoice sa itemima: "+invoice.getItems().get(0).getProduct().getName()+" "+invoice.getItems().get(1).getProduct().getName());
                Invoice[] invoicess = Controller.getInstance().getInvoicePerTable();
          //      System.out.println(invoicess[1].getItems().get(0).getProduct().getName());
                total.setText(String.valueOf(total()));
                
                
            }
        });
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int izbrisi = tabela.getSelectedRow();
               
                substract(tmii.getInvoice().getItems().get(izbrisi));
                tmii.removeInvoiceItem(izbrisi);
                //total();
                
            }
        });
        buttonPice.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                    createButtonsBeverage(buttonPanel, Controller.getInstance().getAllBeverageProducts().size());
                    
                
            }
            
            private int valueOf(String number) {
                try {
                    return Integer.valueOf(number);
                } catch (NumberFormatException e) {
                    return -1;
                }
            }
        });
        buttonHrana.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                    createButtonsFood(buttonPanel, Controller.getInstance().getAllFoodProducts().size());
                    
                
            }
            
            private int valueOf(String number) {
                try {
                    return Integer.valueOf(number);
                } catch (NumberFormatException e) {
                    return -1;
                }
            }
        }
        );
        
        return panel;
    }
    
    private JPanel createButtonPanel(int count) {
        
        JPanel panel = new JPanel(new GridLayout(20,20,5,5));
       // JPanel panel = new JPanel(new GridLayout(3, 3, 5, 5));
        panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
       // createButtons(panel, 3);
        
        return panel;
    }
    
    public void createButtonsFood(JPanel panel, int count) {
        panel.removeAll();
        products = kontroler.Controller.getInstance().getAllFoodProducts();
        for (int index = 0; index < products.size(); index++) {
            JTextArea lbutton = new JTextArea(products.get(index).getName());
            JButton button = new JButton(products.get(index).getName());
            button.setName(products.get(index).getName());
            button.setText(products.get(index).getName());
            button.setPreferredSize(new Dimension(140,40));
            lbutton.setBackground(Color.red);
            lbutton.setLineWrap(true);
            lbutton.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            Dimension VEL = new Dimension(40, 40);
            lbutton.setMaximumSize(VEL);
            
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println(e.getSource());
                    JButton dugmic = (JButton) e.getSource();
                    System.out.println("Korisnik je kliknuo na duygme ");
                    Product addedProduct =null;
                    for (Product product : products) {
                        if(product.getName().equals(dugmic.getName())){
                            addedProduct=product;
                        }
                        
                    }
                    BigDecimal jedinica = new BigDecimal("1.0");
                    try {
                         tmii.addItem(addedProduct, jedinica, addedProduct.getPrice());
                         BigDecimal ukupno = new BigDecimal(total.getText().trim());
                         total.setText(String.valueOf(ukupno.add(addedProduct.getPrice())));
                         total();
                        
                    } catch (Exception ex) {
                      //  JOptionPane.showMessageDialog(this, "GRESKA PRILIKOM DODAVANJA U TABELU");
                        System.out.println("gRESKA ORILIKOM DODAVANJA U TABELU");
                        throw ex;
                    }
                   
                    
                }
            });
            
                    
            panel.add(button);
        }
        
        panel.validate();
        panel.repaint();
    }
    public void createButtonsBeverage(JPanel panel, int count) {
        panel.removeAll();
        products = kontroler.Controller.getInstance().getAllBeverageProducts();
        for (int index = 0; index < products.size(); index++) {
            JTextArea lbutton = new JTextArea(products.get(index).getName());
            JButton button = new JButton(products.get(index).getName());
            button.setName(products.get(index).getName());
            button.setText(products.get(index).getName());
            button.setPreferredSize(new Dimension(140,40));
            lbutton.setBackground(Color.red);
            lbutton.setLineWrap(true);
            lbutton.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            Dimension VEL = new Dimension(40, 40);
            lbutton.setMaximumSize(VEL);
            
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println(e.getSource());
                    JButton dugmic = (JButton) e.getSource();
                    System.out.println("Korisnik je kliknuo na duygme ");
                    Product addedProduct =null;
                    for (Product product : products) {
                        if(product.getName().equals(dugmic.getName())){
                            addedProduct=product;
                        }
                        
                    }
                    BigDecimal jedinica = new BigDecimal("1.0");
                    try {
                         tmii.addItem(addedProduct, jedinica, addedProduct.getPrice());
                         BigDecimal ukupno = new BigDecimal(total.getText().trim());
                         total.setText(String.valueOf(ukupno.add(addedProduct.getPrice())));
                         total();
                        
                    } catch (Exception ex) {
                      //  JOptionPane.showMessageDialog(this, "GRESKA PRILIKOM DODAVANJA U TABELU");
                        System.out.println("gRESKA ORILIKOM DODAVANJA U TABELU");
                        throw ex;
                    }
                   
                    
                }
            });
            
                    
            panel.add(button);
        }
        
        panel.validate();
        panel.repaint();
    }    
    

    private BigDecimal total() {
        BigDecimal ukupno = new BigDecimal("0");
        for (InvoiceItem item : tmii.getInvoice().getItems()) {
            System.out.println("PRoduct:"+item.getProduct());
            ukupno = ukupno.add(item.getTotal());
        }
        System.out.println(ukupno);
        total.setText(String.valueOf(ukupno));
        invoice.setTotal(ukupno);
        return ukupno;
    }
    
    private void substract(InvoiceItem item){
        BigDecimal ukupno = new BigDecimal(total.getText());
        ukupno = ukupno.subtract(item.getTotal());
        total.setText(String.valueOf(ukupno));
        
    }
}
