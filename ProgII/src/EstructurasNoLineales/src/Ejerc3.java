//package EstructurasNoLineales.src;

public class Ejerc3 {
    public static void main(String args[]){
        ArbolBinario arbolBinario= new ArbolBinario();

        NodoABinario raiz= new NodoABinario("+");

        arbolBinario.construir(raiz);

        NodoABinario nodoProd= new NodoABinario("*");

        NodoABinario nodoResta= new NodoABinario("-");

        raiz.izq= nodoProd;
        raiz.der= nodoResta;

        NodoABinario nodoUno= new NodoABinario("1");
        NodoABinario nodoTres= new NodoABinario("3");
        NodoABinario nodoUno1= new NodoABinario("1");
        NodoABinario nodoSeis= new NodoABinario("6");

        nodoProd.izq= nodoUno;
        nodoProd.der= nodoTres;

        nodoResta.izq= nodoUno1;
        nodoResta.der= nodoSeis;


        arbolBinario.imprimirPreOrder();


    }
}
