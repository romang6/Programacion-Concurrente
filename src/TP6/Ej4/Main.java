/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP6.Ej4;

/**
 *
 * @author romangattas
 */
public class Main {
    
    
    public static void main(String[] args) {
        Buffer almacen = new Buffer();
        
        Consumidor c1 = new Consumidor(almacen);
        Productor p1 = new Productor(almacen);
        
         Consumidor c2 = new Consumidor(almacen);
        Productor p2 = new Productor(almacen);
        
         Consumidor c3 = new Consumidor(almacen);
        Productor p3 = new Productor(almacen);
        
        Thread hilo1 = new Thread(c1, "Raul");
        Thread hilo2 = new Thread(p1, "Sofia");
        
        
        Thread hilo3 = new Thread(c2, "Barbara");
        Thread hilo4 = new Thread(p2, "Sebastian");
        
        
        
        Thread hilo5 = new Thread(c3, "Mau");
        Thread hilo6 = new Thread(p3, "Pau");
        
        
        hilo1.start();
        hilo2.start();
        
        hilo3.start();
        hilo4.start();
        
        hilo5.start();
        hilo6.start();
        
    }
}
