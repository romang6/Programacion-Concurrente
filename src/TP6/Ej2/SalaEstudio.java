
package TP6.Ej2;

/**
 *
 * @author romangattas
 */
import lineales.dinamicas.Cola;
public class SalaEstudio {

    private static final int cantMesas = 3;
    private int mesasOcupadas;
    private Cola colaEspera;
    
    public SalaEstudio(){
        mesasOcupadas = 0;
        colaEspera = new Cola();
    }
    
    
    public synchronized void ingresarEstudiante() throws InterruptedException{
        colaEspera.poner(Thread.currentThread());//agrega el hilo a la cola para luego salir en orden
        while(mesasOcupadas >= cantMesas || !(colaEspera.obtenerFrente().equals(Thread.currentThread()))){
            System.out.println(Thread.currentThread().getName()+" debe esperar para entrar.");
            this.wait();
        }     
        colaEspera.sacar();
        System.out.println(Thread.currentThread().getName()+" ingreso a la sala.");
        mesasOcupadas++;
        
    }
    
    public synchronized void retiroEstudiante() throws InterruptedException{
        System.out.println(Thread.currentThread().getName()+" se retira de la sala.");
        mesasOcupadas--;
        this.notifyAll();
    
    }
}
