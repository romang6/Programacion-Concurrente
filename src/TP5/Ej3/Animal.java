package TP5.Ej3;

/**
 *
 * @author romangattas
 */
public class Animal implements Runnable{
    private String nombre;
    private char raza;
    private Comedor unComedor;
    
   
    public Animal(String nom, char r, Comedor com){
        nombre = nom;
        raza = r;
        unComedor = com;
    }
   
    
    
    public void run(){
        while(true){
            if(this.raza == 'P'){
                try{
                    if(unComedor.comerPerro(nombre)){
                        Thread.sleep(5000);
                    }
                }catch(InterruptedException e){
                
                }
            
            }else{
                try{
                    if(unComedor.comerGato(nombre)){
                        Thread.sleep(5000);
                    }
                }catch(InterruptedException e){
                
                }
            }
        
        }   
    }
}
