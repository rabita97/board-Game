import java.awt.*;

//defining the SlowPiece class
public class SlowPiece extends Piece {

    //instance variable
    private String pieceType = "S";

    //constructor
    public SlowPiece(String name, String colour, Point position){
        super(name, colour, position);
    }

    /**
     * creating the move method to move the piece left or right by one space
     * @param direction
     */
    public void move(String direction) {
        if(direction.equals("right")) {
            if(super.getPosition().x + 1  > 7) {
                System.out.println("error: piece can not be moved");
            }
            else{
                super.setPosition(position.x +1, position.y);
            }

        }
        else if(direction.equals("left")){
            if(super.getPosition().x -1< 0 ){
                System.out.println("error: piece can not be moved");
            }
            else{
                super.setPosition(position.x -1, position.y);
            }
        }

    }

    //toString method

    @Override
    public String toString() {
        return super.toString() + pieceType;
    }

}
