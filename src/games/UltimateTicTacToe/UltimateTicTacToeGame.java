package games.UltimateTicTacToe;

import java.util.Scanner;

public class UltimateTicTacToeGame {
    private UltimateTicTacToeBoard board;
    private boolean gameRunning;
    private Scanner scanner = new Scanner(System.in);
    private int lastMiniGame = -1;
    
    public UltimateTicTacToeGame(){
        board = new UltimateTicTacToeBoard();
        gameRunning = true;
    }

    public void reset(){
        board = new UltimateTicTacToeBoard();
        gameRunning = true;
        board.print(lastMiniGame);
    }
    
    private void turn(String player, boolean AI, boolean MORON){
        if (gameRunning){
            board.print(lastMiniGame);
            String answer = "";
            int[] selection = {-1,-1};
            if (lastMiniGame != -1){
                System.out.println(lastMiniGame);
                if (board.miniGameStatus(lastMiniGame) != " "){
                    System.out.println("\033[0;92m" + "You can go in any mini game" + "\033[0m");
                    lastMiniGame = -1;
                } else {
                    System.out.println("\033[0;93m" + "You must go in mini game " + "ABCDEFGHI".charAt(lastMiniGame) + "\033[0m");
                }
            }
            if (AI){
                selection=UltimateTicTacToeAI.calculateMove(board.getBoard(), player, lastMiniGame);
                board.set(selection[0], selection[1], player);
                lastMiniGame = selection[1];
            } else if (MORON){
                selection=UltimateTicTacToeMoron.calculateMove(board.getBoard(), lastMiniGame);
                board.set(selection[0], selection[1], player);
                lastMiniGame = selection[1];
            } else {
                boolean goodResponse = false;
                if (lastMiniGame == -1){
                    while (!goodResponse){
                        System.out.println(player+"'s turn");
                        answer = scanner.nextLine();
                        if (answer.length() == 2 && "ABCDEFGHI".indexOf(Character.toString(answer.charAt(0))) != -1 && "123456789".indexOf(Character.toString(answer.charAt(1))) != -1) {
                            selection[0] = "ABCDEFGHI".indexOf(Character.toString(answer.charAt(0)));
                            selection[1] = Integer.parseInt(Character.toString(answer.charAt(1))) - 1;
                        } else {
                            selection[0] = -1;
                            selection[1] = -1;
                        }
                        if (selection[0] > -1 && selection[1] > -1){
                            if ((lastMiniGame != -1 && selection[0] == lastMiniGame) || lastMiniGame == -1){
                                if (board.get(selection[0], selection[1]) == " "){
                                    board.set(selection[0], selection[1], player);
                                    goodResponse = true;
                                    lastMiniGame = selection[1];
                                }
                            }
                        }
                    }
                } else {
                    while (!goodResponse){
                        System.out.println(player+"'s turn");
                        answer = scanner.nextLine();
                        if (answer.length() == 1 && "123456789".indexOf(Character.toString(answer.charAt(0))) != -1) {
                            selection[0] = lastMiniGame;
                            selection[1] = Integer.parseInt(Character.toString(answer.charAt(0))) - 1;
                        } else {
                            selection[0] = -1;
                            selection[1] = -1;
                        }
                        if (selection[0] > -1 && selection[1] > -1){
                            if ((lastMiniGame != -1 && selection[0] == lastMiniGame) || lastMiniGame == -1){
                                if (board.get(selection[0], selection[1]) == " "){
                                    board.set(selection[0], selection[1], player);
                                    goodResponse = true;
                                    lastMiniGame = selection[1];
                                }
                            }
                        }
                    }
                }
            }
        gameRunning=board.gameStatus(true); 
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