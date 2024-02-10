import java.util.Scanner;

import games.TicTacToe.TicTacToeGame;

public class Main {
    //init
    static TicTacToeGame game = new TicTacToeGame();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            game.reset();
            while (game.running()){
                game.gameLoop(1,1);
            }
            System.out.println(game.winner());
            
            System.out.println("press enter to continue");
            scanner.nextLine();
        }
    }
}