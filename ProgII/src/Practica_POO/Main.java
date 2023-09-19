package Practica_POO;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Electrodomestico elec1= new Electrodomestico(10000,15);
        System.out.println(elec1.precioFinal(elec1.consumo_energetico,elec1.peso,elec1.precio_base));
    }
}
