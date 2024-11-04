/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP6.Ej4;

/**
 *
 * @author romangattas
 */
public class Productor implements Runnable{
    private Buffer almacen;
    
    
    public Productor(Buffer a){
        almacen = a;
    }
    
    
    public void run(){
        while(true){
            try{
                almacen.agregarProducto();
                Thread.sleep(1000);
                
            }catch(InterruptedException e){
                
                System.out.println("Excepcion capturada.");
            }
        
        }
    
    
    }
}
