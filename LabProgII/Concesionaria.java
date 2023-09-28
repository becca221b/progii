import java.io.*;
import java.util.ArrayList;

public class Concesionaria_Ejercicio {
    public static void main(String[] args) {

        Concesionaria concesionaria= new Concesionaria();

        Vehiculo moto1= new Moto("Yamaha","Krypton",1000);
        concesionaria.agregarVehiculo(moto1);


        Vehiculo auto1= new Coche("Fiat","Uno",8000);
        concesionaria.agregarVehiculo(auto1);

        concesionaria.agregarVehiculo(new Coche("Jeep","Willys",5000));
        concesionaria.agregarVehiculo(new Moto("Ducati","Monster",6000));

        //concesionaria.mostrarInventario();

        //concesionaria.editarPrecio("Fiat","Uno",7500);
        //concesionaria.eliminarVehiculo("Fiat","Uno");

        Serializador serializador= new Serializador();
        serializador.serializar(concesionaria);

        Concesionaria cDeserializada = serializador.deserializar();
        System.out.println(String.format("%20s\t%20s\t%20s","Marca","Modelo","Precio"));
        for(Vehiculo v: cDeserializada.vehiculos){

            System.out.println(String.format("%20s\t%20s\t%20s",v.marca,v.modelo,v.precio));
        }

    }
}

    class Serializador{
        public void serializar(Concesionaria concesionaria){

            try {
                FileOutputStream archivoSalida = new FileOutputStream("concesionaria.txt");
                ObjectOutputStream salida= new ObjectOutputStream(archivoSalida);
                salida.writeObject(concesionaria);
                salida.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        public Concesionaria deserializar() {
            Concesionaria concesionaria = null;
            try {
                FileInputStream archivoEntrada = new FileInputStream("concesionaria.txt");
                ObjectInputStream entrada = new ObjectInputStream(archivoEntrada);
                concesionaria = (Concesionaria) entrada.readObject();
                entrada.close();

            } catch (Exception e) {
                e.printStackTrace();
            }

            return concesionaria;
        }
    }

    abstract class Vehiculo implements Serializable{
        protected String marca;
        protected String modelo;
        protected double precio;

        Vehiculo(String marca, String modelo, double precio){
            this.marca= marca;
            this.modelo= modelo;
            this.precio= precio;
        }

        public String getMarca() {
            return marca;
        }

        public void setMarca(String marca) {
            this.marca = marca;
        }

        public String getModelo() {
            return modelo;
        }

        public void setModelo(String modelo) {
            this.modelo = modelo;
        }

        public double getPrecio() {
            return precio;
        }

        public void setPrecio(double precio) {
            this.precio = precio;
        }

        //metodos
        public abstract double calcularImpuesto();

        public abstract void mostrarInformacion();

    }

    class Coche extends Vehiculo implements Serializable{
        Coche(String marca, String modelo, double precio){
            super(marca,modelo,precio);
        }

        @Override
        public double calcularImpuesto() {
            return this.precio*0.25;
        }

        @Override
        public void mostrarInformacion() {
            System.out.println("Marca: "+this.marca);
            System.out.println("Modelo: "+this.modelo);
            System.out.println("Precio: "+this.precio);
            System.out.println("Impuesto: "+this.calcularImpuesto());
        }
    }

    class Moto extends Vehiculo implements Serializable{

        Moto(String marca, String modelo, double precio){
            super(marca,modelo,precio);
        }

        @Override
        public double calcularImpuesto() {
            return this.precio*0.1;
        }

        @Override
        public void mostrarInformacion() {
            System.out.println("Marca: "+this.marca);
            System.out.println("Modelo: "+this.modelo);
            System.out.println("Precio: "+this.precio);
            System.out.println("Impuesto: "+this.calcularImpuesto());
        }
    }

    /*
    interface Serializable {
        void guardar();

        void cargar();
    }*/

    class Concesionaria implements Serializable {
        transient ArrayList<Vehiculo> vehiculos;

        Concesionaria(){
            this.vehiculos= new ArrayList<Vehiculo>();
        }

        public void agregarVehiculo(Vehiculo vehiculo){
            vehiculos.add(vehiculo);
        }

        public void eliminarVehiculo(String marca, String modelo){
            for(Vehiculo auto:vehiculos){
               if(auto.marca.equals(marca)&&auto.modelo.equals(modelo)){
                   vehiculos.remove(auto);
               }else{
                   System.out.println("Vehiculo not found");
               }
            }
        }

        public void editarPrecio(String marca, String modelo, double nuevoPrecio){
            for(Vehiculo v : vehiculos){
                if(v.marca.equals(marca)&&v.modelo.equals(modelo)){
                    v.setPrecio(nuevoPrecio);
                    break;
                }else{
                    System.out.println("Vehiculo not found");
                }
            }
        }

        public void mostrarInventario(){
            System.out.println(String.format("%20s\t%20s\t%20s","Marca","Modelo", "Precio"));
            for(Vehiculo auto:vehiculos){
                System.out.println(String.format("%20s\t%20s\t%20s",auto.marca,auto.modelo,auto.precio));
            }
        }

        //Métodos para serializar y deserializar
        private void writeObject(ObjectOutputStream out) throws IOException{
            out.defaultWriteObject();
            out.writeObject(vehiculos);
        }

        private void readObject(ObjectInputStream in) throws IOException,ClassNotFoundException{
            in.defaultReadObject();
            vehiculos= (ArrayList<Vehiculo>) in.readObject();
        }



    }


