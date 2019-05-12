package casisudoku;

import java.util.*;
       
public class Sudoku {
    private static List<Sudoku> solucion=new ArrayList<>(); //listasoluciones   
    private int[][]board;          //sudoku
    private int rs;     //resultados

    public Sudoku(){
        this.board=new int[9][9];
        this.rs=0;
    }
    public void fillSudoku(){
        Scanner scan=new Scanner(System.in);

        for(int i=0;i<9;i++){       //INICIALIZAMOS SUDOKU
            for(int j=0;j<9;j++){
                board[i][j]=scan.nextInt();
            }
        }
    }

    public void printSudoku(){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println("\n");
        }
    }

    public int getVal(int r, int c){
        return board[r][c];
    }

    public void setVal(int r, int c, int k){
        board[r][c]=k;
    }

    public void clonSudoku(Sudoku s2){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                this.board[i][j]=s2.getVal(i, j);
            }
        }
    }

    public void increaseRs(){
        rs++;
    }

    public int getRs(){
        return rs;
    }

    

    public static void main(String[] args) {
        Sudoku sudoku=new Sudoku();
        sudoku.fillSudoku();
        
        solveSudoku(sudoku);       //rs=nº soluciones
        if(sudoku.getRs()==0){
            System.out.print("imposible");
        }
        else if(sudoku.getRs()>2){
            System.out.println("casi sudoku");
        }
        else{
            solucion.get(0).printSudoku();
        }
    }
    public static boolean isFeasible (int [][]sudoku,int row,int Col,int x){
        int i,j;
        for (i=0;i<9;i++){
           if (sudoku[row][i]==x){
               return false;
           } 
        }
        for (i=0;i<9;i++){
           if (sudoku[i][Col]==x){
               return false;
           } 
        }
        //esto lo usare para comprobar cada bloque
        int r = row-(row%3);
        int c = Col-(Col%3);
        for ( i=r;i<r+3;i++){
            for(j=c;j<c+3;j++){
                if(sudoku[i][j]==x){
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean solveSudoku(Sudoku sudoku){
       
           if(sudoku.getRs()>1){
               return true;
            }
           else{
           for(int r=0;r<9;r++){
           for(int c=0;c<9;c++){
               if(sudoku.getVal(r, c)==0){
                   for(int num=1;num<10;num++){
                       if(isFeasible(sudoku.board,r,c,num)){
                           sudoku.setVal(r,c,num);
                           if(solveSudoku(sudoku)){
                               sudoku.increaseRs();
                              
                               Sudoku sudAux=new Sudoku();
                               sudAux.clonSudoku(sudoku);
                               solucion.add(sudAux);
                           }
                               sudoku.setVal(r, c, 0);
                       }
                   }
                   return true;
                          
                    }
                   return false;
               }
           }
       }
        return true;}
}

    

