/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp3;

/**
 *
 * @author romangattas
 */
public class Turno {
    int nroTurno;
    
    public Turno(){
        this.nroTurno = 0;
    }
    
    public synchronized int getNroTurno(){
        return this.nroTurno;
    }
    
    public synchronized void pasarTurno(){
        if(this.nroTurno+1 > 2){
            this.nroTurno = 0;
        }
        else{
            this.nroTurno++;
        }
    }
}
