package games.UltimateTicTacToe;

import java.util.Scanner;

public class UltimateTicTacToeGame {
    private UltimateTicTacToeBoard board;
    private boolean gameRunning;
    private Scanner scanner = new Scanner(System.in);
    
    public UltimateTicTacToeGame(){
        board = new UltimateTicTacToeBoard();
        gameRunning = true;
    }

    public void reset(){
        board = new UltimateTicTacToeBoard();
        gameRunning = true;
        board.print();
    }

    private void turn(String player, boolean AI, boolean MORON){
        if (gameRunning){
            String answer = "";
            int selection = 0;
            if (AI){
                selection=UltimateTicTacToeAI.calculateMove(board.getBoard(), player, board.filledSquares());
                board.set(selection,player);
            } else if (MORON){
                selection=UltimateTicTacToeMoron.calculateMove(board.getBoard());
                board.set(selection,player);
            } else {
                boolean goodResponse = false;
                while (!goodResponse){
                    System.out.println(player+"'s turn");
                    answer = scanner.nextLine();
                    if (answer.length() == 2 && "ABC".indexOf(Character.toString(answer.charAt(0))) != -1 && "123".indexOf(Character.toString(answer.charAt(1))) != -1) {
                        selection = "ABC".indexOf(Character.toString(answer.charAt(0)))*3 + Integer.parseInt(Character.toString(answer.charAt(1))) - 1;
                    } else {
                        selection=-1;
                    }
                    if (selection > -1){
                        if (board.get(selection) == " "){
                            board.set(selection,player);
                            goodResponse = true;
                        }
                    }
                }
            }
        board.print();
        gameRunning=board.gameStatus();
        }
    }

    public boolean running(){
        return gameRunning;
    }

    public void gameLoop(int X, int O){
        // types based on smartness
        turn("X", (X==1), (X==-1));
        turn("O", (O==1), (O==-1));
    }

    public String winner(){
        return board.theWinner;
    }
}