import java.awt.*;

//defining the Board class that holds the 8X8 game board
public class Board {
    public Piece[][] board = new Piece[8][8];

    public Board(){
        for(int i = 0; i < board.length; i++){
            for (int j = 0; j < board.length; j++){
                board[i][j] = null;
            }
        }
    }
    /**
     * adding a new Piece to the game board only if none exist at that location
     * and displaying an error message if the Piece cannot be added
     * @param piece
     * @param x
     * @param y
     * @return
     */

    public String addPiece(Piece piece, int x, int y){
        if(board[x][y] != null){
            return "Error: Piece cannot be added";
        }
        else{
            board[x][y] = piece;
            return piece.getName() + piece.getClass() + " has been added." ;
        }
    }

    /**
     * moving a Piece at a given location in a given direction by a given number of spaces and displaying an error
     * message if the Piece cannot be moved.
     * @param x
     * @param y
     * @param direction
     * @param steps
     */
    public void move(int x, int y, String direction, int steps){

        if(board[y][x] instanceof SlowPiece){
            ((SlowPiece) board[y][x]).move(direction);
        }
        else if(board[y][x] instanceof SlowFlexible){
            ((SlowFlexible) board[y][x]).move(direction);
        }
        else if(board[y][x] instanceof FastPiece){
            ((FastPiece) board[y][x]).move(direction,steps);
        }
        else if (board[y][x] instanceof FastFlexible){
            ((FastFlexible) board[y][x]).move(direction, steps);
        }
        else {
            System.out.println("The piece at (" + x + "," + y + ") cannot be moved" );
            return;
        }

        board[ board[y][x].getPosition().y ][ board[y][x].getPosition().x ] = board[y][x];
        board[y][x] = null;

        System.out.println("Piece at (" + x + "," + y + ") moved " +direction+ " by " + steps+" spaces" );

    }

    public Piece getPiece(Point position){
        int x = (int)position.getX();
        int y = (int)position.getY();
        return board[x][y];
    }

    //displaying the game board

    public void display(){
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                if(board[i][j] == null){
                    System.out.print("     -     ");
                }
                else{
                    System.out.print(board[i][j]);
                }
            }
            System.out.println();
        }
    }
}
