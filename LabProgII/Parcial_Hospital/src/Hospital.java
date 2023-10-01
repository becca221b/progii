
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Hospital {
    public static void main(String[] args){

        Scanner scanner= new Scanner(System.in);

        String encabezado = "";
        try (Scanner entrada = new Scanner(new File("datos.txt"))) {
            encabezado = entrada.nextLine();
        } catch (FileNotFoundException e) {
            System.err.println("Error al leer los datos del hospital desde el archivo: " + e.getMessage());
        }


        GestorHospital gestorHospital= new GestorHospital();

        Doctor doctor1= new Doctor("Oscar Sanchez",30123123,"14-05-90","Cardiologia");
        Doctor doctor2= new Doctor("Juan Perez",20123123,"14-05-90","Hematologia");
        Doctor doctor3= new Doctor("Gino Infantino",16123123,"14-05-90","Clinico");

        Paciente paciente1= new Paciente("Jimena",36123123,"14-05-90",12356,"O+");
        Paciente paciente2= new Paciente("Rebe",35123123,"14-05-90",12356,"O+");
        Paciente paciente3= new Paciente("Luis",34123123,"14-05-90",12356,"O+");

        paciente1.agregarEvento(new Evento("23-08-2023","Gripe"));

        gestorHospital.agregarDoctor(doctor1);
        gestorHospital.agregarDoctor(doctor2);
        gestorHospital.agregarDoctor(doctor3);

        gestorHospital.agregarPaciente(paciente1);
        gestorHospital.agregarPaciente(paciente2);
        gestorHospital.agregarPaciente(paciente3);

        Serializador serializador= new Serializador();

        int opcion=1;
        while (opcion !=8) {
            System.out.println(encabezado);
            System.out.println("Menú:");
            System.out.println("1. Listar Doctores.");
            System.out.println("2. Registrar un nuevo paciente.");
            System.out.println("3. Actualizar informacion personal de un paciente.");
            System.out.println("4. Consultar el historial médico de un paciente.");
            System.out.println("5. Nuevo historial para un paciente.");
            System.out.println("6. Guardar Historial de pacientes en archivo.");
            System.out.println("7. Cargar Historial de pacientes desde archivo ");
            System.out.println("8. Salir");

            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    gestorHospital.listarDoctores();
                    break;
                case 2:
                    System.out.println("Ingrese nombre");
                    String nombre= scanner.nextLine();
                    scanner.nextLine();
                    System.out.println("Ingrese dni");
                    int dni= scanner.nextInt();
                    System.out.println("Ingrese fecha de naciemiento");
                    String fecha= scanner.next();
                    System.out.println("Ingrese telefono");
                    int telef= scanner.nextInt();
                    System.out.println("Tipo de sangre");
                    String tipo= scanner.nextLine();
                    gestorHospital.agregarPaciente(new Paciente(nombre,dni,fecha,telef,tipo));
                    System.out.println("Paciente guardado con exito");
                    break;
                case 3:
                    System.out.println("Ingrese el nuemro de dni del paciente a modificar");
                    gestorHospital.modificarPaciente(scanner.nextInt());

                    break;
                case 4:
                    System.out.println("Ingrese el nuemro de dni del paciente para consultar su historial");
                    gestorHospital.verHistorial(scanner.nextInt());
                    break;
                case 5:
                    System.out.println("Ingrese el numero de dni para agregar evento al historial");
                    gestorHospital.modificarHistorial(scanner.nextInt());
                    System.out.println("Evento agregado con éxito\n");
                    break;
                case 6:
                    System.out.println("Ingrese el dni del paciente cuyo historial desea guardar");
                    int buscado= scanner.nextInt();
                    for(Paciente p: gestorHospital.pacientes){
                        if(p.dni==buscado){
                            serializador.serializar(p);
                        }
                    }
                    break;
                case 7:
                    Paciente pDeserializado = serializador.deserializar();
                    System.out.println(String.format("%20s\t%20s","Fecha de evento","Observaciones"));
                    try{
                        for(Evento e: pDeserializado.historial){

                            System.out.println(String.format("%20s\t%20s",e.getFechaEvento(),e.getDetalle()));
                        }
                    }catch (NullPointerException npe){
                       System.out.println("Verifique el archivo a cargar");
                    }
                    break;
                case 8:
                    System.out.println("Chau chau, adiós");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, elija una opción válida.");
            }
        }

        scanner.close();
    }
}



abstract class Persona implements Serializable{
    protected String nombre;
    protected int dni;
    protected String fechaDeNac;

    Persona(){}

    public Persona(String nombre, int dni, String fechaDeNac) {
        this.nombre = nombre;
        this.dni = dni;
        this.fechaDeNac = fechaDeNac;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getFechaDeNac() {
        return fechaDeNac;
    }

    public void setFechaDeNac(String fechaDeNac) {
        this.fechaDeNac = fechaDeNac;
    }
}

class Doctor extends Persona{
    private String especialidad;


