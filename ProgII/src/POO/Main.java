package POO;


import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Administrativo staff1 = new Administrativo("Juan", 123123, 10000, "Operador");
        System.out.println(staff1.sueldo());

        Docente prof1= new Docente("Roberto",25123456,20000,22,"titular");
        System.out.println(prof1.sueldo());
        /*
        Persona personas[]= new Persona[2];
        personas[0]= staff1;
        personas[1]=prof1;*/

        List<Persona> personas= new ArrayList <Persona>();
        personas.add(staff1);
        personas.add(prof1);

        for(Persona x: personas){
            System.out.println(x);
        }

        for(Persona x: personas){
            System.out.println(x.getSueldoBasico());
        }

        //System.out.println(staff1.getClass());

        String info= staff1 instanceof Administrativo ? "es admin": "no es admin";
        System.out.println(staff1.getNombre()+" "+info);

    }
}
