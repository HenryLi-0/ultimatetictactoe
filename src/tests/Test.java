package tests;

public class Test {
    final int REPEATS = 1000;
    public void test(){
        TicTacToeTest ticTacToeTestSecond = new TicTacToeTest();
        TicTacToeTest ticTacToeTestFirst = new TicTacToeTest();
        int i = 0;
        while (i<REPEATS){
            ticTacToeTestSecond.testAISecond();
            ticTacToeTestFirst.testAIFirst();
            i++;
        }
        if (ticTacToeTestSecond.passing){
            System.out.println("TicTacToeAI VS Moron Score: (AI Second)");
            System.out.println(ticTacToeTestSecond.correct);
            System.out.println("/100000");
        } else {
            System.out.println("TicTacToeAI VS Moron Test Failed (AI Second)");   
            System.out.println(ticTacToeTestSecond.correct);
            System.out.println("Stopped At");
        }

        if (ticTacToeTestFirst.passing){
            System.out.println("TicTacToeAI VS Moron Score: (AI Fist)");
            System.out.println(ticTacToeTestSecond.correct);
            System.out.println("/100000");
        } else {
            System.out.println("TicTacToeAI VS Moron Test Failed (AI First)");   
            System.out.println(ticTacToeTestSecond.correct);
            System.out.println("Stopped At");
        }

    }
}