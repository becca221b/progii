public class Cola {
    private Nodo head;
    private Nodo tail;
    private int size;

    public Cola() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public int getSize() {
        return size;
    }

    public Nodo getHead() {
        return head;
    }

    public Nodo getTail() {
        return tail;
    }

    public boolean vacia(){
        return this.head==null;
    }

    // enqueue
    public void encolar(int data){
        Nodo newNode= new Nodo(data);

        if(vacia()){
            this.head= newNode;
        }else{
            this.tail.next= newNode;
        }
        this.tail= newNode;
        this.size++;
    }

    public void desencolar(){
        if (vacia()){
            System.out.println("Cola vacía");
        }else{
            this.head= this.head.next;
            this.size--;
        }
    }

    public void imprimr(){
        if (vacia()){
            System.out.println("Cola vacía");
        }else{
            Nodo aux= this.head;
            for(int i=0;i<this.size;i++){
                System.out.print(aux.data+" ");
                aux= aux.next;
            }
        }
    }

}
class PrincipalCola{
    public static void main(String[] args){
        Cola cola1= new Cola();

        cola1.encolar(1);
        cola1.encolar(2);
        cola1.encolar(3);

        cola1.imprimr();
        System.out.println("\n");

        cola1.desencolar();
        cola1.imprimr();
        System.out.println("\n");

        System.out.println(cola1.getHead().data);
        System.out.println(cola1.getTail().data);
    }
}