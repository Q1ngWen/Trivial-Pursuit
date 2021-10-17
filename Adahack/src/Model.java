import java.util.*;

public class Model {
    //size of the board
    private static final int NUM_ROWS = 11;
    private static final int NUM_COLS = 11;
    private String[][] board;

    private int[] players;
    private int currentPlayer;
    private int dice;
    private String[] boardCoordinates;
    private char currentSymbol;
    private String[] artsLitQ;
    private String[] histQ;
    private  String[] figQ;
    private String[] cultQ;

    private String[] artsLitA;
    private String[] histA;
    private  String[] figA;
    private String[] cultA;

    private int[] positions;
    private String[] tempHolder;
    private int[][] scores;

    public Model() {
        players = new int[]{1, 2, 3, 4};
    }

    public String board_layout() {
        String rowDivider = "-".repeat(5 * NUM_COLS+1);
        StringBuilder sb = new StringBuilder();

        //setting an empty board
        for (int row = 0; row < board.length; row++){
            sb.append("\n");
            sb.append(rowDivider);
            sb.append("\n");

            for(int col = 0;col < board[0].length; col++){

                if (row == 0 || row == 5 || row == 10){

                    if( col == 0){
                        sb.append("| " + board[row][col] + " |");
                    } else if (col == 10){
                        sb.append("  " + board[row][col] + " |");
                    } else {
                        sb.append("  " + board[row][col] + " |");
                    }

                } else if (col == 0 ){
                    sb.append("| " + board[row][col] + " |");
                } else if (col == 4 || col == 9 ) {
                    sb.append("  " + board[row][col] + " |");
                } else if (col == 5 || col == 10){
                    sb.append("  " + board[row][col] + " |");
                } else {
                    sb.append("  " + board[row][col] + "  ");
                }

            }
        }
        sb.append("\n");
        sb.append(rowDivider);
        sb.append("\n");

        String boardString = sb.toString();

        return boardString;
    }

    public void clearBoard(String[][] board){
        String[] symbols = new String[]{"?", "~", "#", "*"};
        String[] symbols2 = new String[]{"~", "#", "*", "?"};

        for(int row = 0; row < board.length; row++){
            for(int col = 0; col < board[0].length; col++){
                if (row == 5 && col == 5){
                    board[row][col] = " ";
                } else if (row == 0 || row == 5 || row == 10){
                    board[row][col] = symbols[col%4];
                } else if(col == 0 || col == 5 || col == 10){
                    board[row][col] = symbols2[row%4];
                } else {
                    board[row][col] = " ";
                }
            }
        }
    }

    public void makeMove(int dice, int currentPlayer){
        int index = currentPlayer-1;
        if (positions[index] == 0){
            positions[index] += dice - 1;
        } else {
            positions[index] += dice;
        }

//        System.out.println(getPlayerCoordinates(currentPlayer)[positions[index]]);
        tempHolder[index] = getPlayerCoordinates(currentPlayer)[positions[index]];
//        char currentSymbol = (tempHolder[index].toCharArray())[0];
        currentSymbol = tempHolder[index].charAt(0);

        int currentRow = 0;
        int currentCol = 0;
        System.out.println(tempHolder[index].charAt(2));
        if (tempHolder[index].charAt(1) == '0'){
            currentRow = Character.getNumericValue(tempHolder[index].charAt(2));
        } else {
            currentRow = Integer.parseInt(tempHolder[index].substring(1,2));
        }
        if (tempHolder[index].charAt(3) == '0') {
            currentCol = Character.getNumericValue(tempHolder[index].charAt(4));
        } else {
            currentCol = Integer.parseInt(tempHolder[index].substring(3,4));
        }

        board[currentRow][currentCol] = String.valueOf(currentPlayer);

    }

    public int diceMoves(){
        dice = 1 + (int)(Math.random()*6);
        return dice;
    }

    public boolean checkCorrectAnswer(int questionIndex, char answer){
        return true;
    }

    public String scores(){
        return "";
    }

    //setters
    public void setBoard(){
        board = new String[NUM_ROWS][NUM_COLS];
        clearBoard(board);
    }
    public void  setPlayerScores(){
        scores = new int[4][4];
    }
    public void setCurrentPlayer(int player){
        currentPlayer = player;
    }
    public void setPositions(){
        positions = new int[]{0,0,0,0};
    }
    public void setTempHolder(){
        tempHolder = new String[]{"", "", "", ""};
    }

