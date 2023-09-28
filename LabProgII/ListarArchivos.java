package Archivos;

import java.io.File;

public class ListarArchivos {
    public static void main(String[] args){
        File directorio = new File("F:\\tup\\Lab ProgII\\src");

        String [] nombres = directorio.list();

        // lista todos los elementos que se enceuntran en la carpeta
        System.out.println("Listado de archivos:");

        for(int i = 0; i<nombres.length;i++){
            System.out.println(nombres[i]);
        }
    }
}
