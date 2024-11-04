package TP5.Ej3;

/**
 *
 * @author romangattas
 */
public class Main {
    public static void main(String[] args) {
        
        Comedor unComedor = new Comedor();
        
        Animal a1 = new Animal("Gaspar",'P',unComedor);
        
        Animal a2 = new Animal("Duko",'G',unComedor);
        
        Animal a3 = new Animal("Garra", 'G', unComedor);
        
        Animal a4 = new Animal("Pepa",'P', unComedor);
        
        Animal a5 = new Animal("Perla",'G',unComedor);
        
        Animal a6 = new Animal("Luna",'P',unComedor);
        
        Animal a7 = new Animal("Flopi", 'P', unComedor);
        
        Thread hilo1 = new Thread(a1);
        Thread hilo2 = new Thread(a2);
        Thread hilo3 = new Thread(a3);
        Thread hilo4 = new Thread(a4);
        Thread hilo5 = new Thread(a5);
        Thread hilo6 = new Thread(a6);
        Thread hilo7 = new Thread(a7);
        
        hilo1.start();
        hilo2.start();
        hilo3.start();
        hilo4.start();
        hilo5.start();
        hilo6.start();
        hilo7.start();
    }
}
