/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ps.view.form;

import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import kontroler.Controller;

import rs.ac.bg.fon.ps.domain.Product;

/**
 *
 * @author Raso
 */
public class FrmMain extends javax.swing.JFrame {
    Image img;
    /**
     * Creates new form FrmMain
     */
    public FrmMain() {
        initComponents();
        validateForm();
        
   }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        table1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jmenuRawMateral = new javax.swing.JMenu();
        jmiRawMaterialNew = new javax.swing.JMenuItem();
        jmiRawMaterialView = new javax.swing.JMenuItem();
        jmiRawMaterialNewList = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jmenuSupplier = new javax.swing.JMenu();
        jmenuAddSupplier = new javax.swing.JMenuItem();
        jmenuViewSuppliers = new javax.swing.JMenuItem();
        jmenuProduct = new javax.swing.JMenu();
        jmiNewProduct = new javax.swing.JMenuItem();
        jmiFindByName = new javax.swing.JMenuItem();
        jmiViewAllProducts = new javax.swing.JMenuItem();
        jmiIngredients = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        jMenuItem2.setText("jMenuItem2");

        jMenu1.setText("File");
        jMenuBar2.add(jMenu1);

        jMenu3.setText("Edit");
        jMenuBar2.add(jMenu3);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("This is main form");

        table1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        table1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        table1.setText("1");
        table1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        table1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table1MouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("2");
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("3");
        jLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("4");
        jLabel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("5");
        jLabel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });

        jmenuRawMateral.setText("Raw material");

        jmiRawMaterialNew.setText("New Raw material");
        jmiRawMaterialNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiRawMaterialNewActionPerformed(evt);
            }
        });
        jmenuRawMateral.add(jmiRawMaterialNew);

        jmiRawMaterialView.setText("View raw materials");
        jmiRawMaterialView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiRawMaterialViewActionPerformed(evt);
            }
        });
        jmenuRawMateral.add(jmiRawMaterialView);

        jmiRawMaterialNewList.setText("New List");
        jmiRawMaterialNewList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiRawMaterialNewListActionPerformed(evt);
            }
        });
        jmenuRawMateral.add(jmiRawMaterialNewList);

        jMenuItem4.setText("Delete raw material");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jmenuRawMateral.add(jMenuItem4);

        jMenuBar1.add(jmenuRawMateral);

        jmenuSupplier.setText("Supplier");

        jmenuAddSupplier.setText("Add Supplier");
        jmenuAddSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmenuAddSupplierActionPerformed(evt);
            }
        });
        jmenuSupplier.add(jmenuAddSupplier);

        jmenuViewSuppliers.setText("View Suppliers");
        jmenuViewSuppliers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmenuViewSuppliersActionPerformed(evt);
            }
        });
        jmenuSupplier.add(jmenuViewSuppliers);

        jMenuBar1.add(jmenuSupplier);

        jmenuProduct.setText("Product");

        jmiNewProduct.setText("New product");
        jmiNewProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiNewProductActionPerformed(evt);
            }
        });
        jmenuProduct.add(jmiNewProduct);

        jmiFindByName.setText("Find by name");
        jmiFindByName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiFindByNameActionPerformed(evt);
            }
        });
        jmenuProduct.add(jmiFindByName);

        jmiViewAllProducts.setText("View all products");
        jmiViewAllProducts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiViewAllProductsActionPerformed(evt);
            }
        });
        jmenuProduct.add(jmiViewAllProducts);

        jmiIngredients.setText("Edit product");
        jmiIngredients.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiIngredientsActionPerformed(evt);
            }
        });
        jmenuProduct.add(jmiIngredients);

        jMenuItem3.setText("Delete product");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jmenuProduct.add(jMenuItem3);

        jMenuBar1.add(jmenuProduct);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(table1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(65, 65, 65)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(172, 172, 172)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(65, 65, 65)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 569, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(table1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(61, 61, 61)
                .addComponent(jLabel6)
                .addContainerGap(383, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmiRawMaterialNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiRawMaterialNewActionPerformed
        
    }//GEN-LAST:event_jmiRawMaterialNewActionPerformed

    private void jmiRawMaterialViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiRawMaterialViewActionPerformed
            
    }//GEN-LAST:event_jmiRawMaterialViewActionPerformed

    private void jmenuAddSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmenuAddSupplierActionPerformed
    }//GEN-LAST:event_jmenuAddSupplierActionPerformed

    private void jmenuViewSuppliersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmenuViewSuppliersActionPerformed
    }//GEN-LAST:event_jmenuViewSuppliersActionPerformed

    private void jmiRawMaterialNewListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiRawMaterialNewListActionPerformed
    
    }//GEN-LAST:event_jmiRawMaterialNewListActionPerformed

    private void jmiNewProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiNewProductActionPerformed
        
       
    }//GEN-LAST:event_jmiNewProductActionPerformed

    private void jmiFindByNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiFindByNameActionPerformed

    }//GEN-LAST:event_jmiFindByNameActionPerformed

    private void table1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table1MouseClicked
        
        
    }//GEN-LAST:event_table1MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jmiViewAllProductsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiViewAllProductsActionPerformed
        
    }//GEN-LAST:event_jmiViewAllProductsActionPerformed

    private void jmiIngredientsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiIngredientsActionPerformed
        
    }//GEN-LAST:event_jmiIngredientsActionPerformed

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
       
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
       
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed

    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
       
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jmenuAddSupplier;
    private javax.swing.JMenu jmenuProduct;
    private javax.swing.JMenu jmenuRawMateral;
    private javax.swing.JMenu jmenuSupplier;
    private javax.swing.JMenuItem jmenuViewSuppliers;
    private javax.swing.JMenuItem jmiFindByName;
    private javax.swing.JMenuItem jmiIngredients;
    private javax.swing.JMenuItem jmiNewProduct;
    private javax.swing.JMenuItem jmiRawMaterialNew;
    private javax.swing.JMenuItem jmiRawMaterialNewList;
    private javax.swing.JMenuItem jmiRawMaterialView;
    private javax.swing.JMenuItem jmiViewAllProducts;
    private javax.swing.JLabel table1;
    // End of variables declaration//GEN-END:variables

    private void validateForm() {
        if(!Controller.getInstance().getUlogovaniUser().getUsername().equals("admin")){
            jmenuProduct.setEnabled(false);
            jmenuRawMateral.setEnabled(false);
            jmenuSupplier.setEnabled(false);
        }
    }
}
