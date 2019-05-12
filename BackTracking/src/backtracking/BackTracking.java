package backtracking;
//problema de las n reinas
//si hay una reina en la posicion i, j no podra haber otra reina ni en la fila i
//ni en la columna j ni en la misma diagonal...
//este algoritmo es de decision porque encontrar una solucion es la finalidad
//sabemos con antelacion que solucion buscamos
public class BackTracking {

    public class NQueenProblem{
        final int n=8;
        public boolean solveNQueenBT (int [][] board, int Col){
            if (isSolution(Col)){
                return true;
            }
            else{
                for(int i=0;i<n;i++){
                    if (isFeasible(board,i,Col)){
                        board[i][Col]=1;
                        solveNQueenBT(board,Col+1);
                        board[i][Col]=0;
                        if (solveNQueenBT(board,Col+1)){
                            return true;
                        }
                    }
                }
            }
            return false;
        }
        
        public boolean isSolution (int Col){
            return (Col==n);
        }
        
        public boolean isFeasible (int [][]board,int row,int Col){
            int i,j;
            for (i=0;i<Col;i++){
               if (board[row][i]==1){
                   return false;
               } 
            }
            //esto de aqui en adelante son bucles bidimensionales
            //se mueve en bloques de ; y cada dimension separada por ,
            for (i=row,j=Col;i>=0 && j>=0;i--,j--){
               if (board[row][i]==1){
                   return false;
               } 
            }
            for (i=row,j=Col;j>=0 &&i<n; i--,j--){
               if (board[row][i]==1){
                   return false;
               } 
            }
            return true;
        }
    }
    
    public static void main(String[] args) {
        
    }
    
}
