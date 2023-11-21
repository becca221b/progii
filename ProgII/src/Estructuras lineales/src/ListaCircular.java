public class ListaCircular {

    public Nodo primero;
    public Nodo ultimo;
    public int size;

    public ListaCircular() {
        this.primero = null;
        this.ultimo= null;
        this.size = 0;
    }

    public boolean vacia() {
        return this.primero == null;
    }

    public void agregar(int valor){
        Nodo nuevoNodo= new Nodo(valor);
        if(vacia()){
            this.primero= nuevoNodo;
        }else{
            this.ultimo.next=nuevoNodo;
        }
        this.ultimo= nuevoNodo;
        this.ultimo.next= this.primero;
        this.size++;
    }

    public void eliminar(int posicion){
        Nodo aux= primero;

        if(posicion>=size||posicion<0){
            System.out.println("Posición no existe");
            return;
        }
        if(posicion==0){
            this.primero=this.primero.next;
            this.size--;
        }
        else{
            for(int i = 0; i<this.size; i++) {
                if(i==posicion-1){
                    aux.next= aux.next.next;
                    this.size--;
                    if(posicion==size){
                        this.ultimo=aux;
                    }
                    break;
                }
                aux = aux.next;
            }

        }

    }

    public void retornarValor(int posicion){
        if(posicion>=size||posicion<0){
            System.out.println("Posición no existe");
            return;
        }
        if(vacia()){
            System.out.println("Lista vacía");
        }else{
            Nodo aux= primero;
            for(int i = 0; i<this.size; i++) {
                if(i==posicion){
                    System.out.println(aux.data);
                    break;
                }
                aux = aux.next;
            }
        }
    }

    public void imprimir(){
        Nodo aux= primero;
        for(int i = 0; i<this.size; i++) {
            System.out.println(aux.data);
            aux = aux.next;
        }
    }
}
