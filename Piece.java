import java.awt.*;

//defining the Piece class
public class Piece {

    //instance variables
    protected String name;
    protected String colour;
    protected Point position;

    //constructor

    public Piece(String name, String colour, Point position) {
        this.name = name;
        this.colour = colour;
        this.position = position;
    }

    //getters

    public String getName(){
        return name;
    }
    public String getColour(){
        return colour;
    }
    public Point getPosition() {
        return position;
    }

    //setters

    public void setName(){
        this.name = name;
    }
    public void setColour(){
        this.colour = colour;
    }
    public void setPosition(int x, int y){
        this.position.x = x;
        this.position.y = y;
    }

    //toString method

    public String toString() {
        return name + colour ;
    }
}


