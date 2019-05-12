package bfs;

import java.util.*;


public class BFS {
    public static List<Integer> BFSita(List<Integer>[] g, int v) {
        int n = g.length;
        List<Integer> traversal = new ArrayList<>(n);
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        visited[v] = true;
        traversal.add(v+1);
        q.add(v);
    
    while (!q.isEmpty()) {
        int aux = q.remove();
        
        for (int adj : g[aux]) {
            if (!visited[adj]) {
                visited[adj] = true;
                traversal.add(adj+1);
                q.add(adj);
            }
        }
    }
    return traversal;
    }

    public static void main(String[] args) {
        

        Scanner s= new Scanner(System.in);
        int numnodos=s.nextInt();
        int numaristas=s.nextInt();
        int nodoinicio=s.nextInt();
        List <Integer> [] g = new List  [numnodos];
        
        for(int d=0; d<numnodos;d++){
           g[d]= new ArrayList(); 
        }
        for(int i=0;i<numaristas;i++){
            int v= s.nextInt();
            int u= s.nextInt();
            g[(v-1)].add((u-1));
            g[(u-1)].add((v-1));
        }
        
        List <Integer> res = BFSita(g,(nodoinicio-1));
        
        for (int ay=0; ay< res.size();ay++){
            System.out.print(res.get(ay)+" ");
        }
    }
    
}
