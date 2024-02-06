 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ps.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author Raso
 */
public class Product implements Serializable{
    
    
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private MeasurementUnit measurementUnit;
    private User savedByUser;
    private List<RawMaterial> rawMaterials;
    List<Ingredients> ingredients;
    public BigDecimal amount;
    private boolean isItFood;
    public BigDecimal getAmount() {
        return amount;
    }

    public List<Ingredients> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredients> ingredients) {
        this.ingredients = ingredients;
    }
    
    

    public boolean isIsItFood() {
        return isItFood;
    }

    public void setIsItFood(boolean isItFood) {
        this.isItFood = isItFood;
    }
    
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
    
    
    //private List<Ingredients> ingredients;

    public Product(Long id, String name, String description, BigDecimal price, MeasurementUnit measurementUnit, User savedByUser, BigDecimal amount) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.measurementUnit = measurementUnit;
        this.savedByUser = savedByUser;
        
        this.amount = amount;
    }
    
    
    
    public Product(Long id, String name, String description, BigDecimal price, MeasurementUnit measurementUnit, User savedByUser) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.measurementUnit = measurementUnit;
        this.savedByUser = savedByUser;
    }

    public Product() {
    }

    

   
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public MeasurementUnit getMeasurementUnit() {
        return measurementUnit;
    }

    public void setMeasurementUnit(MeasurementUnit measurementUnit) {
        this.measurementUnit = measurementUnit;
    }

    
    public User getSavedByUser() {
        return savedByUser;
    }

    public void setSavedByUser(User savedByUser) {
        this.savedByUser = savedByUser;
    }

    @Override
    public String toString() {
        return name;
    }

    public List<RawMaterial> getItems() {
        return rawMaterials;
    }
    
    //public List<Ingredients> getItemsI(){
      //  return ingredients;
   // }

    
    
    
}