    //getters
    public String[][] getBoard(){
        return board;
    }
    public int[] getPlayers(){
        return players;
    }
    public int getDice(){
        return dice;
    }
    public int getScore(int player, String symbol){
        int score = 0;
        if (symbol.equals("?")){
            scores[player-1][0] += 1;
            score = scores[player-1][0];
        } else if (symbol.equals("~")){
            scores[player-1][1] += 1;
            score = scores[player-1][1];
        } else if (symbol.equals("#")){
            scores[player-1][2] += 1;
            score = scores[player-1][2];
        } else if (symbol.equals("*")){
            scores[player-1][3] += 1;
            score = scores[player-1][3];
        }
        return score;
    }
    public int getCurrentPlayer(){
        return currentPlayer;
    }
    public String[] getBoardCoordinates(){
        boardCoordinates = new String[]{board[0][0]+"0000", board[0][1]+"0001", board[0][2]+"0002", board[0][3]+"0003", board[0][4]+"0004",
                                 board[0][5]+"0005", board[0][6]+"0006", board[0][7]+"0007", board[0][8]+"0008", board[0][9]+"0009",
                                 board[0][10]+"0010", board[1][10]+"0110", board[2][10]+"0210", board[3][10]+"0310", board[4][10]+"0410",
                                 board[5][10]+"0510", board[6][10]+"0610", board[7][10]+"0710", board[8][10]+"0810", board[9][10]+"0910",
                                 board[10][10]+"1010", board[10][9]+"1009", board[10][8]+"1008", board[10][7]+"1007", board[10][6]+"1006",
                                 board[10][5]+"1005", board[10][4]+"1004", board[10][3]+"1003", board[10][2]+"1002", board[10][1]+"1001",
                                 board[10][0]+"1000", board[9][0]+"0900", board[8][0]+"0800", board[7][0]+"0700", board[6][0]+"0600",
                                 board[5][0]+"0500",board[4][0]+"0400", board[3][0]+"0300", board[2][0]+"0200", board[1][0]+"0100"};
        return boardCoordinates;
    }
    public String[] getInnerBoardCoordinates(){
        String[] innerBoardCoordinates = new String[]{
                board[4][5]+"0405", board[3][5]+"0305", board[2][5]+"0205", board[1][5]+"0105", board[5][6]+"0506",
                board[5][7]+"0507", board[5][8]+"0508", board[5][9]+"0509", board[6][5]+"0605", board[7][5]+"0705",
                board[8][5]+"0805", board[9][5]+"0905", board[5][4]+"0504", board[5][3]+"0503", board[5][2]+"0502", board[5][1]+"0501"};
        return innerBoardCoordinates;
    }
    public String[] getPlayerCoordinates(int currentPlayer){
        String[] innerCoordinates = new String[4];
        String[] outerCoordinates = new String[40];
        String[] finalCoordinates = new String[44];
        if (currentPlayer == 1){
            innerCoordinates = Arrays.copyOfRange(getInnerBoardCoordinates(), 0, 4);
            outerCoordinates = splitArr(getBoardCoordinates(), 40, 5);
            List<String> tempFinal = new ArrayList<>(44);
            Collections.addAll(tempFinal, innerCoordinates);
            Collections.addAll(tempFinal, outerCoordinates);
            tempFinal.toArray(finalCoordinates);
        } else if (currentPlayer == 2){
            innerCoordinates = Arrays.copyOfRange(getInnerBoardCoordinates(), 4, 8);
            outerCoordinates = splitArr(getBoardCoordinates(), 40, 15);
            List<String> tempFinal = new ArrayList<>(44);
            Collections.addAll(tempFinal, innerCoordinates);
            Collections.addAll(tempFinal, outerCoordinates);
            tempFinal.toArray(finalCoordinates);
        } else if (currentPlayer == 3){
            innerCoordinates = Arrays.copyOfRange(getInnerBoardCoordinates(), 8, 12);
            outerCoordinates = splitArr(getBoardCoordinates(), 40, 25);
            List<String> tempFinal = new ArrayList<>(44);
            Collections.addAll(tempFinal, innerCoordinates);
            Collections.addAll(tempFinal, outerCoordinates);
            tempFinal.toArray(finalCoordinates);
        } else if (currentPlayer == 4){
            innerCoordinates = Arrays.copyOfRange(getInnerBoardCoordinates(), 12, 16);
            outerCoordinates = splitArr(getBoardCoordinates(), 40, 35);
            List<String> tempFinal = new ArrayList<>(44);
            Collections.addAll(tempFinal, innerCoordinates);
            Collections.addAll(tempFinal, outerCoordinates);
            tempFinal.toArray(finalCoordinates);
        }
        return finalCoordinates;
    }
    public char getCurrentSymbol(){
        return currentSymbol;
    }

