import java.util.Scanner;

class Node {

    public char data;
    public Node next;

    public Node(char data) {
        this.data = data;
        this.next = null;
    }


}
class Stack {
    private Node top;
    private int size;

    public Stack() {
        this.top = null;
        this.size = 0;
    }

    public Node getTop() {
        return top;
    }

    public boolean vacia(){
        return this.top==null;
    }
    //PUSH
    public void apilar(char value){
        Node newNode= new Node(value);
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

    public char topValue(){
        return top.data;
    }

    public boolean buscar(int value){
        Node aux= this.top;
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
        Node aux= this.top;
        for(int i=0;i<this.size;i++){
            System.out.println(aux.data);
            aux= aux.next;
        }
        System.out.print("\n");
    }
}
public class PrintCharReverse {

    public static void main(String[] args){
        Scanner scanner= new Scanner(System.in);
        Stack stack= new Stack();
        int i=0;
        while(i<5){
            System.out.println("Ingrese un caracter");
            char value= scanner.next().charAt(0);
            stack.apilar(value);
            i++;
        }





        stack.imprimir();
    }

}
