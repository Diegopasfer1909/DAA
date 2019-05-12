package LabMCorto;
import java.util.*;
public class LabMCorto {
    public static int solMejor;
    public static boolean isFeasible(int[][] board, int r, int c,int k) {
        if (((r < board.length) && (r >= 0) && (c < board.length) && (c >= 0))&&(k < LabMCorto.solMejor)) {
            return board[r][c] == 0;
        } else {
            return false;
        }
    }

    public static int labyrinth(int r, int c, int k, int[][] board) {
        board[r][c] = k;
        if ((r == board.length-1 && c == board.length-1)&&(k< LabMCorto.solMejor)) {
            LabMCorto.solMejor= board[r][c];
        } else {
            if (isFeasible(board, r, c+1,k)) {
                labyrinth(r, c+1, k+1, board);
            }
            if (isFeasible(board, r+1, c,k)) {
                labyrinth(r+1, c, k+1, board);
            }
            if (isFeasible(board, r-1, c,k)) {
                labyrinth(r-1, c, k+1, board);
            }
            if (isFeasible(board, r, c-1,k)) {
                labyrinth(r, c-1, k+1, board);
            }
            
        }
        board[r][c] = 0;
        return LabMCorto.solMejor;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int limite = sc.nextInt();
        int [][] board = new int [limite][limite];
        for(int j=0;j<limite;j++){
            for (int i=0; i<limite;i++){
                board[j][i]=sc.nextInt();
            }
        }
        LabMCorto.solMejor=(limite*limite)+1;
        int sol = labyrinth(0,0,1,board);
        if(sol>(limite*limite)){
            System.out.println("SIN SOLUCION");
        }else {
            System.out.println(sol);
        }
    }
}
