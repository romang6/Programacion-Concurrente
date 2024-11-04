
package TP6.Ej3;

import java.util.concurrent.Semaphore;

/**
 *
 * @author romangattas
 */
public class SalaEstudio {

    private Semaphore mesas;
    
    public SalaEstudio(){
        mesas = new Semaphore(3);
    }
    
    public void ingresarEstudiante()throws InterruptedException{
        
        mesas.acquire();
        System.out.println("El estudiante "+Thread.currentThread().getName()+" ingreso a la sala.");
  
        
    }
    
    public void retirarEstudiante(){
        
        mesas.release();
        System.out.println("El estudiante " +Thread.currentThread().getName()+" se retiro de la sala.");
        
    }
        
    
    
}
