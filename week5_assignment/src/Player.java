
public class Player {
	
	private char letter;
    private int score;
    private boolean turn; 
    private boolean isComputer;


    // Constructor
    public Player(char letter){
        this.letter = letter;
        this.isComputer = false;
        this.turn = false;
    }

    // Getters
    public char getLetter() {return letter;}
    public int getScore() {return score;}  
    public boolean getTurn() {return turn;}
    public boolean isComputer() {return isComputer;}
  
    // Setters
    public void setLetter(char letter) {this.letter = letter;}

    public void setScore(int score) {
        System.out.println(this.getLetter()+"\t gained a point!");
        this.score = score;
    }
    public void setTurn(boolean turn) {this.turn = turn;}
    public void setComputer(boolean computer) {isComputer = computer;}

}
