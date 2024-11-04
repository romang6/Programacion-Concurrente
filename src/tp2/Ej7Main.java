/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp2;

/**
 *
 * @author romangattas
 */
public class Ej7Main {
    public static void main(String[] args) {
        
        Cliente7 cliente1 = new Cliente7("Cliente 1", new int[] {2, 2, 1, 5, 2, 3 });
        Cliente7 cliente2 = new Cliente7("Cliente 2", new int[] { 1, 3, 5, 1, 1 });
        Cajero cajero1 = new Cajero("Cajero 1");
        
        // Tiempo inicial de referencia
        long initialTime = System.currentTimeMillis();
        cajero1.procesarCompra(cliente1, initialTime);
        cajero1.procesarCompra(cliente2, initialTime);
    
    }
    
}
