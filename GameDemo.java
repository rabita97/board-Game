import java.util.Scanner;
import java.awt.*;
import java.util.StringTokenizer;

//defining the GameDemo class

public class GameDemo {
    public static void main(String[] args) {
        Board board = new Board();

        //declaring the scanner
        Scanner in = new Scanner(System.in);
        String user_input;
        String input = "";

        //using a while loop to print outputs until the user enters "exit"

        while(!(input).equals("exit")){
            System.out.println("Enter a command (type help for details): ");
            user_input = in.nextLine();

            //using StringTokenizer

            StringTokenizer t = new StringTokenizer(user_input, " ");
            input = t.nextToken();

            //using if-else statements to print different outputs based on users inputs
            //for "help"
            if(input.equals("help")) {
                System.out.println("Possible commands are as follows:\n" +
                        "create location [fast][flexible]: Creates a new piece.\n" +
                        "move location direction [spaces]: Moves a piece.\n" +
                        "print: Displays the Board\n" +
                        "help: Displays help\n" +
                        "exit: Exits the program.");
            }
            else if (input.equals("print")){
                board.display();
            }

            //for "create"

            else if (input.equals("create")) {
                if (!t.hasMoreTokens()) {
                    System.out.println("Location is required");
                    continue;
                }
                String x = t.nextToken();
                Integer xpos = Integer.valueOf(x);
                if(!t.hasMoreTokens())  {
                    System.out.println("Location is required");
                    continue;
                }

                String y = t.nextToken();
                Integer ypos = Integer.valueOf(y);

                Point position = new Point(xpos, ypos);

                System.out.println("Input a name for the new piece: ");
                String name = in.nextLine();
                System.out.println("Input a colour for the new piece: ");
                String colour = in.nextLine();

                String typeOfPiece = "";
                while(t.hasMoreTokens()) {
                    typeOfPiece += t.nextToken();
                }

                if(typeOfPiece.equals("")) {
                    SlowPiece slow = new SlowPiece(name, colour, position);
                    board.addPiece(slow, xpos, ypos);
                }
                else if(typeOfPiece.equals("fast")) {
                    FastPiece fast = new FastPiece(name, colour, position);
                    board.addPiece(fast, xpos, ypos);
                }
                else if(typeOfPiece.equals("flexible")) {
                    SlowFlexible slowFlex = new SlowFlexible(name, colour, position);
                    board.addPiece(slowFlex, xpos, ypos);
                }
                else if(typeOfPiece.equals("fastflexible")) {
                    FastFlexible fastFlex = new FastFlexible(name, colour, position);
                    board.addPiece(fastFlex, xpos, ypos);
                }
                else {
                    System.out.println("Invalid Entry");
                }
            }

            //for "move"

            else if(input.equals("move")) {
                if(!t.hasMoreTokens()) {
                    System.out.println("Error: No direction provided");
                    continue;
                }
                String x = t.nextToken();
                Integer xpos = Integer.valueOf(x);
                if(!t.hasMoreTokens()) {
                    System.out.println("Error: No direction provided");
                    continue;
                }
                String y = t.nextToken();
                Integer ypos = Integer.valueOf(y);
                if(!t.hasMoreTokens()) {
                    System.out.println("Error: No direction provided");
                    continue;
                }
                String direction  = t.nextToken();

                int a = 1;
                if(t.hasMoreTokens()) {
                    String move = t.nextToken();
                    a = Integer.valueOf(move);
                }
                board.move(xpos, ypos, direction, a);
            }

            //for "exit"
            else if(input.equals("exit"))
            {
                break;
            }
            else {
                System.out.println("Error: Could not create piece.");
            }
        }
        System.out.println("Done.");
    }
}
