package POO;

public class Administrativo extends Persona{

    private String area;

    public Administrativo(String nombre, int dni, double sueldoBasico, String area) {
        super(nombre, dni, sueldoBasico);
        this.area = area;
    }


}

