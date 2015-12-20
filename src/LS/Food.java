package LS;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public abstract class Food {
    private int x;
    private int y;
    private int id;
    private int cal;
    private Circle image;

    public Food(int xIn, int yIn, int id, int calIn, Color colour, int size){
        setX(xIn);
        setY(yIn);
        setCal(calIn);
        setID(id);
        setImage(new Circle(getX(), getY(), size));
        getImage().setFill(colour);
    }

    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }

    public int getID(){
        return this.id;
    }
    public void setID(int id){
        this.id = id;
    }

    public int getCal() {
        return cal;
    }
    public void setCal(int cal) {
        this.cal = cal;
    }

    public Circle getImage() {
        return image;
    }

    public void setImage(Circle image) {
        this.image = image;
    }

}