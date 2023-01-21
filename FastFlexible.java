import java.awt.*;

//defining the FastFlexible class
public class FastFlexible extends FastPiece {

    //constructor

    public FastFlexible(String name, String colour, Point position) {
        super(name, colour, position);
    }

    /**
     * creating the move method
     * @param direction
     * @param n
     */
    public void move(String direction, int n) {
        if(direction.equals("up")){
            if(super.getPosition().y - n < 0 ){
                System.out.println("error: piece can not be moved");
            }
            else{
                super.setPosition(super.getPosition().x, super.getPosition().y -n);
            }
        }
        else if(direction.equals("down")){
            if(super.getPosition().y + n > 7){
                System.out.println("error: piece can not be moved");
            }
            else{
                super.setPosition(super.getPosition().x, super.getPosition().y + n);
            }
        }
        else
        {
            super.move(direction, n);
        }

    }

    @Override

    //toString method
    public String toString() {
        return super.toString() + "F";
    }
}
