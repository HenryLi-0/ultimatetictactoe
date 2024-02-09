package tests;

import java.util.Scanner;

import org.junit.jupiter.api.*;

import games.TicTacToe.TicTacToeGame;

public class TicTacToeTest {
    static TicTacToeGame game = new TicTacToeGame();
    static Scanner scanner = new Scanner(System.in);

    public void setUp(){
        game.reset();
        while (game.running()){
            game.gameLoop(1,1);
        }
        System.out.println(game.winner());
    }

    public void testAI(){
        game.reset();
        while (game.running()){
            game.gameLoop(-1,1);
        }
        assertEquals(game.winner(),"O");
    }  
}
