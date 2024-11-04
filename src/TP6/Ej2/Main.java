package TP6.Ej2;

/**
 *
 * @author romangattas
 */
public class Main {
    public static void main(String[] args) {
      SalaEstudio sala = new SalaEstudio();
      
      Alumno Sofia = new Alumno(sala);
      Alumno Martin = new Alumno(sala);
      Alumno Pablo = new Alumno(sala);
      Alumno Barbara = new Alumno(sala);
      Alumno Seba = new Alumno(sala);
      
      Thread hilo1 = new Thread(Sofia, "Sofia");
      
      Thread hilo2 = new Thread(Martin, "Martin");
      
      Thread hilo3 = new Thread(Pablo, "Pablo");
      
      Thread hilo4 = new Thread(Barbara, "Barbara");
      
      Thread hilo5 = new Thread(Seba, "Seba");
      

      hilo1.start();
      
      hilo2.start();
      
      hilo3.start();
      
      hilo4.start();
      
      hilo5.start();
      
    }
    
    
    
}
