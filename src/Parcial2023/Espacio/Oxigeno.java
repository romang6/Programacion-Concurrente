/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parcial2023.Espacio;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author paula
 */
public class Oxigeno implements Runnable {
    
    private FormacionAgua f;
    
     public Oxigeno(FormacionAgua g){
        this.f=g;
    }
    
    public void run(){
        try {
            f.Olisto();
        } catch (InterruptedException ex) {
            Logger.getLogger(Oxigeno.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
