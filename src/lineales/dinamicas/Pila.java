package lineales.dinamicas;

public class Pila {
    private Nodo tope;
    
    //Constructor
    public Pila(){
        this.tope = null;
    }
    
    public boolean apilar(Object elem){
        Nodo nuevo = new Nodo(elem, this.tope);
        this.tope = nuevo;
        return true;
    }
    
    public boolean desapilar(){
        boolean resultado = false;
        if(this.tope != null){
            this.tope = this.tope.getEnlace(); //elimina el elemento en el tope
            resultado = true;
        }
        return resultado;
    }
    
    public Object obtenerTope(){
        Object resultado = null;
        if(this.tope != null){
            resultado = this.tope.getElem();
        }
        return resultado;
    }
    
    public void vaciar(){
        this.tope = null;
    }
    
    public boolean esVacia(){
        return tope == null;
    }
    
    public Pila cloneIterativo(){
        Pila clon = new Pila();
        if(this.tope!=null){
            clon.tope = new Nodo(this.tope.getElem(), null);
            Nodo aux1 = this.tope.getEnlace();
            Nodo aux2 = clon.tope;
            while(aux1!=null){
                aux2.setEnlace(new Nodo(aux1.getElem(), null));
                aux1 = aux1.getEnlace();
                aux2 = aux2.getEnlace();
            }
        }
        return clon;
    }
    
    public Pila clone(){
        Pila clon = new Pila();
        if(this.tope!=null){
            clon.tope = new Nodo(this.tope.getElem(), null);
            cloneAux(this.tope.getEnlace(), clon.tope);
        }
        return clon;
    }
    
    private void cloneAux(Nodo t1, Nodo t2){
        if(t1!=null){
            t2.setEnlace(new Nodo(t1.getElem(), null));
            cloneAux(t1.getEnlace(),t2.getEnlace());
        }
    }
    
    public String toString(){
        String salida = "";
        if(this.tope == null){
            salida = "La pila esta vacia";
        }else{
            Nodo aux = this.tope; //solo puede acceder a la pila mediante tope
            while(aux!=null){
                salida += aux.getElem().toString() + ", "; //concatena cada elemento de la pila
                aux = aux.getEnlace(); //avanza de elemento en la pila
            }
        }
        return salida;
    }
}
