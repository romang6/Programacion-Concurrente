/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp2;

/**
 *
 * @author romangattas
 */
public class Corredor implements Runnable{
    private String nombre;
    private double dist;
    
    public Corredor(String nom){
        nombre = nom;
    }
    
    public void run(){
        for (int i = 0; i < 100; i++) {
        
            dist += (int) (Math.random() * 10) + 1;
            System.out.println("Corredor: " + this.nombre + "- Distancia recorrida " +this.dist);
            try { 
                Thread.sleep(100);
            }catch(InterruptedException e){

            }
        
        }
        
    }
    
    public double getDistancia(){
        return dist;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    
}
