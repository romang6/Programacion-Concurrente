/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parcial2023.Espacio;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock
/**
 *
 * @author paula
 */;

public class FormacionAgua {
    private Lock mutex = new ReentrantLock(true);
    private Condition hidrogeno = mutex.newCondition();
    private Condition oxigeno = mutex.newCondition();
    private int cantAgua = 0, cantO = 0, cantH = 0, aguaAlmacen, eliminarH = 0, eliminarO = 0;
    
    public FormacionAgua (int espacioAlmacenAgua){
        this.aguaAlmacen = espacioAlmacenAgua;
    }
    public void Olisto() throws InterruptedException{
        mutex.lock();
        try{
            this.cantO++;
            //System.out.println(Thread.currentThread().getName()+ " ingresa y hay "+this.cantO+" Ox y tantos "+this.cantH+"H");
            boolean puede = (this.cantO >= 1 && this.cantH >= 2) || this.eliminarH > 0;
            System.out.println(Thread.currentThread().getName()+ " Puede: "+puede);
            while(!puede){
                System.out.println(Thread.currentThread().getName()+" espera porque solo hay "+this.cantH+"H");
                this.oxigeno.await();
                puede = (this.cantO >= 1 && this.cantH >= 2) || this.eliminarO > 0;
            }
            if (eliminarO > 0) {
                System.out.println(Thread.currentThread().getName()+ " sale de ser utilizado para hacer agua");
                eliminarO--;
            }else{
                this.hacerAguaO();
                System.out.println(Thread.currentThread().getName()+ " SALE hay "+this.cantO+" Ox y tantos "+this.cantH+"H");
            }
        }finally{
            mutex.unlock();
        }
    }

    public void Hlisto() throws InterruptedException{
        mutex.lock();
        try{
            this.cantH++;
            
            boolean puede = (this.cantO >= 1 && this.cantH >= 2) || this.eliminarH > 0;
            System.out.println(Thread.currentThread().getName()+ " Puede: "+puede);
            while(!puede){
                System.out.println(Thread.currentThread().getName()+" espera porque solo hay "+this.cantH+"H y "+this.cantO+"O");
                this.hidrogeno.await();
                puede = (this.cantO >= 1 && this.cantH >= 2) || this.eliminarH > 0;
            }
            if (eliminarH > 0) {
                System.out.println(Thread.currentThread().getName()+ " sale de ser utilizado para hacer agua");
                eliminarH--;
            }else{
                this.hacerAguaH();
                System.out.println(Thread.currentThread().getName()+ " SALE hay "+this.cantO+" Ox y tantos "+this.cantH+"H");
            }
        }finally{
            mutex.unlock();
        }
    }
    
    private void hacerAguaO(){
        mutex.lock();
        try{
            System.out.println(Thread.currentThread().getName()+" hizo agua con 2H ya existentes.");
            this.eliminarH += 2;
            this.hidrogeno.signal();
            this.hidrogeno.signal();
            this.hidrogeno.signal();
            this.cantH-= 2;
            this.cantO--;
            this.cargarAgua();
        }finally{
            mutex.unlock();
        }
    }
    private void hacerAguaH(){
        mutex.lock();
        try{
            System.out.println(Thread.currentThread().getName()+" hizo agua con 1H y 1O ya existentes.");
            this.eliminarH += 1;
            this.eliminarO += 1;
            this.hidrogeno.signal();
            this.hidrogeno.signal();
            this.oxigeno.signal();
            this.oxigeno.signal();
            this.cantH-= 2;
            this.cantO--;
            this.cargarAgua();
        }finally{
            mutex.unlock();
        }
    }
    private void cargarAgua(){
        mutex.lock();
        try{
            if (cantAgua + 1 < aguaAlmacen) {
                cantAgua++;
            }else{
                cantAgua = 0;
                System.out.println("Se alamceno la ultima agua y se vacio el recipiente");
            }
        }finally{
            mutex.unlock();
        }
    }
}
