package ciclosham;

import java.util.*;

public class CiclosHam {
    
    public static int rutas;
    
    public static boolean isFeasible (List<Integer> []g,int[] sol,int elem,int lim){
        int j = 0;
        boolean found = false;
        while (j <= lim && !found) {
            if (sol[j] == elem) {
                found = true;
            } else {
                j++;
            }
        }
        return !found;
    }
    
    public static void CiclosHamiltonianos(List<Integer> [] g,int [] sol,int k){
        List <Integer> lista = new ArrayList<>(g[sol[k-1]]);
        while(!lista.isEmpty()){
            int candidate = lista.remove(0);
            if(isFeasible(g,sol,candidate,k-1)){
                sol[k]=candidate;
                if (k==(sol.length-1)) {
                    if(g[sol[sol.length-1]].contains(sol[0])){
                        rutas++;
                    }
                } 
                else {
                    CiclosHamiltonianos(g,sol,k+1);
                }
                sol[k]=-1;
            }
        }
    }
   
    public static void main(String[] args) {
        CiclosHam.rutas=0;
        Scanner sc = new Scanner(System.in);
        int planetas = sc.nextInt();
        int parejas = sc.nextInt();
        List<Integer> [] g= new List [planetas];
        for (int i = 0; i < planetas; i++) {
            g[i]= new ArrayList <>();
        }
        for (int i = 0; i < parejas; i++) {
            int gU= sc.nextInt();
            int gV= sc.nextInt();
            g[gU].add(gV);
            g[gV].add(gU);
        }
        int [] sol= new int [planetas];
        Arrays.fill(sol,-1);
        sol[0]=0;
        CiclosHamiltonianos(g,sol,1);
        System.out.println(CiclosHam.rutas);
    }
    
}
