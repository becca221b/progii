public class Pila {
    private Nodo top;
    private int size;

    public Pila() {
        this.top = null;
        this.size = 0;
    }

    public Nodo getTop() {
        return top;
    }

    public boolean vacia(){
        return this.top==null;
    }
    //PUSH
    public void apilar(int value){
        Nodo newNode= new Nodo(value);
        if(!vacia()){
            newNode.next= this.top;
        }
        this.top= newNode;
        this.size++;
    }

    //POP
    public void retirar(){
        if(vacia()){
            System.out.println("La pila está vacía");
        }else{
            this.top= this.top.next;
        }
        this.size--;
    }

    public int topValue(){
        return top.data;
    }

    public boolean buscar(int value){
        Nodo aux= this.top;
        for(int i=0;i<this.size;i++){
            if(aux.data==value){
                return true;
            }else{
                aux= aux.next;
            }
        }
        return false;
    }

    public void imprimir(){
        Nodo aux= this.top;
        for(int i=0;i<this.size;i++){
            System.out.println(aux.data);
            aux= aux.next;
        }
        System.out.print("\n");
    }
}

class PrincipalStack{
    public static void main(String[] args){
        Pila stack= new Pila();

        stack.apilar(1);
        stack.apilar(2);
        stack.apilar(3);

        stack.imprimir();

        stack.retirar();

        stack.imprimir();

        System.out.println(stack.topValue());


    }
}
