/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ActividadOb;

/**
 *
 * @author romangattas
 */
public class Sala {
    private int visitantes;
    private int responsable;
    private int criticos;
    private String[] listaCriticas;
    private int ultimaCritica;
    private static final int capacidad = 20;
    
    public Sala(){
        
        listaCriticas = new String[10];
        visitantes = 0;
        responsable = 0;
        criticos = 0;
        ultimaCritica = 0;
        
    }
    
    
    public synchronized void ingresarVisitante(String nombre){
        try{
            while(visitantes>= capacidad){
                System.out.println("El visitante " +nombre+ " debe esperar porque la sala esta llena.");
                this.wait();
            
            }
        
        }catch(InterruptedException e){
        
        }
        
        System.out.println("El visitante "+nombre+" ingreso a la sala.");
        visitantes++;
    
    }
    
    public synchronized void ingresarResponsable(String nombre){
        try{
            while(responsable >= 1){
                System.out.println("El responsable " +nombre+ " debe esperar porque ya hay un responsable.");
                this.wait();
            
            }
            
        
        }catch(InterruptedException e){
        
        }
        
        System.out.println("El responsable "+nombre+" ingreso a la sala.");
        responsable++;
    }
    
    public synchronized void ingresarCritico(String nombre){
        try{
            while(responsable > 0 && visitantes >0){
                System.out.println("El critico " +nombre+ " debe esperar porque hay personas en la sala.");
                this.wait();
            
            }
            
        
        }catch(InterruptedException e){
        
        }
        
        System.out.println("El critico "+nombre+" ingreso a la sala.");
        
        responsable++;
        
        String unaCritica = "Critica de " +nombre;
        listaCriticas[ultimaCritica] = unaCritica;
        ultimaCritica++;
        
        
        
    }
    
    
    public synchronized void retiroSala(char t, String nombre){
        if(t == 'V'){
            System.out.println("El visitante "+nombre+" se retiro de la sala.");
            visitantes--;
        }else if(t == 'R'){
            System.out.println("El responsable "+nombre+" se retiro de la sala.");
            responsable--;
        }else if(t == 'C'){
            System.out.println("El critico "+nombre+" se retiro de la sala.");
            criticos--;
        }
        this.notify();
    }
    
    public void mostrarCriticas(){
        for (int i = 0; i < ultimaCritica; i++) {
            System.out.println(listaCriticas[i]+"\n");
        }
    
    }
    
    
    
    
}
