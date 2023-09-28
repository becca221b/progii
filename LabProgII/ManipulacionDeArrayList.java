import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ManipulacionDeArrayList {

    public static void main(String[] args){

        Scanner scanner= new Scanner(System.in);

        //Crear un ArrayList
        ArrayList<Integer> miLista = new ArrayList<>(
                Arrays.asList(1,2,3,4,5));

        /*ArrayList<Integer> miLista= new ArrayList<>(List of(1,2,3,4,5))*/


        //Leer desde el teclado y agregar a miLista
        System.out.println("Ingrese un numero a agregar a la lista");
        int n= scanner.nextInt();
        miLista.add(n);
        for(int elemento: miLista){
            System.out.print(elemento+"-");
        }

        //Mostrar el elemento en índice posicion de miLista
        System.out.println("\n\nIngrese la posicion de la que desea saber el contenido");
        try{
            int posicion= scanner.nextInt();
            //evaluar(posicion,miLista);
            System.out.println("El numero en la posicion "+posicion+ " es "+miLista.get(posicion));

        }catch(ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
            System.out.println("ERROR: Posicion del array debe ser mayor o igual a 0");
        }catch(IndexOutOfBoundsException e){
            e.printStackTrace();
            System.out.println("ERROR: Indice mayor al largo del arreglo");
        }


        System.out.println("\nIngrese el índice del elemento a eliminar");
        try{
            int indice= scanner.nextInt();
            evaluar(indice,miLista);
            miLista.remove(indice);
        }catch(Exception e){
            e.printStackTrace();
        }


        for(int elemento: miLista){
            System.out.print(elemento+"-");
        }

    }

    public static void evaluar(int nro, List<Integer> miLista) throws Exception{
        if(nro<0){
            throw new Exception("El índice no puede ser negativo");
        }
        if(miLista.size()<nro+1){
            throw new Exception("El índice no puede ser mayor al tamaño de la lista");
        }
    }
}
