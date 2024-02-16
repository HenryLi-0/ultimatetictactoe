package tests;

import java.util.Scanner;

import games.UltimateTicTacToe.UltimateTicTacToeBoard;
import games.UltimateTicTacToe.UltimateTicTacToeGame;

public class UltimateTicTacToeTest {
    static UltimateTicTacToeGame game = new UltimateTicTacToeGame();
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
        UltimateTicTacToeBoard testBoard = new UltimateTicTacToeBoard();
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