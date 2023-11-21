package Grafos;

import java.util.Arrays;
import java.util.List;

public class Ejercicio1 {
    public static void main(String[] args){
        String[] vertices= {"A","B","C","D","E","F","G","H","I","J"};
        Grafo miGrafoNew= new Grafo(vertices);

        miGrafoNew.conectar("A","B",2);
        miGrafoNew.conectar("A","C",4);
        miGrafoNew.conectar("A","D",3);

        miGrafoNew.conectar("B","E",7);
        miGrafoNew.conectar("B","F",4);
        miGrafoNew.conectar("B","G",6);

        miGrafoNew.conectar("C","E",3);
        miGrafoNew.conectar("C","F",2);
        miGrafoNew.conectar("C","G",4);

        miGrafoNew.conectar("D","E",4);
        miGrafoNew.conectar("D","F",1);
        miGrafoNew.conectar("D","G",5);

        miGrafoNew.conectar("E","H",1);
        miGrafoNew.conectar("E","I",4);

        miGrafoNew.conectar("F","H",6);
        miGrafoNew.conectar("F","I",3);

        miGrafoNew.conectar("G","H",3);
        miGrafoNew.conectar("G","I",3);

        miGrafoNew.conectar("H","J",3);

        miGrafoNew.conectar("I","J",4);

        //MATRIZ DE ADYACENCIA
        //miGrafoNew.imprimir();

        //PARES DE ADYACENCIA
        /*
        String[][] paresAdyacencia= {{"A","B"},{"A","C"},{"A","D"},
                                    {"B","E"},{"B","F"},{"B","G"},
                                    {"C","E"},{"C","F"},{"C","G"},
                                    {"D","E"},{"D","F"},{"D","G"},
                                    {"E","H"},{"E","I"},
                                    };*/


        //LISTA DE ADYACENCIA
        ListaSimple listaA= new ListaSimple();
        listaA.agregar("B");
        listaA.agregar("C");
        listaA.agregar("D");

        ListaSimple listaB= new ListaSimple();
        listaB.agregar("A");
        listaB.agregar("E");
        listaB.agregar("F");
        listaB.agregar("G");

        ListaSimple listaC= new ListaSimple();
        listaC.agregar("A");
        listaC.agregar("E");
        listaC.agregar("F");
        listaC.agregar("G");

        ListaSimple listaD= new ListaSimple();
        listaD.agregar("E");
        listaD.agregar("F");
        listaD.agregar("G");

        ListaSimple listaE= new ListaSimple();
        listaE.agregar("H");
        listaE.agregar("I");

        ListaSimple listaF= new ListaSimple();
        listaF.agregar("H");
        listaF.agregar("I");

        ListaSimple listaG= new ListaSimple();
        listaG.agregar("H");
        listaG.agregar("I");

        ListaSimple listaH= new ListaSimple();
        listaH.agregar("J");

        ListaSimple listaI= new ListaSimple();
        listaI.agregar("J");


        List<ListaSimple> listaDeAdya= Arrays.asList(listaA,listaB,listaC, listaD,listaE,listaF,listaG,listaH,listaI);
        listaDeAdya.forEach(n->n.imprimir());
    }
}
