import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Hospital{
    private List<Paciente> listaPacientes;
    private List<Doctor> listaDoctores;

    public Hospital() {
        this.listaPacientes = new ArrayList<>();
        this.listaDoctores = new ArrayList<>();
    }

    public List<Paciente> getListaPacientes() {
        return listaPacientes;
    }

    public List<Doctor> getListaDoctores() {
        return listaDoctores;
    }

    public void agregarPaciente(Paciente paciente){
        listaPacientes.add(paciente);
        dbHelper.save();

    }
}

abstract class Persona{
    private int id;
    private String nombre;
    private int edad;

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getId() {
        return id;
    }

}

class Paciente extends Persona{
    private String historialMedico;
    private LocalDate fecha_ingreso;
    private Doctor doctor;

    public Paciente(String nombre, int edad, String historialMedico) {
        super(nombre, edad);
        this.historialMedico = historialMedico;
    }

    public String getHistorialMedico() {
        return historialMedico;
    }

    public void setHistorialMedico(String historialMedico) {
        this.historialMedico = historialMedico;
    }

    public LocalDate getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(LocalDate fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
}

class Doctor extends Persona {
    private String especialidad;


    // Constructor y métodos necesarios

    public Doctor(String nombre, int edad, String especialidad) {
        super(nombre, edad);
        this.especialidad = especialidad;
    }

    //GETTERS Y SETTERS

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
}

class dbHelper{
    // Datos de conexión a la base de datos (ajusta estos valor0es según tu configuración)
    private String url = "jdbc:mysql://localhost:3306/hospital";
    private String usuario = "root";
    private String pass = "";


}

class Principal{
    public static void main(String[] args) {

    }
}
