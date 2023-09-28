package SistemaGestionEmpleados;

public class EmpleadoAsalariado extends Empleado implements Impuesto{

    public EmpleadoAsalariado(String nombre){
        super(nombre);
    }
    public double calcularSueldo() {
        return super.sueldoBase;
    }

    public double calcularImpuesto(){
        return this.calcularSueldo()*0.1;
    }

    
}
