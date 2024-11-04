
package lineales.dinamicas;

public class Cola {
    private Nodo frente;
    private Nodo fin;
    public Cola(){
        frente = null;
        fin = null;
    }
    
    public boolean poner(Object nuevoElem){
        if(this.esVacia()){
            Nodo nuevo = new Nodo(nuevoElem, null);
            this.frente = nuevo;
            this.fin = nuevo;
        }else{
            Nodo nuevo = new Nodo(nuevoElem,null);
            this.fin.setEnlace(nuevo);
            this.fin = nuevo;  
        }
        return true;
    }
    
    public boolean sacar(){
        boolean exito = false;
        if(!this.esVacia()){
                this.frente = this.frente.getEnlace();
            if(this.esVacia()){
                this.fin = null;
            }
            exito = true;
        }
        return exito;
        }
            
    public boolean esVacia(){
        return (frente == null);
    }
    
    public Object obtenerFrente(){
        Object elFrente =  null;
        if(!esVacia()){
            elFrente = this.frente.getElem();
        }
        return elFrente;
    }   
    
    public void vaciar(){
        this.frente = null;
        this.fin = null;
    }
    
    public Cola clone() {
        Cola colaClon = new Cola();
        if (!esVacia()) {
            colaClon.frente = new Nodo(this.frente.getElem(), null);// el primer elemento del clon lo creo con el getElem del frente original
            Nodo aux1 = this.frente.getEnlace();
            Nodo aux2 = colaClon.frente;
            while (aux1 != null) {  
                aux2.setEnlace(new Nodo(aux1.getElem(), null));
                aux1 = aux1.getEnlace();
                aux2 = aux2.getEnlace(); // itero el aux2
            }
            colaClon.fin = aux2;
        }
        return colaClon;
    }
    
    public String toString(){
        String resultado = "";
        Nodo aux = this.frente;
        if(aux == null){
            resultado = "la cola esta vacia";
        }else{
            while(aux!=null){
                resultado += aux.getElem().toString();
                aux = aux.getEnlace();
            }
        }
        return resultado;
    }
    

}
