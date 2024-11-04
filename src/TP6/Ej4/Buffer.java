/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP6.Ej4;

/**
 *
 * @author romangattas
 */
public class Buffer {
    private static final double capacidadMax = Double.MAX_VALUE;//variante almacen ilimitado
                                          // = 20 por ej seria una variante de almacen limitado
    private int capacidadActual;
    
    public Buffer(){
        capacidadActual = 0;
    }
    
    public synchronized void agregarProducto() throws InterruptedException{
        
        while(capacidadActual >= capacidadMax){
            System.out.println(Thread.currentThread().getName()+ " debe esperar para agregar un producto(alamcen lleno)");
            
            this.wait();
        
        }
        
        System.out.println("Productor " +Thread.currentThread().getName()+" agregando producto");
        capacidadActual++;
        this.notifyAll();
        System.out.println("Producto correctamente agregado");
    }
    
    public synchronized void consumirProducto() throws InterruptedException{
        
        while(capacidadActual <= 0){
            
            System.out.println(Thread.currentThread().getName()+" debe esperar para consumir(almacen vacio)");
            
            this.wait();
  
        }
        
        System.out.println("Consumidor " +Thread.currentThread().getName()+" consumiendo producto");
        capacidadActual--;
        this.notifyAll();
        System.out.println("Producto consumido");

    }
    
    
}
