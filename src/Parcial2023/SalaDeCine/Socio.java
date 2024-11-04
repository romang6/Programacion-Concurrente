package Parcial2023.SalaDeCine;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Roman
 */
public class Socio implements Runnable{
    private Catalogo cat;
    private char idioma;
    public Socio(Catalogo c, char i){
        cat = c;
        idioma = i;
    }    
    public void run(){
        while(true){
            int nroRandom = (int) (Math.random() * 50) + 1;
            if(idioma =='E'){
                try {
                    cat.verEspaniol(nroRandom);
                    
                    Thread.sleep(15000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Socio.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else if(idioma == 'I'){
                try {
                    cat.verIngles(nroRandom);

                    Thread.sleep(15000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Socio.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }    
}
