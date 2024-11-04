/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp3;

/**
 *
 * @author romangattas
 */
public class Main7 {
    public static void main(String[] args) {
        
        Turno unT = new Turno();
        Letra a = new Letra('a',3,unT,0);
        Letra b = new Letra('b',3,unT,1);
        Letra c = new Letra('c',3,unT,2);
        
        Thread t1 = new Thread(a);
        Thread t2 = new Thread(b);
        Thread t3 = new Thread(c);
        
        t1.start();
        t2.start();
        t3.start();
    }
}
