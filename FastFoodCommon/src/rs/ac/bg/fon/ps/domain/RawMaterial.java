/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ps.domain;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Raso
 */
public class RawMaterial implements Serializable{
    private Long id;
    
    private String name;
    private MeasurementUnit measurementUnit;
    private double  alarm;
    private Supplier supplier;
    private User savedByUser;

    public RawMaterial(Long id, String name, MeasurementUnit measurementUnit, double alarm, Supplier supplier, User savedByUser) {
        this.id = id;
        this.name = name;
        this.measurementUnit = measurementUnit;
        this.alarm = alarm;
        this.supplier = supplier;
        this.savedByUser = savedByUser;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }
    
    

    
    
    
    
    

    public User getSavedByUser() {
        return savedByUser;
    }

    public void setSavedByUser(User savedByUser) {
        this.savedByUser = savedByUser;
    }
    

    public RawMaterial() {
    }

    

    public double getAlarm() {
        return alarm;
    }

    public void setAlarm(double alarm) {
        this.alarm = alarm;
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

    public MeasurementUnit getMeasurementUnit() {
        return measurementUnit;
    }

    public void setMeasurementUnit(MeasurementUnit measurementUnit) {
        this.measurementUnit = measurementUnit;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id);
        hash = 97 * hash + Objects.hashCode(this.name);
        hash = 97 * hash + Objects.hashCode(this.measurementUnit);
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.alarm) ^ (Double.doubleToLongBits(this.alarm) >>> 32));
        hash = 97 * hash + Objects.hashCode(this.savedByUser);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final RawMaterial other = (RawMaterial) obj;
        if (Double.doubleToLongBits(this.alarm) != Double.doubleToLongBits(other.alarm)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (this.measurementUnit != other.measurementUnit) {
            return false;
        }
        if (!Objects.equals(this.savedByUser, other.savedByUser)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return name;
    }
    
    
    
}
