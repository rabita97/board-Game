import java.awt.*;

//defining the FastPiece class
public class FastPiece extends Piece {

    //instance variable
    private String pieceType = "F";

    //constructor
    public FastPiece(String name, String colour, Point position) {
        super(name, colour, position);
    }


    /**
     * creating the move method to move the piece left or right by a specified number of spaces
     * @param direction
     * @param n
     */
    public void move(String direction, int n) {
        if(direction.equals("right")){
            if(super.getPosition().x - n < 0 ){
                System.out.println("error: piece can not be moved");
            }
            else{
                super.setPosition(position.x -n , position.y);
            }
        }
        else if(direction.equals("left")){
            if(super.getPosition().y + n > 7){
                System.out.println("error: piece can not be moved");
            }
            else{
                super.setPosition(position.x +n , position.y);
            }
        }

    }

    //toString method

    @Override
    public String toString() {
        return super.toString() + pieceType;
    }
}
