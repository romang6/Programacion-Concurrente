
package ActividadOb;

/**
 *
 * @author romangattas
 */
public class Visitante implements Runnable{
    private char tipo;
    private String nombre;
    private Sala unaSala;
    
    public Visitante(char t, String nom, Sala s){
        tipo = t;
        nombre = nom;
        unaSala = s;
    }
    
    public void run(){
        int i =0;
        while(i<2){
            switch(this.tipo){
            
                case 'V':
                    unaSala.ingresarVisitante(this.nombre);
                    
                    try{
                        Thread.sleep(5000);
                    }catch(InterruptedException e){}
                    
                    unaSala.retiroSala(tipo, nombre);
                    
                    break;
                    
                case 'R':
                    unaSala.ingresarResponsable(this.nombre);
                    
                    try{
                        Thread.sleep(10000);
                    }catch(InterruptedException e){}
                    
                    unaSala.retiroSala(tipo, nombre);
                    
                    break;
                    
                case 'C':
                    unaSala.ingresarCritico(this.nombre);
                    
                    try{
                        Thread.sleep(7000);
                    }catch(InterruptedException e){}
                    
                    unaSala.retiroSala(tipo, nombre);
                    
                    break;
            }
            i++;
        }
    }
}
