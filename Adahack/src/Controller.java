public class Controller {
    private final Model model;
    private final TextView view;

    public Controller(Model model, TextView view){
        this.model = model;
        this.view = view;
    }

    public void startSession(){
        boolean run = true;
        String[][] board = model.getBoard();
        int[] players = model.getPlayers();
        int playerTracker = 0;
        model.setCurrentPlayer(1);
        int currentPlayer = model.getCurrentPlayer();
        char currentSymbol = ' ';
        String temp1 = "", temp2 = "", temp3 = "", temp4 = "";

        String question = "";
        char answer = ' ';
        boolean correctAnswer = false;

        view.displayNewGameMessage();
        setUpGame();

        while(run){
            loadBoard();
            model.clearBoard(model.getBoard());

            view.displayDice();

            char diceAnswer = InputUtil.readCharFromUser();
            if (diceAnswer == 'Y'){
                model.diceMoves();
                view.displayDiceRoll(model.getDice());
                model.makeMove(model.getDice(), currentPlayer);
                currentSymbol = model.getCurrentSymbol();
                if (currentSymbol == '?'){
                    question = model.setArtsLitQ()[model.getDice()];
                    view.displayQuestion(question);
                    answer = InputUtil.readCharFromUser();
//                    if (answer == (model.setArtsLitA()[model.getDice()]).charAt(0)){
//
//                    }
                    // correctAnswer = model.checkCorrectAnswer(model.getDice(), answer);

                } else if (currentSymbol == '~'){
                    question = model.setHistQ()[model.getDice()];
                    view.displayQuestion(question);
                    answer = InputUtil.readCharFromUser();

                } else if (currentSymbol == '#'){
                    question = model.setCultQ()[model.getDice()];
                    view.displayQuestion(question);
                    answer = InputUtil.readCharFromUser();

                } else if (currentSymbol == '*'){
                    question = model.setFigQ()[model.getDice()];
                    view.displayQuestion(question);
                    answer = InputUtil.readCharFromUser();

                }

            }
            //if ()
        }

    }

    public void setUpGame(){
        model.setBoard();
        model.setPositions();
        model.setTempHolder();
    }

    public void loadBoard(){
        view.displayBoard(model.board_layout());
    }

}
