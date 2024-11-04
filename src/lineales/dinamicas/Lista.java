package lineales.dinamicas;


public class Lista {
    private Nodo cabecera;
    private int longitud;
    
    
    public Lista(){
        this.cabecera = null;
        this.longitud = 0;
    }
    
    public boolean insertar(Object ob, int pos){
        boolean exito = false;
        //Chequea que la posición sea valida
        if(pos >= 1 && pos <= this.longitud+1){
            exito = true;
            //Si es el primer elemento, se agrega a cabecera
            if(pos == 1){
                Nodo nuevo = new Nodo(ob, this.cabecera);
                this.cabecera = nuevo;
            }//Si la posición no es la 1, se procede a agregarlo con aux
            else{
                //Guarda cabecera en temporal
                Nodo aux = this.cabecera;
                //itera modificando aux hasta llegar
                //al elemento anterior de la posicion deseada
                //para agregar
                int i = 1;
                while (i < pos-1) {
                    aux = aux.getEnlace();
                    i++;
                }
                Nodo nuevo = new Nodo(ob, aux.getEnlace());
                aux.setEnlace(nuevo);
            }
            this.longitud++;
        }
        return exito;      
    }
    
    public boolean eliminar(int pos){
        boolean exito = false;
        if(pos >= 1 && pos <= this.longitud){ 
            exito = true;
           //Si es el primer elemento, se elimina la cabecera
           if(pos == 1){
               this.cabecera = this.cabecera.getEnlace();
           }//Si la posición no es la 1, se apunta a la cabecera con aux
           //y se itera hasta llegar al elemento que se va a eliminar
           else{
               Nodo aux = this.cabecera;
               int i = 1;
               while (i < pos-1) {
                   aux = aux.getEnlace();
                   i++;
               }
               //Desconecta el enlace referenciado a la posición que 
               //queremos eliminar, y reenlaza con el elemento siguiente          
               aux.setEnlace(aux.getEnlace().getEnlace());
           }
           this.longitud--;
        }
        return exito;
    }
    
    public Object recuperar(int pos){
        Object recuperado = null;
        //Verifica si la posicion es valida
        if(pos >= 1 && pos <= this.longitud){
            Nodo aux = this.cabecera;
            //itera desde el primer elemento hasta el elemento en la posicion 
            //que buscamos
            int i = 1;
            while (i<pos) {
                aux = aux.getEnlace();
                i++;
            }
            recuperado = aux.getElem();          
        }
        return recuperado;
    }
//    public int localizar(Object elem){
//            Nodo puntero=cabecera;
//            Nodo aux;
//            int pos=-1;
//            int contador=1;
//            if(cabecera==null){
//                pos=-1;
//            }else{
//                    while(!elem.equals(puntero.getElem()) && puntero.getEnlace()!=null){
//                        puntero= puntero.getEnlace();
//                        contador++;
//                    }
//            }
//                if(elem.equals(puntero.getElem())){
//                    pos= contador;
//                }
//                return pos;
//        }
    public int localizar(Object ob){
        int posLocalizada = -1;
        int pos = 1;
        if(this.cabecera != null){
            Nodo aux = this.cabecera;
            while(aux.getEnlace() != null && !(aux.getElem().equals(ob))){
                aux = aux.getEnlace();
                pos++;
            }
            if(aux.getElem() == ob){
                posLocalizada = pos;
            }
        } 
        return posLocalizada;
    }
    
    public boolean esVacia(){
        return cabecera == null;
    }
    
    public void vaciar(){
        cabecera = null;
    }
    public int longitud(){
        return longitud;
    }
    
    public String toString(){
        String msg = "";
        Nodo aux = this.cabecera;
        while(aux != null){
            msg = msg + aux.getElem().toString() + " ";
            aux = aux.getEnlace();
        }
        return msg;
    }
    
    public Lista clone(){
        Lista clon = new Lista();
        // Si la lista no es vacia empiezo a clonar
        if(!this.esVacia()){
            // Creo la cabecera de clon con un nuevo nodo que va a tener
            // el elemento de la lista original con un enlace nulo
            clon.cabecera = new Nodo(this.cabecera.getElem(), null);
            // aux1 va a apuntar a la lista original
            Nodo aux1 = this.cabecera;
            //aux2 va a apuntar a la lista clonada
            Nodo aux2 = clon.cabecera;
            // apunto aux1 a la siguiente posicion para empezar a clonar los
            // siguientes elementos de la lista
            aux1 = aux1.getEnlace();
            // mientras aux no sea nulo se va a seguir clonando
            while(aux1 != null){
                // al enlace  de aux2 le asigno el siguiente nodo con: 
                // el elemento del nodo al que apunta aux1 y enlace nulo 
                // (ya que aux1 va una posicion adelantada)
                aux2.setEnlace(new Nodo(aux1.getElem(), null));
                // itero ambos aux para seguir clonando
                aux1 = aux1.getEnlace();
                aux2 = aux2.getEnlace();
            }
        }
        return clon;
    }
    
    //metodos propios
    
    public Lista obtenerMultiplos(int num){
        Lista nueva = new Lista();
        Nodo aux1 = this.cabecera;
        Nodo aux2 = nueva.cabecera;
        int cont = 1;
        while(aux1 != null){
            if(cont % num == 0){
                if(nueva.cabecera == null){
                    nueva.cabecera = new Nodo(aux1.getElem(), null);
                    aux2 = nueva.cabecera;
                }else{
                    aux2.setEnlace(new Nodo(aux1.getElem(), null));
                    aux2 = aux2.getEnlace();
                }
            }
            aux1 = aux1.getEnlace();
            cont++;
        }
        return nueva;
    }
    
    
    public boolean eliminarApariciones(Object x){
         boolean exito = false;
         
         Nodo aux = this.cabecera;
         
        while(aux != null){
            if(this.cabecera.getElem().equals(x)){
                this.cabecera = this.cabecera.getEnlace();
                aux = this.cabecera;
                longitud--;
                exito = true;
            }else if(aux.getEnlace() != null && aux.getEnlace().getElem().equals(x)){
                aux.setEnlace(aux.getEnlace().getEnlace());
                exito = true;
                longitud--;
            }
            aux = aux.getEnlace();
        }
        return exito;
     }
    
    public boolean cambiarPosicion(int pos1, int pos2){
        boolean resultado = false;
        if (pos1 <= pos2){
            if(pos2 <= this.longitud){
                if (pos1 == pos2){
                    resultado = true;
                }else{
                    Nodo aux1 = this.cabecera;
                    int i = 1;
                    while(i < pos1){
                        aux1 = aux1.getEnlace();
                        i++;
                    }
                    i++;
                    Object contenido = aux1.getEnlace().getElem();
                    aux1.setEnlace(aux1.getEnlace().getEnlace());
                    while(i<pos2){
                        aux1 = aux1.getEnlace();
                        i++;
                    }
                    Nodo nuevo = new Nodo(contenido, aux1.getEnlace());
                    aux1.setEnlace(nuevo);
                    
                }
        
            }
        
        
        }
        return resultado;
    }
    
}

