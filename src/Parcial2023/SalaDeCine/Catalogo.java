package Parcial2023.SalaDeCine;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author Roman
 */
public class Catalogo {

    private final Lock mutexTraductor = new ReentrantLock();
    private final Lock mutexSocioEsp= new ReentrantLock();
    private Condition esperaTraductor;
    private Condition esperaEsp;
    private Condition esperaIng;
    private int capEspaniol;
    private int capDisp;
    private int capIngles;
    
    public Catalogo(){
        esperaTraductor = mutexTraductor.newCondition();
        esperaEsp = mutexSocioEsp.newCondition();
        esperaIng = mutexTraductor.newCondition();
        capEspaniol = 0;
        capDisp = 0;
        capIngles = 0;
        
    }
    
    public void filmar(){
        mutexSocioEsp.lock();
        try {
            capEspaniol++;
            esperaEsp.signalAll();
        } finally {
            mutexSocioEsp.unlock();
        }
        mutexTraductor.lock();
        try {
            capDisp++;
            esperaTraductor.signalAll();
        } finally {
            mutexTraductor.unlock();
        }
    }
    
    public void empezarAtraducir() throws InterruptedException{
        mutexTraductor.lock();
        try {
            while(capDisp==0){
                System.out.println(Thread.currentThread().getName()+" espera para traducir.");
                esperaTraductor.await();            
            }
            
            System.out.println(Thread.currentThread().getName()+" empieza a traducir.");
            
        } finally {
            mutexTraductor.unlock();
        }
    }
    
    public void terminarDeTraducir()throws InterruptedException{
        mutexTraductor.lock();
        
        try {
            
            capDisp--;
            System.out.println(Thread.currentThread().getName()+" termino de traducir");
            capIngles++;
            esperaIng.signalAll();
            
        } finally {

            mutexTraductor.unlock();
        }   
    }

    
    public void verEspaniol(int cap) throws InterruptedException{
        mutexSocioEsp.lock();
        try {
            while(capEspaniol<cap){
                System.out.println("Un socio ESP espera a que se filme el cap "+cap);
                
                esperaEsp.await();
                
            }
            
            System.out.println("Socio logro ver cap "+cap+" en espaniol");
        } finally {
            mutexSocioEsp.unlock();
        }
    }
    
    
    public void verIngles(int cap) throws InterruptedException{
        mutexTraductor.lock();
        try {
            while(capIngles<cap){
                System.out.println("Un socio ING espera a que se filme el cap "+cap);
   
                esperaIng.await();

            }
            
            System.out.println("Socio logro ver cap "+cap+" en ingles");
        } finally {
            mutexTraductor.unlock();
        }
    }
}
