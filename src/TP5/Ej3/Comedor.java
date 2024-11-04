/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP5.Ej3;

import java.util.concurrent.Semaphore;

/**
 *
 * @author romangattas
 */
public class Comedor {
    private Semaphore platos;
    private static final int capacidad = 2;
    private int ocupacion;
    private char permisoActual;
    
    public Comedor(){
        platos = new Semaphore(2);
        ocupacion = 0;
        permisoActual = 'N'; 
    }
    
            
    public boolean comerPerro(String nom) throws InterruptedException{
        boolean res = true;
        if(permisoPerros()){
            if(ocupacion == 0){
                permisoActual = 'P';
            }
            if(platos.tryAcquire()){
                
                ocupacion++;
                System.out.println("El perro "+nom+" esta comiendo.");
                Thread.sleep(5000);
                
                if(ocupacion == capacidad-1){ //si es el ultimo perro antes de dejar el comedor
                    permisoActual = 'N';
                }
                res = false;
                platos.release();
                
            }else{
                System.out.println("El perro "+nom+" no consiguio un plato disponible.");
            }
            
        }else{
            System.out.println("El perro "+nom+" no pudo entrar porque hay gatos comiendo.");
        }
        return res;//si el perro no pudo comer devuelve true, sino false
    }
    
    
    
    public boolean comerGato(String nom) throws InterruptedException{
        boolean res = true;
        if(permisoGatos()){
            if(ocupacion == 0){
                permisoActual = 'G';
            }
            if(platos.tryAcquire()){
                
                ocupacion++;
                System.out.println("El gato "+nom+" esta comiendo.");
                Thread.sleep(5000);
                
                if(ocupacion == capacidad-1){ //si es el ultimo perro antes de dejar el comedor
                    permisoActual = 'N';
                }
                res = false;
                platos.release();
            }else{
                System.out.println("El gato "+nom+" no consiguio un plato disponible.");
            }
        }else{
            System.out.println("El gato " +nom+ " no pudo entrar porque hay perros comiendo");
        }
        return res;//si el gato no pudo comer devuelve true, si comio false
    }
        
    public boolean espacioDisp(){
        return (ocupacion < capacidad);
    }
    
    public boolean permisoPerros(){
        return(permisoActual == 'P' || permisoActual == 'N');
    }
    
    public boolean permisoGatos(){
        return(permisoActual == 'G' || permisoActual == 'N');
    }
    
}
