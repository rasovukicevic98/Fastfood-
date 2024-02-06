            /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transfer;

import java.io.Serializable;

/**
 *
 * @author Raso
 */
public class ServerskiOdgovor implements Serializable{
    
    Object object;
    String poruka;
    boolean uspjesno;

    public ServerskiOdgovor() {
    }

    public ServerskiOdgovor(Object object, String poruka, boolean uspjesno) {
        this.object = object;
        this.poruka = poruka;
        this.uspjesno = uspjesno;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public String getPoruka() {
        return poruka;
    }

    public void setPoruka(String poruka) {
        this.poruka = poruka;
    }

    public boolean isUspjesno() {
        return uspjesno;
    }

    public void setUspjesno(boolean uspjesno) {
        this.uspjesno = uspjesno;
    }
    
    
}
