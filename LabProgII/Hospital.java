package Hospital2Parcial;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Hospital {
    private List<Paciente> listaPacientes;
    private List<Doctor> listaDoctores;

    public Hospital() {
        this.listaPacientes = new ArrayList<>();
        this.listaDoctores = new ArrayList<>();
    }

    public List<Paciente> getListaPacientes() {
        return listaPacientes;
    }

    public void guardarEnBD(Connection conexion) throws SQLException {
        String consulta = "UPDATE estudiantes SET nombre = ?, apellido = ?, legajo = ?, dni = ?, " +
                "fecha_nacimiento = ?, direccion = ?, telefono = ?, email = ? WHERE id = ?";

        // Crea un PreparedStatement para ejecutar la consulta SQL con valores reales.
        PreparedStatement preparedStatement = conexion.prepareStatement(consulta);

        listaPacientes.forEach(n-> {
            try {
                preparedStatement.setString(1, n.getNombre());
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }); // Asigna el valor del nuevo nombre.
        /*
        preparedStatement.setString(2, nuevoApellido); // Asigna el valor del nuevo apellido.
        preparedStatement.setString(3, nuevoLegajo); // Asigna el valor del nuevo legajo.
        preparedStatement.setString(4, nuevoDNI); // Asigna el valor del nuevo DNI.
        preparedStatement.setString(5, nuevaFechaNacimiento); // Asigna el valor de la nueva fecha de nacimiento.
        preparedStatement.setString(6, nuevaDireccion); // Asigna el valor de la nueva dirección.
        preparedStatement.setString(7, nuevoTelefono); // Asigna el valor del nuevo teléfono.
        preparedStatement.setString(8, nuevoEmail); // Asigna el valor del nuevo email.
        preparedStatement.setInt(9, id); // Asigna el ID del estudiante que se va a editar.);

        */




        preparedStatement.close();


    }

    public static void main(String[] args) {
        // Datos de conexión a la base de datos (ajusta estos valores según tu configuración)
        String url = "jdbc:mysql://localhost:3306/hospital_db";
        String usuario = "root";
        String pass = "";

        Scanner scanner = new Scanner(System.in);

        try {
            // Establecer la conexión a la base de datos
            Connection conexion = DriverManager.getConnection(url, usuario, pass);
            Hospital hospital= new Hospital();

            Paciente paciente3= new Paciente("Paciente 3",30,"Historial3");

            hospital.listaPacientes.add(paciente3);

            hospital.guardarEnBD(conexion);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}

abstract class Persona{
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

