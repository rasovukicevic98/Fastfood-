/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package komunikacija;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import kontroler.Controller;
import transfer.KlijentskiZahtjev;
import transfer.ServerskiOdgovor;

/**
 *
 * @author Raso
 */
public class Communication {
    private static Communication instance;
    Socket socket;

    public Communication() {
        try {
            socket = new Socket("localhost",9000);
        } catch (IOException ex) {
            Logger.getLogger(Communication.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public static Communication getInstance(){
        if(instance==null){
            instance=new Communication();
        }
        return instance;
    }
    
    public void posaljiZahtjev(KlijentskiZahtjev kz){
        
        try {
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            out.writeObject(kz);
        } catch (IOException ex) {
            Logger.getLogger(Communication.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public ServerskiOdgovor primiOdgovor(){
        ServerskiOdgovor so=null;
        try {
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            so = (ServerskiOdgovor) in.readObject();
        } catch (IOException ex) {
            Logger.getLogger(Communication.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Communication.class.getName()).log(Level.SEVERE, null, ex);
        }
        return so;
    }
}
