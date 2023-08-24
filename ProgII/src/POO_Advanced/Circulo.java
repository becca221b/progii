package POO_Advanced;

import static java.lang.Math.PI;

public class Circulo {
    //atributos
    protected double radius;
    protected String color;

    //constructores
    public Circulo(){
        radius= 1.0;
        color="red";
    }


    public Circulo(double radius) {
        this.radius = radius;
        color="red";
    }

    public Circulo(double radius, String color) {
        this.radius = radius;
        color=this.color;
    }

    //métodos

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getArea(){
        return PI*Math.pow(radius,2);
    }

    public double getCircumference(){
        return 2*PI*radius;
    }
}
