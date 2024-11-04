/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP6.Ej4;

/**
 *
 * @author romangattas
 */
public class Consumidor implements Runnable{
    Buffer almacen;
    
    public Consumidor(Buffer a){
        almacen = a;
    }
    
    
    public void run(){
        while(true){
            try{
                almacen.consumirProducto();
                Thread.sleep(500);
                
            }catch(InterruptedException e){
                
                System.out.println("Excepcion capturada.");
            }
        
        }
    
    
    }
}
