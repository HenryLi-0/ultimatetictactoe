package games.UltimateTicTacToe;

public class UltimateTicTacToeAI {
    public static int[] calculateMove(String[][] board, String me, int lastMiniGame){

        // need to rewrite
        int[] placeholder = {0,0};
        return placeholder;
    }

    public static void path(String[][] board, String me, int lastMiniGame, int depth){
        if (depth < 3-1){path(board, me, lastMiniGame, depth+1);}

    }






    static String[] insults = {
        " put insults here",
    };

    public static void insult(String player){
        // Demotivation of your opponent appears to be a viable strategy in times of desperation.
        System.out.println("\033[1;97m" + player + insults[(int) Math.round(Math.random() * (insults.length-1))] + "\033[0m");
    }
}
