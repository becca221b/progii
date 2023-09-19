package Practica_POO;

public class Lavarropas extends Electrodomestico {

    private int carga;

     private static final int CARGA_DEFECTO=5;

     public Lavarropas(){}

     public Lavarropas(int precio,float peso){
         this.precio_base= precio;
         this.peso= peso;
     }

     public Lavarropas(int carga){
         super();
         this.carga= carga;
     }

     public int getCarga() {
        return carga;
     }
    /*
     @Override
     public double precioFinal(){

     }*/
}
