package Practica_POO;


import java.util.ArrayList;
import java.util.Arrays;

public class Electrodomestico {

    protected double precio_base;
    protected String color;
    protected char consumo_energetico;
    protected float peso;
    protected int id;

    public static String marca="Samsung";
    public static int num_electrodomestico=1;

    private static final char CONSUMO_DEFECTO='F';
    private static final String COLOR_DEFECTO="BLANCO";
    

    private String colores[]= {"BLANCO","NEGRO","ROJO","AZUL","NEGRO"};
    private char letras[]={'A','B','C','D','E','F'};


    public Electrodomestico(){
        id= num_electrodomestico++;
        /*precio_base= 100000;
        peso= 5;
        color= COLOR_DEFECTO;
        consumo_energetico=CONSUMO_DEFECTO;*/
    }

    public Electrodomestico(double precio_base, float peso){
        this();
        this.precio_base= precio_base;
        this.peso= peso;
        color= COLOR_DEFECTO;
        consumo_energetico='F';
    }

    public Electrodomestico(double precio_base, String color, char consumo_energetico,float peso){
        this.precio_base= precio_base;
        this.peso= peso;
        this.comprobar_color(color);
        this.comprobar_letra(consumo_energetico);
    }

    private void comprobar_letra(char letra){
        if(letra>'A'&& letra<'F'){
            this.consumo_energetico= letra;
        }else{
            System.out.println("Valor incorrecto");
            this.consumo_energetico= CONSUMO_DEFECTO;
        }
    }


    private void comprobar_color(String color_selected){
        for (String color : colores){
            if(color_selected.compareToIgnoreCase(color)==0){
                this.color= color_selected;
            }
        }
        System.out.println("Color incorrecto");
        this.color= COLOR_DEFECTO;
    }

    public double precioFinal(char consumo_energetico, float tamaño, double precio_base){
        //String consumo= String. valueOf(consumo_energetico);
        int precios[]= {100,80,60,50,30,10};
        int index= Arrays.binarySearch(letras,consumo_energetico);
        System.out.println(index);
        double precio_final= this.precio_base+precios[index];
        if(tamaño>0&tamaño<=19){
            precio_final+=10;
        }
        if (tamaño>=20&tamaño<49){
            precio_final+=50;
        }
        if(tamaño>=50&tamaño<79){
            precio_final+=80;
        }
        if(tamaño>80){
            precio_final+=100;
        }
        return precio_final;
    }

    public double getPrecio_base() {
        return precio_base;
    }

    public String getColor() {
        return color;
    }

    public char getConsumo_energetico() {
        return consumo_energetico;
    }

    public float getPeso() {
        return peso;
    }
}
