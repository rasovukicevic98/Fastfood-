/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package niti;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import rs.ac.bg.fon.ps.domain.Ingredients;
import rs.ac.bg.fon.ps.domain.Invoice;
import rs.ac.bg.fon.ps.domain.Product;
import rs.ac.bg.fon.ps.domain.RawMaterial;
import rs.ac.bg.fon.ps.domain.Supplier;
import rs.ac.bg.fon.ps.domain.User;
import transfer.KlijentskiZahtjev;
import transfer.Operacija;
import transfer.ServerskiOdgovor;

/**
 *
 * @author Raso
 */
public class ObradaKlijentskihZahtjeva extends Thread{

    Socket socket;

    public ObradaKlijentskihZahtjeva(Socket socket) {
        this.socket = socket;
    }
    
    
}
