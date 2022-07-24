import java.util.Random;

public class Game {
	private int boardSize;
    private char[][] gameTable;
    static int moveStep = 0;
    private Player[] players;

    // Constructor
    public Game(int boardSize){
        this.boardSize = boardSize;
        this.moveStep = this.boardSize * this.boardSize ;
        createGame();
    }

    // Checks that the board size variable is valid or no
    static boolean checkBoardSize(int boardSize) throws IllegalArgumentException {
        if(boardSize >= 3 && boardSize <= 7) {
        	return true;
        }
        else {
        	throw new IllegalArgumentException();
        }
    }

    // Create game table board size
    void createGame(){
        Random random = new Random();

        //Init game table
        gameTable = new char[this.boardSize][this.boardSize];

        //Create players
        players = new Player[2];
        players[0] = new Player('S');
        players[0].setTurn(true);
        players[1] = new Player('O');

        //Random selections
        if(random.nextInt()%2 == 0) {
            players[0].setComputer(true);
        } else {
            players[1].setComputer(true);
        }
    }

    // Print Game Table
    void printGameTable(){
        for (int i = 0; i <= this.boardSize ; i++) {
            //Rows
            for (int j = 0; j <= this.boardSize ; j++) {
                //Columns
                if(i==0 && j==0) {
                    System.out.print("   \t|");
                }else if(i==0){
                    System.out.print(" "+j+"\t|");
                }else if (j==0){
                    System.out.print(" "+i+"\t|");
                } else {
                    System.out.print(" "+this.gameTable[i-1][j-1]+"\t|");
                }
            }
            System.out.println();
        }
    }

    // Manages the game moves
    boolean makeMove(Player player, int column, int row){
        if(!(column > boardSize || column < 0 || row > boardSize || row < 0)){
            if(gameTable[row-1][column-1] == '\u0000'){
                if(player.isComputer())
                    System.out.println("--------Computer playing--------\nColumn: "+column+"\tRow: "+row);
                else
                    System.out.println("--------User playing--------\nColumn: "+column+"\tRow: "+row);
                gameTable[row-1][column-1] = player.getLetter();
                this.moveStep --;
                checkScore(player,row-1,column-1);
                return true;
            } else {
                System.out.println("--------Please select the correct (2D matrix) indexes--------\n\n\n\n");
                return false;
            }
        }
        System.out.println("--------Please select the correct (2D matrix) indexes--------\n\n\n\n");
        return false;
    }

    // Checks the Game Over status
    boolean gameStatus(){
        if(Game.moveStep==0){
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n--------Game Over!--------\n\n"+"Player "+players[0].getLetter()+": "+players[0].getScore()+"    "
                                                                                   +"Player "+players[1].getLetter()+": "+players[1].getScore()+"\n\n");
            this.printGameTable();
            return false;
        }else{
            return true;
        }
    }


    // Manages the first person who plays
    Player turn(){
        if(players[0].getTurn()){
            players[0].setTurn(false);
            players[1].setTurn(true);
            return players[0];
        }
        else {
            players[1].setTurn(false);
            players[0].setTurn(true);
            return players[1];
        }
    }

    // Checks the score
    public void checkScore(Player player, int row, int column){
    	//'S' is given
        if(player.getLetter() == 'S'){      
            if(validatedReach(row - 1, column - 1) && gameTable[row-1][column-1] == 'O'){    
                if(validatedReach(row-2, column-2) && gameTable[row-2][column-2] == 'S'){
                    player.setScore(player.getScore() + 1);
                }
            }
            if(validatedReach(row, column-1) && gameTable[row][column-1] == 'O'){    
                if(validatedReach(row, column-2) && gameTable[row][column-2] == 'S'){
                    player.setScore(player.getScore() + 1);
                }
            }
            if(validatedReach(row+1, column-1) && gameTable[row+1][column-1] == 'O'){    
                if(validatedReach(row+2, column-2) && gameTable[row+2][column-2] == 'S'){
                    player.setScore(player.getScore() + 1);
                }
            }
            if(validatedReach(row-1, column) && gameTable[row-1][column] == 'O'){    
                if(validatedReach(row-2, column) && gameTable[row-2][column] == 'S'){
                    player.setScore(player.getScore() + 1);
                }
            }
            if(validatedReach(row-1, column+1) && gameTable[row-1][column+1] == 'O'){    
                if(validatedReach(row-2, column+2) && gameTable[row-2][column+2] == 'S'){
                    player.setScore(player.getScore() + 1);
                }
            }
            if(validatedReach(row, column+1) && gameTable[row][column+1] == 'O'){    
                if(validatedReach(row, column+2) && gameTable[row][column+2] == 'S'){
                    player.setScore(player.getScore() + 1);
                }
            }
            if(validatedReach(row+1, column+1) && gameTable[row+1][column+1] == 'O'){    
                if(validatedReach(row+2, column+2) && gameTable[row+2][column+2] == 'S'){
                    player.setScore(player.getScore() + 1);
                }
            }
            if(validatedReach(row+1, column) && gameTable[row+1][column] == 'O'){    
                if(validatedReach(row+2, column) && gameTable[row+2][column] == 'S'){
                    player.setScore(player.getScore() + 1);
                }
            }
        } else { // 'O' is given
            if(validatedReach(row-1, column-1) && gameTable[row-1][column-1] == 'S'){    
                if(validatedReach(row+1, column+1) && gameTable[row+1][column+1] == 'S'){
                    player.setScore(player.getScore() + 1);
                }
            }
            if(validatedReach(row, column-1) && gameTable[row][column-1] == 'S'){    
                if(validatedReach(row, column+1) && gameTable[row][column+1] == 'S'){
                    player.setScore(player.getScore() + 1);
                }
            }
            if(validatedReach(row+1, column-1) && gameTable[row+1][column-1] == 'S'){    
                if(validatedReach(row-1, column+1) && gameTable[row-1][column+1] == 'S'){
                    player.setScore(player.getScore() + 1);
                }
            }
            if(validatedReach(row-1, column) && gameTable[row-1][column] == 'S'){    
                if(validatedReach(row+1, column) && gameTable[row+1][column] == 'S'){
                    player.setScore(player.getScore() + 1);
                }
            }
            if(validatedReach(row-1, column+1) && gameTable[row-1][column+1] == 'S'){    
                if(validatedReach(row+1, column-1) && gameTable[row+1][column-1] == 'S'){
                    player.setScore(player.getScore() + 1);
                }
            }
            if(validatedReach(row, column+1) && gameTable[row][column+1] == 'S'){   
                if(validatedReach(row, column-1) && gameTable[row][column-1] == 'S'){
                    player.setScore(player.getScore() + 1);
                }
            }
            if(validatedReach(row+1, column+1) && gameTable[row+1][column+1] == 'S'){   
                if(validatedReach(row-1, column-1) && gameTable[row-1][column-1] == 'S'){
                    player.setScore(player.getScore() + 1);
                }
            }
            if(validatedReach(row+1, column) && gameTable[row+1][column] == 'S'){    
                if(validatedReach(row-1, column) && gameTable[row-1][column] == 'S'){
                    player.setScore(player.getScore() + 1);
                }
            }
        }
    }

    // Check array bounds
    public boolean validatedReach(int column, int row){
        if(column>=boardSize || row >= boardSize || column <0 || row <0) {
        	return false;
        }
        else {
        	return true;
        }
    }

    // Getter Method
    public int getBoardSize() {
        return boardSize;
    }

}
