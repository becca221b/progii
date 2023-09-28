import java.io.*;
import java.util.LinkedList;



public class Universidad {
    public static void main(String[] args){
        Curso curso = new Curso("Lab II");
        curso.agregar(new Estudiante("Jorgito",1231));
        curso.agregar(new Estudiante("Fernandito",1232));
        curso.agregar(new Estudiante("Cris",1233));

        Serializador serializador= new Serializador();
        serializador.serializar(curso);

        Curso cursoDeserializado = serializador.deserializar();
        System.out.println(String.format("%20s\t%20s","Legajo","Nombre"));
        for(Estudiante estudiante: cursoDeserializado.estudianteLinkedList){

            System.out.println(String.format("%20s\t%20s",estudiante.legajo,estudiante.nombre));
        }
    }
}


class Serializador{
    public void serializar(Curso curso){

        try {
            FileOutputStream archivoSalida = new FileOutputStream("curso.txt");
            ObjectOutputStream salida= new ObjectOutputStream(archivoSalida);
            salida.writeObject(curso);
            salida.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public Curso deserializar() {
        Curso curso = null;
        try {
            FileInputStream archivoEntrada = new FileInputStream("curso.txt");
            ObjectInputStream entrada = new ObjectInputStream(archivoEntrada);
            curso = (Curso) entrada.readObject();
            entrada.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return curso;
    }
}

class Curso implements Serializable{
    transient LinkedList<Estudiante> estudianteLinkedList;
    String nombre;

    public Curso(String nombre) {
        this.nombre = nombre;
        estudianteLinkedList = new LinkedList<>();
    }

    public void agregar(Estudiante estudiante){
        estudianteLinkedList.add(estudiante);
    }

    public void eliminar(int legajo){
        for(Estudiante estudiante: estudianteLinkedList){
            if(estudiante.legajo==legajo){
                estudianteLinkedList.remove(estudiante);
            }
        }
    }

    public void modificar(int legajo, String nombre){
        for(Estudiante estudiante: estudianteLinkedList){
            if(estudiante.legajo==legajo){
                estudiante.nombre= nombre;
                break;
            }
        }
    }

    //Métodos para serializar y deserializar
    private void writeObject(ObjectOutputStream out) throws IOException{
        out.defaultWriteObject();
        out.writeObject(estudianteLinkedList);
    }

    private void readObject(ObjectInputStream in) throws IOException,ClassNotFoundException{
        in.defaultReadObject();
        estudianteLinkedList= (LinkedList<Estudiante>) in.readObject();
    }

}

class Estudiante implements Serializable{
    String nombre;
    int legajo;

    public Estudiante(String nombre, int legajo) {
        this.nombre = nombre;
        this.legajo = legajo;
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "nombre='" + nombre + '\'' +
                ", legajo=" + legajo +
                '}';
    }
}