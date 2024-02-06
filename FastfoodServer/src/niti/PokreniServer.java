package niti;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Raso
 */
public class PokreniServer extends Thread{
    Socket socket;
    @Override
    public void run() {
        try {
            ServerSocket ss = new ServerSocket(9000);
            while (true) {                
                socket = ss.accept();
                System.out.println("Klijent se povezao na server");
                ObradaKlijentskihZahtjeva okz = new ObradaKlijentskihZahtjeva(socket);
                okz.start();
            }
        } catch (IOException ex) {
            Logger.getLogger(PokreniServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
}
