package POO_Advanced;

public class Main {
    public static void main(String[] args) {

        Circulo redondo1= new Circulo();

        Cylinder cilindro1= new Cylinder(2.0,3.0);

        System.out.println(cilindro1.getArea());

        System.out.println(cilindro1.getVolume());

        Cylinder cylinder2= new Cylinder();
        System.out.println(cylinder2.getVolume(3.0));

    }
}
