package SistemaGestionEmpleados;

public class EmpleadoComision extends Empleado implements Impuesto{

    private int ventasRealizadas;

    public EmpleadoComision(String nombre, int ventasRealizadas){
        super(nombre);
        this.ventasRealizadas= ventasRealizadas;

    }
    @Override
    public double calcularSueldo(){
        return super.sueldoBase+(10*this.ventasRealizadas);
    }

    public double calcularImpuesto(){
        return this.calcularSueldo()*0.15;
    }
}
