package tp3;

/**
 *
 * @author romangattas
 */

import java.util.logging.Level;
import java.util.logging.Logger;

public class Letra implements Runnable {
    char simbLetra;
    int cantVeces;
    int turnoCorrespondiente;
    Turno unT;

    public Letra(char letra, int cantVeces, Turno unTurno, int unTurnoCorrespondiente) {
        this.simbLetra = letra;
        this.cantVeces = cantVeces;
        this.unT = unTurno;
        this.turnoCorrespondiente = unTurnoCorrespondiente;
    }

    public void run() {
        int varIter = 1;
        while (varIter < 5) {
            if (unT.getNroTurno() == this.turnoCorrespondiente) {
                this.imprimirLetra();
                unT.pasarTurno();
                varIter++;
            }else{
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Letra.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }

    public void imprimirLetra() {
        for (int varIter = 0; varIter < this.cantVeces; varIter++) {
            System.out.print(simbLetra);
        }
    }
}
