package tp2;

/**
 *
 * @author romangattas
 */
public class Cliente7 {
    private String nombre;
    private int[] carroCompra;
    
    
    public Cliente7(String nom, int[] carr){
        nombre = nom;
        carroCompra = carr;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public int[] getCarroCompra(){
        return carroCompra;
    }
}
