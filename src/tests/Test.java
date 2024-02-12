package tests;

public class Test {
    final int REPEATS = 1000;
    public void test(){
        TicTacToeTest ticTacToeTest = new TicTacToeTest();
        int i = 0;
        while (i<REPEATS){
            ticTacToeTest.testAI();
            i++;
        }
        if (ticTacToeTest.passing){
            System.out.println("TicTacToeAI VS Moron Score: ");
            System.out.println(ticTacToeTest.correct);
            System.out.println("/1000");
        } else {
            System.out.println("TicTacToeAI VS Moron Test Failed");   
            System.out.println(ticTacToeTest.correct);
        }
    }
}