    //helper functions
    public static String[] splitArr(String arr[], int n, int k) {
        for (int i = 0; i < k; i++) {
            String x = arr[0];
            for (int j = 0; j < n - 1; ++j)
                arr[j] = arr[j + 1];
            arr[n - 1] = x;
        }
        return arr;
    }

    //quiz questions
    public String[] setArtsLitQ(){
        artsLitQ = new String[] {"Famous Colombian novelist, won the Nobel Prize in 1982. " + "\n" +
                "a) Mario Vargas Llosa" +"\n" +
                "b)  Octavio Paz" +"\n" +
                "c) Gabriel Garcia Marquez" +"\n" +
                "d) Juan Rulfo",
                "What is the title of Nelson Mandela's autobiography?" +"\n" +
                        "a) Africa, the Time has Come" +"\n" +
                        "b) Long Walk to Freedom" +"\n" +
                        "c) No Future without Forgiveness" +"\n" +
                        "d) Soft Vengeance of a Freedom Fighter",
                "Famous Colombian novelist, won the Nobel Prize in 1982. " +"\n" +
                        "a) Mario Vargas Llosa" +"\n" +
                        "b)  Octavio Paz" +"\n" +
                        "c) Gabriel Garcia Marquez" +"\n" +
                        "d) Juan Rulfo",
                "What is the title of Nelson Mandela's autobiography?" +"\n" +
                        "a) Africa, the Time has Come" +"\n" +
                        "b) Long Walk to Freedom" +"\n" +
                        "c) No Future without Forgiveness" +"\n" +
                        "d) Soft Vengeance of a Freedom Fighter",
                "Famous Colombian novelist, won the Nobel Prize in 1982. " +"\n" +
                        "a) Mario Vargas Llosa" +"\n" +
                        "b)  Octavio Paz" +"\n" +
                        "c) Gabriel Garcia Marquez" +"\n" +
                        "d) Juan Rulfo",
                "What is the title of Nelson Mandela's autobiography?" +"\n" +
                        "a) Africa, the Time has Come" +"\n" +
                        "b) Long Walk to Freedom" +"\n" +
                        "c) No Future without Forgiveness" +"\n" +
                        "d) Soft Vengeance of a Freedom Fighter"};
        return artsLitQ;
    }

    public String[] setArtsLitA(){
        artsLitA = new String[] {"a","b","a","b","a","b"};
        return artsLitA;
    }

    public String[] setHistQ(){
        histQ = new String[] {
                "Famous Colombian novelist, won the Nobel Prize in 1982. " + "\n" +
                        "a) Mario Vargas Llosa" +"\n" +
                        "b)  Octavio Paz" +"\n" +
                        "c) Gabriel Garcia Marquez" +"\n" +
                        "d) Juan Rulfo",
                "What is the title of Nelson Mandela's autobiography?" +"\n" +
                        "a) Africa, the Time has Come" +"\n" +
                        "b) Long Walk to Freedom" +"\n" +
                        "c) No Future without Forgiveness" +"\n" +
                        "d) Soft Vengeance of a Freedom Fighter",
                "Famous Colombian novelist, won the Nobel Prize in 1982. " +"\n" +
                        "a) Mario Vargas Llosa" +"\n" +
                        "b)  Octavio Paz" +"\n" +
                        "c) Gabriel Garcia Marquez" +"\n" +
                        "d) Juan Rulfo",
                "What is the title of Nelson Mandela's autobiography?" +"\n" +
                        "a) Africa, the Time has Come" +"\n" +
                        "b) Long Walk to Freedom" +"\n" +
                        "c) No Future without Forgiveness" +"\n" +
                        "d) Soft Vengeance of a Freedom Fighter",
                "Famous Colombian novelist, won the Nobel Prize in 1982. " +"\n" +
                        "a) Mario Vargas Llosa" +"\n" +
                        "b)  Octavio Paz" +"\n" +
                        "c) Gabriel Garcia Marquez" +"\n" +
                        "d) Juan Rulfo",
                "What is the title of Nelson Mandela's autobiography?" +"\n" +
                        "a) Africa, the Time has Come" +"\n" +
                        "b) Long Walk to Freedom" +"\n" +
                        "c) No Future without Forgiveness" +"\n" +
                        "d) Soft Vengeance of a Freedom Fighter"
        };
        return histQ;
    }

