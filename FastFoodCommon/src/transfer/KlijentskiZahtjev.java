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
public class KlijentskiZahtjev implements Serializable{
    Object objekat;
    int Operacija;

    public KlijentskiZahtjev() {
    }

    public Object getObjekat() {
        return objekat;
    }

    public void setObjekat(Object objekat) {
        this.objekat = objekat;
    }

    public int getOperacija() {
        return Operacija;
    }

    public void setOperacija(int Operacija) {
        this.Operacija = Operacija;
    }
    
    
}
