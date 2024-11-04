/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp2;

/**
 *
 * @author romangattas
 */
public class ThreadEjRun implements Runnable{
    private String nombre;
    
    public ThreadEjRun(String nom){
        nombre = nom;
    }
    
    public void run(){
         for (int i = 0; i < 10; i++) {
            System.out.println(i + " " + this.nombre);
        }
        System.out.println("Termina thread " + this.nombre);
    }
    
    public static void main(String[] args) {
        //metodos run
        ThreadEjRun r1 = new ThreadEjRun("Maria Jose");
        ThreadEjRun r2 = new ThreadEjRun("Jose Maria");
        
        //creacion de los hilos
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        
        //activacion
        t1.start();;
        t2.start();
        
        
    }
}


