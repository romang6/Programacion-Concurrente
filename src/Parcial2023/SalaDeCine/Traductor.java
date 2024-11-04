package Parcial2023.SalaDeCine;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Roman
 */
public class Traductor implements Runnable{
    private Catalogo cat;
    public Traductor(Catalogo c){
        cat = c;
    }
    public void run(){
        while(true){
            try {

                cat.empezarAtraducir();
                Thread.sleep(5000);
                cat.terminarDeTraducir();
                
            } catch (InterruptedException ex) {
                Logger.getLogger(Traductor.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }    
}
