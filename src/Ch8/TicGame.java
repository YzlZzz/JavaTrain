package Ch8;

import java.util.Objects;
import java.util.Scanner;

public class TicGame {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String[][] matrix = new String[3][3];

        //初始化棋盘
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                matrix[i][j] = " ";
            }
        }

        showChessboard(matrix);
        for(int i = 0; i < 9; i++){
            int playerNumber = i % 2;
            if(playerNumber == 0){
                System.out.print("Player1 enter row and column: ");
            }
            else {
                System.out.print("Player2 enter row and column: ");
            }
           int row = input.nextInt();
           int column = input.nextInt();


           putChess(matrix, playerNumber, row-1, column-1);
           showChessboard(matrix);
           if(judgeWin(matrix)){
               break;
           }
        }
        System.out.println();
        System.out.println("GAME OVER");

    }

    /***
     * 输出棋盘，每下一步，重新输出一次
     * @param a
     */
    public static void showChessboard(String[][] a){
        for(int i = 0; i < a.length; i++){
            System.out.println();
            System.out.println("--------------");
            System.out.print("| ");
            for(int j = 0; j < a[i].length; j++){
                System.out.print(a[i][j]);
                System.out.print(" | ");
            }
        }
        System.out.println();
        System.out.println("--------------");
    }

    /***
     * 判断是否获胜
     * @param a
     */
    public static boolean judgeWin(String[][] a){
        for(int i = 0; i < a.length; i++){
            if(Objects.equals(a[i][0], "O") && Objects.equals(a[i][1], "O") && Objects.equals(a[i][2], "O")){
                System.out.println("Player1 win!");
                return true;
            }
            else if(Objects.equals(a[0][i], "O") && Objects.equals(a[1][i], "O") && Objects.equals(a[2][i], "O")){
                System.out.println("Player1 win!");
                return true;
            }
            else if(Objects.equals(a[0][i], "X") && Objects.equals(a[1][i], "X") && Objects.equals(a[2][i], "X")){
                System.out.println("Player2 win!");
                return true;
            }
            else if(Objects.equals(a[i][0], "X") && Objects.equals(a[i][1], "X") && Objects.equals(a[i][2], "X")){
                System.out.println("Player2 win!");
                return true;
            }

        }

        if(Objects.equals(a[0][0], "O") && Objects.equals(a[1][1], "O") && Objects.equals(a[2][2], "O")){
            System.out.println("Player1 win!");
            return true;
        }
        else if(Objects.equals(a[0][0], "X") && Objects.equals(a[1][1], "X") && Objects.equals(a[2][2], "X")){
            System.out.println("Player2 win!");
            return true;
        }
        else{
            return false;
        }
    }

    /***
     * 双方轮流放置棋子，1号玩家放O，2号玩家放X
     * @param a
     * @param playerNumber
     */
    public static void putChess(String[][] a, int playerNumber, int row, int column){
        if(playerNumber == 0){
            a[row][column] = "O";
        }
        else{
            a[row][column] = "X";
        }
    }
}