    public String[] setHistA(){
        histA = new String[] {"a","b","a","b","a","b"};
        return histA;
    }

    public String[] setFigQ(){
        figQ = new String[] {
                "Famous Colombian novelist, won the Nobel Prize in 1982. " + "\n" +
                        "a) Mario Vargas Llosa" +"\n" +
                        "b)  Octavio Paz" +"\n" +
                        "c) Gabriel Garcia Marquez" +"\n" +
                        "d) Juan Rulfo",
                "What is the title of Nelson Mandela's autobiography?" +"\n" +
                        "a) Africa, the Time has Come" +"\n" +
                        "b) Long Walk to Freedom" +"\n" +
                        "c) No Future without Forgiveness" +"\n" +
                        "d) Soft Vengeance of a Freedom Fighter",
                "Famous Colombian novelist, won the Nobel Prize in 1982. " +"\n" +
                        "a) Mario Vargas Llosa" +"\n" +
                        "b)  Octavio Paz" +"\n" +
                        "c) Gabriel Garcia Marquez" +"\n" +
                        "d) Juan Rulfo",
                "What is the title of Nelson Mandela's autobiography?" +"\n" +
                        "a) Africa, the Time has Come" +"\n" +
                        "b) Long Walk to Freedom" +"\n" +
                        "c) No Future without Forgiveness" +"\n" +
                        "d) Soft Vengeance of a Freedom Fighter",
                "Famous Colombian novelist, won the Nobel Prize in 1982. " +"\n" +
                        "a) Mario Vargas Llosa" +"\n" +
                        "b)  Octavio Paz" +"\n" +
                        "c) Gabriel Garcia Marquez" +"\n" +
                        "d) Juan Rulfo",
                "What is the title of Nelson Mandela's autobiography?" +"\n" +
                        "a) Africa, the Time has Come" +"\n" +
                        "b) Long Walk to Freedom" +"\n" +
                        "c) No Future without Forgiveness" +"\n" +
                        "d) Soft Vengeance of a Freedom Fighter"};
        return figQ;
    }

    public String[] setFigA(){
        figA = new String[] {"a","b","a","b","a","b"};
        return figA;
    }

    public String[] setCultQ(){
        cultQ = new String[] {"Famous Colombian novelist, won the Nobel Prize in 1982. " + "\n" +
                "a) Mario Vargas Llosa" +"\n" +
                "b)  Octavio Paz" +"\n" +
                "c) Gabriel Garcia Marquez" +"\n" +
                "d) Juan Rulfo",
                "What is the title of Nelson Mandela's autobiography?" +"\n" +
                        "a) Africa, the Time has Come" +"\n" +
                        "b) Long Walk to Freedom" +"\n" +
                        "c) No Future without Forgiveness" +"\n" +
                        "d) Soft Vengeance of a Freedom Fighter",
                "Famous Colombian novelist, won the Nobel Prize in 1982. " +"\n" +
                        "a) Mario Vargas Llosa" +"\n" +
                        "b)  Octavio Paz" +"\n" +
                        "c) Gabriel Garcia Marquez" +"\n" +
                        "d) Juan Rulfo",
                "What is the title of Nelson Mandela's autobiography?" +"\n" +
                        "a) Africa, the Time has Come" +"\n" +
                        "b) Long Walk to Freedom" +"\n" +
                        "c) No Future without Forgiveness" +"\n" +
                        "d) Soft Vengeance of a Freedom Fighter",
                "Famous Colombian novelist, won the Nobel Prize in 1982. " +"\n" +
                        "a) Mario Vargas Llosa" +"\n" +
                        "b)  Octavio Paz" +"\n" +
                        "c) Gabriel Garcia Marquez" +"\n" +
                        "d) Juan Rulfo",
                "What is the title of Nelson Mandela's autobiography?" +"\n" +
                        "a) Africa, the Time has Come" +"\n" +
                        "b) Long Walk to Freedom" +"\n" +
                        "c) No Future without Forgiveness" +"\n" +
                        "d) Soft Vengeance of a Freedom Fighter"};
        return cultQ;
    }

    public String[] setCultA(){
        cultA = new String[] {"a","b","a","b","a","b"};
        return cultA;
    }
}
