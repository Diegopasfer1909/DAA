/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ciclos;

import java.util.*;
public class ciclos {
    
    public static boolean DFS1Nodo(List<Integer>[] g, int v) {
        boolean[] visited = new boolean[(g.length)];
        return recDFSita(g,v,visited,(0));
    }

    public static boolean recDFSita(List<Integer>[] g, int v, boolean[] visited, int aux) {
        visited[v] = true;
        for (int adj : g[v]) {
            if ((visited[adj])&&(aux!=adj)){
                //aqui compruebo que el actual no sea igual que el anterior y 
                //que esta visitado ya previamente
                return true;
            }
            if (!visited[adj]) {
                recDFSita(g, adj, visited,v);
            }
        }
        return false;
    }
    
    public static boolean DFSGEntero(List<Integer>[] g) {
        for (int v = 0; v < (g.length); v++) {
            if (DFS1Nodo(g,v)==true){
                return true;
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        Scanner s= new Scanner(System.in);
        int numnodos=s.nextInt();
        int numaristas=s.nextInt();
        List <Integer> [] g = new List  [numnodos];        
        
        for(int d=0; d<numnodos;d++){
           g[d]= new ArrayList(); 
        }
        
        for (int i=0;i<numaristas;i++){
            int v= s.nextInt();
            int u= s.nextInt();
            g[(v-1)].add((u-1));
            g[(u-1)].add((v-1));
        }
        
        if (DFSGEntero(g)){
            System.out.println(true);
        }
        else{
            System.out.println(false);
        }
    }
    
}
