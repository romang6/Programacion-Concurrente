
package TP6.Ej3;

/**
 *
 * @author romangattas
 */
public class Alumno implements Runnable{
    private SalaEstudio sala;
    
    public Alumno(SalaEstudio s){
        sala = s;
    }
    
    
    public void run(){
        try{
            sala.ingresarEstudiante();
            Thread.sleep(5000);
            sala.retirarEstudiante();
        
        }catch(InterruptedException e){}
        
        
    }
}
