public class ListaDoble {
    public NodoDoble head;
    public NodoDoble tail;
    public int size;

    public ListaDoble() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public boolean vacia() {
        return this.head == null;
    }

    public void agregar(String data){
        NodoDoble nuevoNodoDoble= new NodoDoble(data);

        if(vacia()){
            this.head= nuevoNodoDoble;
            this.tail= nuevoNodoDoble;
        }else{

            NodoDoble aux= this.tail;
            aux.next=nuevoNodoDoble;
            nuevoNodoDoble.prev=aux;
            this.tail= nuevoNodoDoble;
        }
        this.size++;
    }
    //ELIMINAR POR POSICION. OK
    public void eliminar(int posicion){
        NodoDoble aux= head;
        NodoDoble nodoAnterior= aux;
        int i=0;

        if(posicion>=size||posicion<0){
            System.out.println("Posición no existe");
            return;
        }

        if(posicion==0){
                head=aux.next;
        }else{
            while(i!=posicion){
                nodoAnterior= aux;
                aux= aux.next;
                i++;
            }
            nodoAnterior.next= aux.next;
        }
        this.size--;
    }

    public String retornarValor(int posicion){

        if(posicion>=size||posicion<0){
            return "Posición no existe";
        }
        if (head==null){
            return "Lista vacía";
        }else{
            NodoDoble aux = head;
            int i=0;

            while (i!=posicion) {
                aux= aux.next;
                i++;
            }
            return aux.data;
        }

    }

    public void imprimir() {
        if (vacia()) {
            System.out.println("Lista vacia");
        } else {
            NodoDoble aux = this.head;
            for(int i = 0; i<this.size; i++) {
                System.out.println(aux.data);
                aux = aux.next;
            }
        }
    }
}
