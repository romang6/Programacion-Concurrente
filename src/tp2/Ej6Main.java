/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp2;

/**
 *
 * @author romangattas
 */
public class Ej6Main {
    
    public static void main(String[] args) {
    Corredor[] Lista = new Corredor[5];
    Corredor primero= new Corredor("Juan");
    Corredor segundo = new Corredor("Javi");
    Corredor tercero = new Corredor("Martin");
    Corredor cuarto = new Corredor("Roman");
    Corredor quinto = new Corredor("Agus");
    Lista[0]=primero;
    Lista[1]=segundo;
    Lista[2]=tercero;
    Lista[3]=cuarto;
    Lista[4]=quinto;
    
    Thread prim = new Thread(primero);
    Thread seg = new Thread(segundo);
    Thread ter = new Thread(tercero);
    Thread cuart = new Thread(cuarto);
    Thread quin = new Thread(quinto);
    
    prim.start();
    seg.start();
    ter.start();
    cuart.start();
    quin.start();
    try{
        prim.join();
        seg.join();
        ter.join();
        cuart.join();
        quin.join();
    }catch(InterruptedException e){
        System.out.println("Interrupcion");
    }
    double distanciaGanadora = 0;
    String ganador = "";
    for (int i = 0; i < Lista.length; i++) {
       if(Lista[i].getDistancia()>distanciaGanadora){
           distanciaGanadora = Lista[i].getDistancia();
           ganador = Lista[i].getNombre();
      } 
    }
        System.out.println("El ganador es: " +ganador+ " con una distancia de: " +distanciaGanadora);
    }
     
    
}
