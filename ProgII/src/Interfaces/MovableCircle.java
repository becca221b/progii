package Interfaces;

public class MovableCircle implements Movable {

    private int radius;

    private MovablePoint center;

    public MovableCircle(int radius, int x, int y, int xSpeed, int ySpeed) {
        this.radius = radius;
        this.center = new MovablePoint(x,y,xSpeed,ySpeed);
    }

    @Override
    public String toString() {
        return "La posicion del circulo es x="+center.getX() +" y="+ center.getY();
    }

    @Override
    public void moveUp(){
        this.center.moveUp();
    }

    @Override
    public void moveDown(){
        this.center.moveDown();
    }

    @Override
    public void moveLeft(){
        this.center.moveLeft();
    }

    @Override
    public void moveRight(){
        this.center.moveRight();
    }
}
