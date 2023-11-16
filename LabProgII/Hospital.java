import java.sql.*;
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

    //5. Escribe un método para agregar un nuevo paciente al hospital.
    public void agregarPaciente(Paciente paciente){
        //listaPacientes.add(paciente);
        String consulta= "INSERT INTO pacientes(nombre, edad, historial_medico, doctor, fecha_ingreso) VALUES ('"+ paciente.getNombre() +"',"+ paciente.getEdad() +",'" + paciente.getHistorialMedico() +"',"+ paciente.getDoctor_id()+",'" + paciente.getFecha_ingreso() +"')";
        dbHelper.executeQueryWithUpdate(consulta);

    }

    //6. Escribe un método para mostrar la lista de pacientes.
    public void mostrarPacientes(){
        String consulta= "SELECT * FROM pacientes";
        ResultSet result= dbHelper.executeQueryWithReturn(consulta);
        mostrarPacientes(result);

    }

    public void mostrarPacientes(ResultSet result){
        if(result!=null){
            System.out.println("Lista de Pacientes:");
            System.out.printf("%-10s %-15s %-5s %-20s %-12s %-10s\n", "ID", "Nombre", "Edad", "Historial Médico", "Fecha Ingreso", "Doctor");

            try{
                while(result.next()){
                    int id= result.getInt("id");
                    String nombre= result.getString("nombre");
                    int edad= result.getInt("edad");
                    String historial= result.getString("historial_medico");
                    Date fecha= result.getDate("fecha_ingreso");
                    int id_doctor= result.getInt("doctor");


                    System.out.printf("%-10s %-15s %-5s %-20s %-12s %-10s\n", id, nombre, edad, historial,fecha, id_doctor);

                }
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
    }


    //7. Crea un método para asignar un doctor de cabecera a un paciente, indicando el nombre del doctor y del paciente.
    public void asignarDoctor(String nombreDoctor, String nombrePaciente){

        String consulta= "UPDATE `pacientes` SET `doctor` = (SELECT id FROM doctores WHERE nombre= '"+nombreDoctor+"') WHERE nombre= '"+nombrePaciente+"'" ;
        dbHelper.executeQueryWithUpdate(consulta);

    }

    //8. Desarrolla un método para mostrar la lista de pacientes que ingresaron entre dos fechas.
    public void mostrarPEntreFechas(String fechaInicio, String fechaFin){
        //Date fechaPrev= formatearFecha(fechaInicio);
        //Date fechaNext= formatearFecha(fechaFin);
        String consulta=" SELECT * FROM pacientes WHERE fecha_ingreso BETWEEN '"+fechaInicio+"' AND '"+fechaFin+"'";
        mostrarPacientes(dbHelper.executeQueryWithReturn(consulta));
    }

    /*
    public Date formatearFecha(String fecha){
        SimpleDateFormat formato= new SimpleDateFormat("yyyy/MM");
        Date fecha
        try {
            fFormateada= formato.parse(fecha);
            return fFormateada;
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }*/

    //9. Desarrolla un método en la clase Hospital que elimine un paciente indicando su nombre
    public void eliminarPaciente(String nombre){
        String consulta="DELETE FROM pacientes WHERE `pacientes`.`nombre` = '"+nombre+"'";
        dbHelper.executeQueryWithUpdate(consulta);
    }
}

abstract class Persona{
    //private int id;
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

}

class Paciente extends Persona{
    private String historialMedico;
    private String fecha_ingreso;
    private int doctor_id;

    public Paciente(String nombre, int edad, String historialMedico, int doctor_id, String fecha_ingreso) {
        super(nombre, edad);
        this.historialMedico = historialMedico;
        this.fecha_ingreso = fecha_ingreso;
        this.doctor_id= doctor_id;
    }

    public String getHistorialMedico() {
        return historialMedico;
    }

    public void setHistorialMedico(String historialMedico) {
        this.historialMedico = historialMedico;
    }

    public String getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(String fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    public int getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(int doctor_id) {
        this.doctor_id = doctor_id;
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
    private static final String URL = "jdbc:mysql://localhost:3306/hospital";
    private static final String USER = "root";
    private static final String PASS = "";

    public static void executeQueryWithUpdate(String consulta){
        try {
            // Establecer la conexión a la base de datos
            Connection conexion = DriverManager.getConnection(URL,USER,PASS);

            try(PreparedStatement preparedStatement= conexion.prepareStatement(consulta)){
                //Ejecutar la consulta
                preparedStatement.executeUpdate();
            }
            conexion.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ResultSet executeQueryWithReturn(String consulta){
        try {
            // Establecer la conexión a la base de datos
            Connection conexion = DriverManager.getConnection(URL,USER,PASS);

            PreparedStatement preparedStatement= conexion.prepareStatement(consulta);
            //Ejecutar la consulta
            return preparedStatement.executeQuery();


        }catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


}

class Principal{
    public static void main(String[] args) {

        Hospital hospital= new Hospital();
        //Date fechaActual= new Date(2023 - 1900, 1 - 1, 10);
        Paciente paciente= new Paciente("Sergio",42,"Rabia",1, "2023-01-01");
        hospital.agregarPaciente(paciente);
        hospital.mostrarPacientes();

        //hospital.asignarDoctor("Doctor1","Carlos");
        //hospital.mostrarPacientes();

        //hospital.mostrarPEntreFechas("2022-01-01","2023-01-01");
        hospital.eliminarPaciente("Sergio");
        hospital.mostrarPacientes();


    }
}