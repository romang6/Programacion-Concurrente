/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ActividadOb;

/**
 *
 * @author romangattas
 */
public class Main {
    public static void main(String[] args) {
        Sala unaSala = new Sala();
        Visitante vis1 = new Visitante('V',"Juan", unaSala);
        Visitante vis2 = new Visitante('V',"Marin", unaSala);
        Visitante vis3 = new Visitante('V',"Gonza", unaSala);
        Visitante vis4 = new Visitante('C',"Sebastian", unaSala);
        Visitante vis5 = new Visitante('R',"Sofia", unaSala);
        Visitante vis6 = new Visitante('C',"Ernesto", unaSala);
        Visitante vis7 = new Visitante('R',"Martina", unaSala);
        
        Thread hilo1 = new Thread(vis1);
        Thread hilo2 = new Thread(vis2);
        Thread hilo3 = new Thread(vis3);
        Thread hilo4 = new Thread(vis4);
        Thread hilo5 = new Thread(vis5);
        Thread hilo6 = new Thread(vis6);
        Thread hilo7 = new Thread(vis7);
        
        hilo1.start();
        
        hilo2.start();
        
        hilo3.start();
        
        hilo4.start();
        
        hilo5.start();
        
        hilo6.start();
        
        hilo7.start();
        
        
    }
}
