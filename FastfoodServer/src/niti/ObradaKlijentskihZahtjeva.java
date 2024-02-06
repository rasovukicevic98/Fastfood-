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
import rs.ac.bg.fon.ps.controller.Controller;
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
    @Override
    public void run() {
        
        while(true){
            try {
                KlijentskiZahtjev kz = primiZahtjev();
                ServerskiOdgovor so;
                switch(kz.getOperacija()){
                    case Operacija.LOGIN:
                        User user = (User) kz.getObjekat();
                        so= new ServerskiOdgovor();
                        so = Controller.getInstance().login(user);
                        
                        so.setObject(user);
                        
                        posaljiOdgovor(so);
                        break;
                    case Operacija.ADD_RAW_MATERIAL:
                        System.out.println("dodajemo raw material");
                        so = new ServerskiOdgovor();
                        RawMaterial rawMaterial = (RawMaterial) kz.getObjekat();
                        boolean good = Controller.getInstance().addRawMaterial(rawMaterial);
                        if(good){
                            so.setUspjesno(true);
                        }else{
                            so.setUspjesno(false);
                        }
                        so.setObject(rawMaterial);
                        so.setPoruka("Uspjesno ste dodali raw material.\n");
                        posaljiOdgovor(so);
                        break;
                    case Operacija.GET_ALL_SUPPLIERS:
                        System.out.println("Vrcemo sve suppliere");
                        so = new ServerskiOdgovor();
                        List<Supplier> suppliers = Controller.getInstance().getAllSuppliers();
                        so.setObject(suppliers);
                        posaljiOdgovor(so);
                        break;
                    case Operacija.GET_ALL_RAW_MATERIALS:
                        List<RawMaterial> rawMaterials = Controller.getInstance().getAllRawMaterials();
                        so = new ServerskiOdgovor();
                        so.setObject(rawMaterials);
                        posaljiOdgovor(so);
                        break;
                    case Operacija.ADD_ALL_RAW_MATERIALS:
                        so = new ServerskiOdgovor();
                        List<RawMaterial> rawMaterials1 = (List<RawMaterial>) kz.getObjekat();
                        boolean good1 = Controller.getInstance().addAllRawMaterials(rawMaterials1);
                        so.setUspjesno(good1);
                        posaljiOdgovor(so);
                        break;
                    case Operacija.DELETE_RAW_MATERIAL:
                        so = new ServerskiOdgovor();
                        rawMaterial = (RawMaterial) kz.getObjekat();
                        good = Controller.getInstance().deleteRawMaterial(rawMaterial);
                        so.setUspjesno(good);
                        posaljiOdgovor(so);
                        break;
                    case Operacija.ADD_SUPPLIER:
                        so = new ServerskiOdgovor();
                        Supplier supplier = (Supplier) kz.getObjekat();
                        if(Controller.getInstance().addSupplier(supplier)){
                            so.setUspjesno(true);
                        }else{
                            so.setUspjesno(false);
                        }
                        posaljiOdgovor(so);
                        break;
                }
            } catch (Exception ex) {
                Logger.getLogger(ObradaKlijentskihZahtjeva.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
    }
    
    
    public void posaljiOdgovor(ServerskiOdgovor so){
        try {
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            out.writeObject(so);
        } catch (IOException ex) {
            Logger.getLogger(ObradaKlijentskihZahtjeva.class.getName()).log(Level.SEVERE, null, ex);
        }
                
    }
    
    public KlijentskiZahtjev primiZahtjev(){
        KlijentskiZahtjev kz = null;
        try {
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            kz = (KlijentskiZahtjev) in.readObject();
        } catch (IOException ex) {
            Logger.getLogger(ObradaKlijentskihZahtjeva.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ObradaKlijentskihZahtjeva.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kz;
        
    }
    
}
