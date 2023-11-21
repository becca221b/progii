package Grafos;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Grafo {

    int[][] matrizPesos;
    String[] vertices;

    public Grafo(String[] vertices) {
        this.vertices = vertices;
        matrizPesos = new int[vertices.length][vertices.length];
    }

    public void conectar(String v1, String v2, int peso) {

        int index1 = busquedaIndex(v1);
        int index2 = busquedaIndex(v2);

        if (index1 != -1 && index2 != -1) {
            matrizPesos[index1][index2] = peso;
            matrizPesos[index2][index1] = peso;
        }
    }

    public void imprimir() {
        for (int i = 0; i < matrizPesos.length; i++) {
            for (int j = 0; j < matrizPesos.length; j++) {
                System.out.print(matrizPesos[i][j] + " ");
            }
            System.out.println();
        }
    }

    private int busquedaIndex(String v) {
        int resultado = -1;

        for (int i = 0; i < vertices.length; i++) {
            if (vertices[i].equals(v)) {
                resultado = i;
                break;
            }
        }

        return resultado;
    }

    public boolean esAdyacente(String v1, String v2){
        int index1= busquedaIndex(v1);
        int index2= busquedaIndex(v2);

        if (matrizPesos[index1][index2] != 0 || matrizPesos[index2][index1] != 0){
            return true;
        }else{
            return false;
        }

    }

    public String[] nodoAdyacente(String v){
        int index1= busquedaIndex(v);
        for (int i = 0; i < matrizPesos.length; i++) {
            for (int j = 0; j < matrizPesos.length; j++) {
                if(matrizPesos[i][j]!=0){
                    System.out.print(matrizPesos[i][j] + " ");
                }

            }
            //System.out.println();
        }
        return vertices;
    }

    //---------------------------------------------------------------------
    //ELIMINAR LAS CONEXIONES QUE TIENE UN NODO, O UNA DETERMINADA CONEXION
    public void eliminarConexion(String v1, String v2){
        int index1 = busquedaIndex(v1);
        int index2 = busquedaIndex(v2);

        if (matrizPesos[index1][index2] != 0 || matrizPesos[index2][index1] != 0){
            matrizPesos[index1][index2]=0;
            matrizPesos[index2][index1] = 0;
        }

    }
    //DISTANCIA ENTRE 2 NODOS

    //NODOS CONECTADOS
    //---------------------------------------------------------------------
}
class Main{
    public static void main(String args[]){
        //int[][] paresAdyacencia= {{0,1},{1,2},{2,4},{3,4},{1,3},{5,6}};
        //int [][] matrizAdyacencia= new int[7][7];

        /*
       List<List<String>> listaAdyacencia= Arrays.asList(Arrays.asList("B","C"),Arrays.asList("A","C"),Arrays.asList("B","A"));
       listaAdyacencia.forEach(System.out::println);
       System.out.println(listaAdyacencia);*/


       String[] vertices= {"A","B","C"};
       Grafo miGrafo= new Grafo(vertices);

       miGrafo.conectar("A","B",1);
       //miGrafo.conectar("B","C",1);
       miGrafo.conectar("C","A",1);

       miGrafo.imprimir();


       System.out.println(miGrafo.esAdyacente("A","C"));

       miGrafo.nodoAdyacente("A");

       //miGrafo.eliminarConexion("A","C");

       //miGrafo.imprimir();
    }
}