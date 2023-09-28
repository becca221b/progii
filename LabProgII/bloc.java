package Bloc;


import java.io.*;
import java.util.Scanner;

public class bloc {
    public static void main(String[] args){
        Scanner scanner= new Scanner(System.in);
        System.out.println("Introduzca el texto");
        String tutexto= scanner.nextLine();
        Texto textito = new Texto(tutexto);


        Serializador serializador = new Serializador();
        serializador.serializar(textito);

        Texto textoDeserializado = serializador.deserializar();
        System.out.println(textoDeserializado.palabra);


    }
}

class Serializador{
    public void serializar(Texto texto) {
        try {
            // Crear un flujo de salida para escribir en un archivo llamado "curso.txt"
            FileOutputStream archivoSalida = new FileOutputStream("texto.txt");
            // Crear un flujo de objeto para escribir objetos en el flujo de salida
            ObjectOutputStream flujoSalida = new ObjectOutputStream(archivoSalida);
            // Escribir el objeto "curso" en el flujo de salida
            flujoSalida.writeObject(texto);
            // Importante: cerrar el flujo de salida para liberar recursos
            flujoSalida.close();
        } catch (Exception e) {
            e.printStackTrace(); // En caso de error, imprimir información de la excepción
        }
    }


    public Texto deserializar() {
        Texto texto = null;


        try {
            // Abrir un flujo de entrada para leer desde el archivo "curso.txt"
            FileInputStream archivoEntrada = new FileInputStream("texto.txt");
            // Crear un flujo de objeto para leer objetos desde el flujo de entrada
            ObjectInputStream flujoEntrada = new ObjectInputStream(archivoEntrada);
            // Leer el objeto serializado desde el flujo de entrada y convertirlo a un objeto Curso
            texto = (Texto) flujoEntrada.readObject();
            // Importante: cerrar el flujo de entrada para liberar recursos
            flujoEntrada.close();
        } catch (Exception e) {
            e.printStackTrace(); // En caso de error, imprimir información de la excepción
        }
        return texto; // Devolver el objeto Curso deserializado
    }

}

class Texto implements Serializable {

    String palabra;

    public Texto(String palabra) {
        this.palabra = palabra;
    }


    // Agregar métodos para serializar y deserializar estudiantes
    private void writeObject(ObjectOutputStream out) throws IOException {
        /**Se utiliza `throws IOException` para manejar posibles errores
         * con la entrada/salida de datos durante la serialización de la clase `Curso`.
         */
        out.defaultWriteObject(); // Llama al método predeterminado de serialización de la superclase
        out.writeObject(palabra); // Escribe la lista de estudiantes en el flujo de salida
    }


    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject(); // Llama al método predeterminado de deserialización de la superclase
        palabra = (String) in.readObject(); // Lee la lista de estudiantes desde el flujo de entrada
    }

}



