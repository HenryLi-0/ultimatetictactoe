package tests;

import java.util.Scanner;

import games.TicTacToe.TicTacToeBoard;
import games.TicTacToe.TicTacToeGame;

public class TicTacToeTest {
    static TicTacToeGame game = new TicTacToeGame();
    static Scanner scanner = new Scanner(System.in);
    double correct = 0;

    public void testAISelf(){
        game.reset();
        while (game.running()){
            game.gameLoop(1,1);
        }
        System.out.println(game.winner());
    }

    public void testAISecond(){
        game.reset();
        while (game.running()){
            game.gameLoop(-1,1);
        }
        assertBoolean(game.winner() == "O" || game.winner() == "_");
    }  

    public void testAIFirst(){
        game.reset();
        while (game.running()){
            game.gameLoop(1,-1);
        }
        assertBoolean(game.winner() == "X" || game.winner() == "_");
    }

    public void otherTests(){
        TicTacToeBoard testBoard = new TicTacToeBoard();
        assertBoolean(testBoard.filledSquares()==0);
        testBoard.set(0, "X");
        assertBoolean(testBoard.filledSquares()==1);
        assertBoolean(testBoard.get(0)=="X");
    }

    public static void assertBoolean(boolean bool){
        if (!bool){
            throw new RuntimeException();
        }
    }
}