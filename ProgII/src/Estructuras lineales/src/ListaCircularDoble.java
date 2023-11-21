public class ListaCircularDoble {
    public NodoDoble head;
    public NodoDoble tail;
    public int size;

    public ListaCircularDoble() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public boolean vacia(){return this.head==null;}

    public void agregar(String data){
        NodoDoble nodoDoble= new NodoDoble(data);

        if(vacia()){
            this.head= nodoDoble;
            this.tail= nodoDoble;
        }else{
            NodoDoble aux= this.tail;
            aux.next= nodoDoble;
            this.tail=nodoDoble;
            this.tail.next= this.head;
            this.tail.prev= aux;
        }
        this.size++;
    }
    //ELIMINAR POR POSICION. OK
    public void eliminar(int posicion){
        NodoDoble aux= this.head;
        NodoDoble nextNode;


        if(posicion>=size||posicion<0){
            System.out.println("Posición no existe");
            return;
        }
        if(posicion==0){
            this.head=this.head.next;
            //this.head.prev= tail;
            //this.tail.next=this.head;
            this.size--;
        }
        else{
            for(int i = 0; i<this.size; i++) {
                if(i==posicion-1){
                    aux.next= aux.next.next;
                    nextNode= aux.next;
                    nextNode.prev= aux;
                    this.size--;
                    if(posicion==size){
                        this.tail=aux;
                        //this.head.prev= this.tail;
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
        }else{
            NodoDoble aux= this.head;
            for(int i=0; i<size; i++){
                if(i==posicion){
                    System.out.println("El valor en la posicion "+posicion+ " es "+aux.data);
                    break;
                }
                aux= aux.next;
            }
        }
    }

    public void imprimir(){
        if(vacia()){
            System.out.println("Lista vacía");
        }else{
            NodoDoble aux= this.head;
            for(int i=0; i<size; i++){
                System.out.println(aux.data);
                aux= aux.next;
            }
        }

    }
}

class Principal{
    public static void main(String[] args){
        ListaCircularDoble doubleCircleLL= new ListaCircularDoble();

        doubleCircleLL.agregar("juan");
        doubleCircleLL.agregar("pedro");
        doubleCircleLL.agregar("ana");
        doubleCircleLL.agregar("nina");

        doubleCircleLL.imprimir();

        doubleCircleLL.eliminar(0);
        System.out.print("\n");
        doubleCircleLL.imprimir();
        System.out.print("\n");
        //System.out.println(doubleCircleLL.head.data);
        //System.out.println(doubleCircleLL.tail.data);

        doubleCircleLL.retornarValor(2);

    }
}
