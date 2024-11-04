package Parcial2023.SalaDeCine;

/**
 *
 * @author Roman
 */
public class Filmador implements Runnable{
    private Catalogo cat;
    public Filmador(Catalogo c){
        cat = c;
    }
    
    public void run(){
        while(true){
            try{
            System.out.println("FILMANDO CAP");
            Thread.sleep(1000);
            cat.filmar();
            }catch(Exception e ){}
        }
    
    }
}
