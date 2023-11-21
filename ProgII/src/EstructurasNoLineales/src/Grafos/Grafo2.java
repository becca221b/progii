package Grafos;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Grafo2 {
    public static void main(String args[]){

        ListaSimple listaA= new ListaSimple();
        listaA.agregar("B");

        ListaSimple listaB= new ListaSimple();
        listaB.agregar("A");
        listaB.agregar("C");

        ListaSimple listaC= new ListaSimple();
        listaC.agregar("B");

        List<ListaSimple> listaDeAdya= Arrays.asList(listaA,listaB,listaC);
        listaDeAdya.forEach(n->n.imprimir());

        String[] vertices= {"A","B","C"};
        Grafo miGrafo= new Grafo(vertices);

        miGrafo.conectar("A","B",1);
        miGrafo.conectar("B","C",1);
    }
}
class Nodo {

    public String data;
    public Nodo next;

    public Nodo(String data) {
        this.data = data;
        this.next = null;
    }

}
class ListaSimple {

    public Nodo primero;
    public int size;

    public ListaSimple() {
        this.primero = null;
        this.size = 0;
    }

    public boolean vacia() {
        return this.primero == null;
    }

    public String agregar(String valor) {

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
        return valor;
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
                System.out.print(aux.data+" ");
                aux = aux.next;
            }
        }
        System.out.print("\n");
    }

    public boolean buscarElem(String valor){
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

    public void eliminarValor(String valor){
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

    public void agregarAlMedio(String valor, int posicion){

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