import java.util.Scanner;

import games.UltimateTicTacToe.UltimateTicTacToeGame;
import tests.Test;

public class Main {
    static boolean test = false;

    //init
    static UltimateTicTacToeGame game = new UltimateTicTacToeGame();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        if (test) {
            final Test tester = new Test();
            tester.test();
        } else {
            while (true) {
                game.reset();
                while (game.running()){
                    game.gameLoop(0,1);
                }
                System.out.println(game.winner());
                
                System.out.println("press enter to continue");
                scanner.nextLine();
            }
        }
    }
}