import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class App {
	public static void main(String[] args) {
		
        boolean errorFlag = false;
        Scanner scan = new Scanner(System.in);
        int boardSize;
        Game game;

        System.out.println("<-------------SOS Game Is Running------------->");
    	System.out.println("Please write the board size of the game as a nxn \n"
    			+ "(the number should be between 3-7): ");

        try{
        	boardSize = scan.nextInt();
            Game.checkBoardSize(boardSize);
        } catch (IllegalArgumentException exception){
        	System.out.println("Invalid Range. The number must to be between 3 - 7!!\n"
    				+ "Please write again: ");
        	boardSize = scan.nextInt();
        } catch (InputMismatchException exception) {
        	System.out.println("Invalid Range. The number must to be between 3 - 7!!\n"
    				+ "Game created minimum value: 3");
        	boardSize = scan.nextInt();   
        }
        game = new Game(boardSize);

        Player currentPlayer;
        while (game.gameStatus()){
            game.printGameTable();
            
            int column, row;
            
            Random random = new Random();
             currentPlayer = game.turn();
            
             do{
                if(currentPlayer.isComputer()){
                    column = random.nextInt(game.getBoardSize()) + 1;
                    row = random.nextInt(game.getBoardSize()) + 1;
                }else {
                    System.out.print("Please insert column: ");
                    column = scan.nextInt();
                    System.out.print("Please insert row: ");
                    row = scan.nextInt();
                }
            }while (!game.makeMove(currentPlayer, column, row));

        }
    }

}
