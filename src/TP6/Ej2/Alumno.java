
package TP6.Ej2;

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
            sala.retiroEstudiante();
        
        }catch(InterruptedException e){}
        
        
    }

}
