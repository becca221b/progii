package POO;



public class Docente extends Persona{
    private String cargo;
    private int hsTrabajadas;


    public Docente(String nombre, int dni, double sueldoBasico, int hs, String cargo) {

        super(nombre, dni, sueldoBasico);
        this.hsTrabajadas = hs;
        this.cargo = cargo;
    }

    @Override
    public double sueldo() {
        double newSueldo= super.sueldo();
        if(hsTrabajadas>20){
            newSueldo*=1.2;
            return newSueldo;
        }else{
            return sueldoBasico;
        }

    }
}
