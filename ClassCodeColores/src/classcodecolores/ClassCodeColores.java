package classcodecolores;

import java.util.*;

public class ClassCodeColores {
    
    public static boolean isFeasible (List<Integer>[] graph, int k, int []solution){
        for (int adj:graph[k]){
            if (solution[k]==solution[adj]){
                return false;
            }
        }
        return true;
    }
    
    public static void printSolution(int [] solution){
        
    }
    
    public static void color(List <Integer> [] graph, int k,int m,int [] solution) {
        solution[k]=0;
        while (solution[k]!=m){
            solution[k]++;
            if (isFeasible(graph,k,solution)){
                if (k<graph.length-1 ){
                    color(graph,k+1,m,solution);
                }else{
                    printSolution(solution);
                }
            }
        }
    }
    
}
