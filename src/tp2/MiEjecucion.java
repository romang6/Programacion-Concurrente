/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp2;

/**
 *
 * @author romangattas
 */
public class MiEjecucion extends Thread{
    public void run() {
        ir();

    }

    public void ir() {
        hacerMas();
    }

    public void hacerMas() {
        System.out.println("En la pila");
    }
}