    public Doctor(String nombre, int dni, String fechaDeNac, String especialidad) {
        super(nombre,dni,fechaDeNac);
        this.especialidad = especialidad;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
}

class Paciente extends Persona implements Informacion, Serializable{
    private int nro_telef;
    private String tipoDeSangre;
    transient ArrayList<Evento> historial;

    public Paciente(String nombre, int dni, String fechaDeNac, int nro_telef, String tipoDeSangre) {
        super(nombre, dni, fechaDeNac);
        this.nro_telef = nro_telef;
        this.tipoDeSangre = tipoDeSangre;
        this.historial = new ArrayList <>();
    }

    public int getNro_telef() {
        return nro_telef;
    }

    public void setNro_telef(int nro_telef) {
        this.nro_telef = nro_telef;
    }

    public String getTipoDeSangre() {
        return tipoDeSangre;
    }

    public void setTipoDeSangre(String tipoDeSangre) {
        this.tipoDeSangre = tipoDeSangre;
    }

    public ArrayList <Evento> getHistorial() {
        return historial;
    }

    public void setHistorial(ArrayList <Evento> historial) {
        this.historial = historial;
    }

    public void agregarEvento(Evento evento){
        historial.add(evento);
    }

    @Override
    public void verHistorialDeEventos() {
        for(Evento e: historial){
            System.out.println("Fecha: "+e.getFechaEvento()+" - "+e.getDetalle());
        }
        System.out.println("\n");
    }

    //Métodos para serializar y deserializar SIN TERMINAR
    private void writeObject(ObjectOutputStream out) throws IOException{
        out.defaultWriteObject();
        out.writeObject(historial);
    }
    private void readObject(ObjectInputStream in) throws IOException,ClassNotFoundException {
        in.defaultReadObject();
        historial = (ArrayList<Evento>) in.readObject();
    }
}

class Evento implements Serializable{
    private String fechaEvento;
    private String detalle;

    public Evento(String fechaEvento, String detalle) {
        this.fechaEvento = fechaEvento;
        this.detalle = detalle;
    }

    public String getFechaEvento() {
        return fechaEvento;
    }

    public void setFechaEvento(String fechaEvento) {
        this.fechaEvento = fechaEvento;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }
}

class GestorHospital implements Serializable {
    private ArrayList<Doctor> doctores;

    transient ArrayList<Paciente> pacientes;

    transient Scanner scanner = new Scanner(System.in);

    public GestorHospital() {
        this.doctores = new ArrayList<>();
        this.pacientes = new ArrayList<>();
    }

    //metodo para agregar doctor
    public void agregarDoctor(Doctor doctor) {
        this.doctores.add(doctor);
    }

    public void listarDoctores() {
        System.out.println(String.format("%20s\t%20s\t%20s", "Nombre", "DNI", "Fecha de Naciemiento"));
        for (Doctor d : doctores) {
            System.out.println(String.format("%20s\t%20s\t%20s", d.nombre, d.dni, d.fechaDeNac));
        }
        System.out.println("\n");
    }

    public void agregarPaciente(Paciente paciente) {
        this.pacientes.add(paciente);
    }

    public void modificarPaciente(int dni) {
        System.out.println("Ingrese el nuevo nro de telefono");
        int nroNuevo = scanner.nextInt();
        System.out.println("Ingrese el tipo de sangre");
        String otroTipo = scanner.next();

        for (Paciente p : pacientes) {
            if (p.dni == dni) {
                p.setNro_telef(nroNuevo);
                p.setTipoDeSangre(otroTipo);
                System.out.println("Paciente modificado con éxito");
                break;
            }
        }
    }

    public void modificarHistorial(int dni){
        System.out.println("Ingrese la fecha");
        String fecha= scanner.nextLine();
        System.out.println("Ingrese el detalle");
        String detalle= scanner.nextLine();

        for( Paciente p: pacientes){
            if(p.dni==dni){
                p.agregarEvento(new Evento(fecha,detalle));
                break;
            }
        }
    }

    public void verHistorial(int dni){
        for( Paciente p: pacientes){
            if(p.dni==dni){
                p.verHistorialDeEventos();
                break;
            }
        }
    }

}

interface Informacion{
    void verHistorialDeEventos();
}

class Serializador{
    public void serializar(Paciente paciente){

        try {
            FileOutputStream archivoSalida = new FileOutputStream("historial.txt");
            ObjectOutputStream salida= new ObjectOutputStream(archivoSalida);
            salida.writeObject(paciente);
            salida.close();
            System.out.println("Archivo guardado con éxito");
        }catch (NotSerializableException nse)
        {
            System.out.println("El objeto a ser serializado no implementa la interfaz Serializable");

        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }

    public Paciente deserializar() {
        Paciente paciente = null;
        try {
            FileInputStream archivoEntrada = new FileInputStream("historial.txt");
            ObjectInputStream entrada = new ObjectInputStream(archivoEntrada);
            paciente = (Paciente) entrada.readObject();
            entrada.close();

        } catch (FileNotFoundException cnfe)
        {
            System.out.println("No se encuentra el archivo a cargar");

        } catch (Exception e) {
            e.printStackTrace();
        }

        return paciente;
    }
}



