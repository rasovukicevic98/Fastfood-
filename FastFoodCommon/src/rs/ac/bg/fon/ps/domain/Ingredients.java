/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ps.domain;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author Raso
 */
public class Ingredients implements Serializable{
    
    Long productID;
    Long rawMaterialID;
    BigDecimal quantity;
    MeasurementUnit measurementUnit;

    public Ingredients() {
    }

    
    
    public Long getProductID() {
        return productID;
    }

    public void setProductID(Long productID) {
        this.productID = productID;
    }

    public Long getRawMaterialID() {
        return rawMaterialID;
    }

    public void setRawMaterialID(Long rawMaterialID) {
        this.rawMaterialID = rawMaterialID;
    }

   

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public MeasurementUnit getMeasurementUnit() {
        return measurementUnit;
    }

    public void setMeasurementUnit(MeasurementUnit measurementUnit) {
        this.measurementUnit = measurementUnit;
    }

    public Ingredients get(int rowIndex) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    

    
    
    
}
