package SistemaGestionEmpleados;

public abstract class Empleado {
    protected String nombre;
    protected int id;
    protected double sueldoBase;


    private static final double SUELDO_BASE=150000;

    public Empleado(){}

    public Empleado(String nombre){
        this.nombre=nombre;
        this.sueldoBase= SUELDO_BASE;
    }

    public abstract double calcularSueldo();

    public void setId(int id) {
        this.id = id;
    }

    public int getId(){
        return id;
    }

    public void setNombre(String nombre){
        this.nombre= nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setSueldoBase(double sueldoBase){
        this.sueldoBase= sueldoBase;
    }

    public double getSueldoBase() {
        return sueldoBase;
    }


    
}
