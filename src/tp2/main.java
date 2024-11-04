package tp2;

/**
 *
 * @author romangattas
 */
public class main {
    //MAIN EJ 1
//    public static void main(String[] args) {
//        Cliente juan=new Cliente();
//        juan.setName("Juan Lopez");
//        Cliente ines=new Cliente ();
//        ines.setName ("Ines Garcia");
//        ines.start();
//        juan.start();
//        
//    }
    
    
    //MAIN EJ 2
//    public static void main(String[] args) {
//        Thread miHilo= new MiEjecucion();
//        miHilo.start();
//        try{
//            
//            miHilo.join();
//            
//        }catch(InterruptedException e){
//            System.out.println("Excepcion");
//        }
//        
//        System.out.println("En el main");
//        
//    }
    
    //MAIN EJ 5
    
    public static void main(String[] args) {
        System.out.println("Hilo principal iniciando.");
        //Primero, construye un objeto unHilo.
        MiHilo mh = new MiHilo("#1");
        //Luego, construye un hilo de ese objeto.
        Thread nuevoHilo = new Thread(mh);
        //Finalmente, comienza la ejecución del hilo.
        nuevoHilo.start();
        for (int i = 0; i < 50; i++) {
            System.out.print(" .");
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException exc) {
            System.out.println("Hilo principal interrumpido.");
        }
        System.out.println("Hilo principal finalizado.");
    }
      
}
