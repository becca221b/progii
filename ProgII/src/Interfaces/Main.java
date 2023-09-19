package Interfaces;

public class Main {
    public static void main(String[] args) {
        MovablePoint point= new MovablePoint(0,0,0,0);
        point.moveUp();
        System.out.println(point.toString());

        MovableCircle circle = new MovableCircle(1,-1, -1, 0, 0);
        circle.moveRight();
        System.out.println(circle.toString());
    }
}
