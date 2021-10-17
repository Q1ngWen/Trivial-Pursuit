public class TextView {
    public final void displayNewGameMessage() { System.out.println("New Game Started :D");}

    public final void displayBoard(String board){
        System.out.println(board);
    }

    public final void displayDice(){
        System.out.println("Enter Y to roll the dice.");
    }

    public final void displayDiceRoll(int diceRoll){
        System.out.println("Dice rolled: " + diceRoll);
    }

    public final void displayQuestion(String q){
        System.out.println(q);
    }

    public final void displayScores(int scoreA, int scoreB, int scoreC, int scoreD){
        System.out.println("Player A: " + scoreA);
        System.out.println("Player B: " + scoreB);
        System.out.println("Player C: " + scoreC);
        System.out.println("Player D: " + scoreD);
    }
}
