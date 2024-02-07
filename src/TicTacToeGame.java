import java.util.Scanner;

public class TicTacToeGame {
    private TicTacToeBoard board;
    private boolean gameRunning;
    private Scanner scanner = new Scanner(System.in);
    public TicTacToeGame(){
        board = new TicTacToeBoard();
        gameRunning = true;
    }

    public void reset(){
        board = new TicTacToeBoard();
        gameRunning = true;
        board.print();
    }

    private void turn(String player, boolean AI){
        if (gameRunning){
            String answer = "";
            int selection = 0;
            if (AI){
                selection=TicTacToeAI.calculateMove(board.getBoard(), player);
                board.set(selection,player);
            } else {
                boolean goodResponse = false;
                while (!goodResponse){
                    System.out.println(player+"'s turn");
                    answer = scanner.nextLine();
                    if (!answer.isBlank()) {
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

    public boolean gameLoop(boolean AI){
        turn("X", false);
        turn("O", AI);
        return gameRunning;
    }
}
