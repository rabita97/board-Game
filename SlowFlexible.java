import java.awt.*;

//defining the SlowFlexible method

public class SlowFlexible extends SlowPiece {

    //constructor
    public SlowFlexible(String name, String colour, Point position) {
        super(name, colour, position);
    }

    /**
     * creating the move method
     * @param direction
     */
    public void move(String direction) {
        if(direction.equals("up")){
            if(super.getPosition().y - 1 < 0 ){
                System.out.println("error: piece can not be moved");
            }
            else{
                super.setPosition(position.x , position.y);
            }
        }
        else if(direction.equals("down")){
            if(super.getPosition().y + 1 > 7){
                System.out.println("error: piece can not be moved");
            }
            else{
                super.setPosition(position.x , position.y);
            }
        }
        else
        {
            super.move(direction);
        }

    }

    //toString method

    @Override
    public String toString() {
        return  super.toString() + "F";
    }
}
