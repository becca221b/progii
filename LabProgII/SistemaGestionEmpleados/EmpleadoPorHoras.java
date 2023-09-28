package SistemaGestionEmpleados;

public class EmpleadoPorHoras extends Empleado implements Impuesto{

    private int horasTrabajadas;


    public EmpleadoPorHoras(String nombre, int horasTrabajadas){
        super(nombre);
        this.horasTrabajadas= horasTrabajadas;
    }
    @Override
    public double calcularSueldo() {
        return super.sueldoBase=200*this.horasTrabajadas;
    }

    public double calcularImpuesto(){
        return this.calcularSueldo()*0.05;
    }
}
