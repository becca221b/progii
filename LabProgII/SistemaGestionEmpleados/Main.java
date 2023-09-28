package SistemaGestionEmpleados;

public class Main {
    public static void main(String[] args){
        EmpleadoComision empleadoComision= new EmpleadoComision("Roberto",14);
        EmpleadoAsalariado empleadoAsalariado= new EmpleadoAsalariado("Carlos");
        EmpleadoPorHoras empleadoPorHoras= new EmpleadoPorHoras("Fernando",4);

        System.out.println("Impuesto para un empleado por comision: "+empleadoComision.calcularImpuesto());
        System.out.println("Sueldo del empleado por comision\nNombre: "+empleadoComision.nombre+". Sueldo: "+empleadoComision.calcularSueldo()+"\n");

        GestorEmpleado gestorEmpleado= new GestorEmpleado();
        gestorEmpleado.agregar(empleadoComision);
        gestorEmpleado.agregar(empleadoAsalariado);
        gestorEmpleado.agregar(new EmpleadoAsalariado("Rogelio"));
        gestorEmpleado.agregar(empleadoPorHoras);

        System.out.println(gestorEmpleado.toString());

        gestorEmpleado.eliminar(3);
        System.out.println(gestorEmpleado.toString());

        gestorEmpleado.modificar(4,"Enrique");
        System.out.println(gestorEmpleado.toString());





    }
}
