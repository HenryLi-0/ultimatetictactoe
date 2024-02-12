package tests;

import java.util.Scanner;

import games.TicTacToe.TicTacToeGame;

public class TicTacToeTest {
    static TicTacToeGame game = new TicTacToeGame();
    static Scanner scanner = new Scanner(System.in);
    double correct = 0;
    boolean passing = true;

    public void testAISelf(){
        game.reset();
        while (game.running()){
            game.gameLoop(1,1);
        }
        System.out.println(game.winner());
    }

    public void testAISecond(){
        if (passing) {
            game.reset();
            while (game.running()){
                game.gameLoop(-1,1);
            }
            if (game.winner() == "O" || game.winner() == "_"){
                correct+=1;
            } else {
                passing = false;
            }
        }
    }  

    public void testAIFirst(){
        if (passing) {
            game.reset();
            while (game.running()){
                game.gameLoop(1,-1);
            }
            if (game.winner() == "X" || game.winner() == "_"){
                correct+=1;
            } else {
                passing = false;
            }
        }
    }  
}