package Interfaces;

public class MovablePoint implements Movable {

    private int x;

    private int y;

    private int xSpeed;

    private int ySpeed;

    public MovablePoint(int x, int y, int xSpeed, int ySpeed) {
        this.x = x;
        this.y = y;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    @Override
    public String toString() {
        return "La posicion del punto es x="+this.x +" y="+ this.y;
    }

    @Override
    public void moveUp(){
        this.y+=1;
    }

    @Override
    public void moveDown(){
        this.y-=1;
    }

    @Override
    public void moveLeft(){
        this.x-=1;
    }

    @Override
    public void moveRight(){
        this.x+=1;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
