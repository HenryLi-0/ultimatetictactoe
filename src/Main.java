import java.util.Scanner;

public class Main {
    //init
    static String[] board = new String[9];
    static boolean playing = true;
    static Scanner scanner = new Scanner(System.in);

    public static void initGame(){
        for (int i = 0; i < 9; i++){board[i] = " ";}
    }

    public static void turn(String player){
        if (playing){
            //move
            String answer = "";
            int selection = 0;
            boolean goodResponse = false;
            while (!goodResponse){
                System.out.println(player+"'s turn");
                answer = scanner.nextLine();
                selection = "ABC".indexOf(Character.toString(answer.charAt(0)))*3 + Integer.parseInt(Character.toString(answer.charAt(1))) - 1;
                if (selection > -1){
                    if (board[selection] == " "){
                        board[selection]=player;
                        goodResponse = true;
                    }
                }
            }
            //display board
            System.out.println("    1   2   3  ");
            for (int i = 0; i < 3; i++){
                System.out.println("  +---+---+---+");
                System.out.println("ABC".charAt(i) + " | " + board[i*3] + " | " + board[i*3+1] + " | " + board[i*3+2] + " |");
            }
            System.out.println("  +---+---+---+");
            //check for win
            String winner = "1155";
            System.out.println(board.toString());
            if (board.toString().indexOf(" ") == -1) {
                System.out.println("both of you are equally bad");
                playing = false;
            } else {
                for (int i = 0; i < 3; i++){
                    if (board[i*3+0]==board[i*3+1] || board[i*3+0]==board[i*3+2]){winner = board[i*3+0];}
                    if (board[i]==board[i+3] || board[i]==board[i+6]){winner = board[i];}
                }
                if (board[0]==board[4] || board[0]==board[8]){winner = board[0];}
                if (board[2]==board[4] || board[2]==board[6]){winner = board[2];}
                if (winner!="1155"){
                    System.out.println(winner + " wins!");
                    playing = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        initGame();
        while (playing){
            turn("X");
            turn("O");
        }
        System.out.println("press enter to continue");
        scanner.nextLine();
        playing = true;
    }
}
