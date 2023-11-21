/**
 * Clase Lista simplemente enlazada.
 */
public class ListaSimple {

    public Nodo primero;
    public int size;

    public ListaSimple() {
        this.primero = null;
        this.size = 0;
    }

    public boolean vacia() {
        return this.primero == null;
    }

    public void agregar(int valor) {

        Nodo nuevo = new Nodo(valor);

        if (vacia()) {
            // agregamos el primer nodo
            this.primero = nuevo;
        } else {
            // se tiene que recorrer la lista hasta llegar al ultimo nodo
            Nodo aux = this.primero;

            while (aux.next != null) {
                aux = aux.next;
            }
            aux.next = nuevo;
        }
        this.size++;
    }

    public void eliminarUltimo() {
        if (vacia()) {
            System.out.println("Lista vacia");
        } else {
            // se tiene que recorrer la lista hasta llegar al ultimo nodo
            Nodo aux = primero;
            Nodo nodoAnterior = aux;

            while (aux.next != null) {
                nodoAnterior = aux;
                aux = aux.next;
            }

            // Verifico si realmente avanzó en la lista hasta llegar al
            // último nodo que sea distinto del primero.
            // Si estoy en el primero, entonces lo hago null para indicar que la lista esta vacia.
            if (aux == this.primero) {
                this.primero = null;
            } else {
                // Le indico al nodo anterior que no apunte más al nodo a eliminar "aux".
                nodoAnterior.next = null;
            }

            // Decremento el size
            this.size--;
        }
    }

    public void imprimir() {
        if (vacia()) {
            System.out.println("Lista vacia");
        } else {
            Nodo aux = this.primero;
            for(int i = 0; i<this.size; i++) {
                System.out.println(aux.data);
                aux = aux.next;
            }
        }
    }

    public boolean buscarElem(int valor){
        if (primero==null){
            return false;
        }
        Nodo aux = primero;

        while (aux.data!=valor) {
                if(aux.next == null){
                    return false;

                }
                aux= aux.next;

        }

        return true;
    }

    public void eliminarValor(int valor){
       Nodo aux = primero;
       Nodo nodoAnterior= aux;
       if(buscarElem(valor)){

           while(aux.data!=valor){
               nodoAnterior= aux;
               aux= aux.next;
           }
           nodoAnterior.next= aux.next;
           this.size--;
       }
    }


    public void eliminarPosicion(int posicion){

        Nodo aux= primero;

        if(posicion>=size||posicion<0){
            System.out.println("Posición no existe");
            return;
        }

        for(int i = 0; i<this.size; i++) {
            if(posicion==0){
                primero=aux.next;
                this.size--;
                break;
            }
            if(i==posicion-1){
                aux.next= aux.next.next;
                this.size--;
                break;
            }
            aux = aux.next;
        }

    }

    //aux.prox.prox

    public void agregarAlMedio(int valor, int posicion){

        if(posicion>=size||posicion<0){
            System.out.println("Posición no existe");
            return;
        }

        Nodo nuevo = new Nodo(valor);

        if (vacia()) {
            // agregamos el primer nodo
            this.primero = nuevo;
        } else {

            // se tiene que recorrer la lista hasta llegar al ultimo nodo
            Nodo aux = this.primero;


            int indice=0;
            while (indice<posicion-1) {
                aux = aux.next;
                indice++;
            }

            //AGREGAR SI LA POSICION ELEGIDA ES CERO

            nuevo.next=aux.next;
            aux.next= nuevo;


        }
        this.size++;
    }

    public void retornarValor(int posicion){

        if(posicion>=size||posicion<0){
            System.out.println("Posición no existe");
            return;
        }
        if (primero==null){
            System.out.println("Lista vacía");
        }else{
            Nodo aux = primero;
            int i=0;

            while (i!=posicion) {
                aux= aux.next;
                i++;
            }
            System.out.println(aux.data);
        }

    }
}