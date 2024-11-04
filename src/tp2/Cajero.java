/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp2;

/**
 *
 * @author romangattas
 */
public class Cajero {
    
    private String nombre;
    // Agregar Constructor, y métodos de acceso
    
    public Cajero(String nom){
        nombre = nom;
    }    
        
    public void procesarCompra(Cliente7 cliente, long timeStamp) {
        
        System.out.println ("El cajero " + this.nombre +" COMIENZA A "
                + "PROCESAR LA COMPRA DEL CLIENTE " + cliente.getNombre() + " EN EL TIEMPO: " 
                + (System.currentTimeMillis() - timeStamp) / 1000 + "seg");
        
        for (int i = 0; i < cliente.getCarroCompra().length; i++) {
            this.esperarXsegundos(cliente.getCarroCompra()[i]);
            System.out.println("Procesado el producto " + (i + 1) +
            "->Tiempo: " + (System.currentTimeMillis() - timeStamp) /
            1000 + "seg");
        }
        
        System.out.println("El cajero " + this.nombre +" HA TERMINADO DE "
                + "PROCESAR " + cliente.getNombre() + " EN EL TIEMPO: " 
                + (System.currentTimeMillis() - timeStamp) / 1000 + "seg");
    }
    
    private void esperarXsegundos(int t){
        try{
            Thread.sleep(t*1000);
        }catch(InterruptedException e){
            System.out.println("Excepcion del tiempo");
        }
    }
}
