package tests;

public class Test {
    final int REPEATS = 1000;
    public void test(){
        UltimateTicTacToeTest ticTacToeTest = new UltimateTicTacToeTest();
        int i = 0;
        while (i<REPEATS){
            ticTacToeTest.testAISecond();
            ticTacToeTest.testAIFirst();
            i++;
        }
        ticTacToeTest.otherTests();
        
        System.out.println("If you see this, all tests passed!");
    }
}