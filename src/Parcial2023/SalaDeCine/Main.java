package Parcial2023.SalaDeCine;

/**
 *
 * @author Roman
 */
public class Main {
    public static void main(String[] args) {
        Catalogo c = new Catalogo();
        Filmador fil = new Filmador(c);
        Thread[] traductores = new Thread[2];
        Thread[] sociosEsp = new Thread[10];
        Thread[] sociosIng = new Thread[10];
        Thread hiloF = new Thread(fil, "F");
        hiloF.start();
        
        for (int i = 0; i < 2; i++) {
            traductores[i] = new Thread(new Traductor(c),"T"+i);
            traductores[i].start();
        }
        
        for (int i = 0; i < 10; i++) {
            sociosEsp[i] = new Thread(new Socio(c, 'E'),"S.E"+i);
            sociosIng[i] = new Thread(new Socio(c, 'I'),"S.I"+i);
            sociosEsp[i].start();
            sociosIng[i].start();
        }
        
    }
    
    

}
