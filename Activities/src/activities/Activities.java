package activities;

import java.util.*;

public class Activities {
    public static class Pareja implements Comparable <Pareja>{
        int ini;
        int fin;
        int dif;

        public Pareja(int ini, int fin) {
            this.ini = ini;
            this.fin = fin;
            this.dif = fin-ini;
        }
    
    
        @Override
    public int compareTo(Pareja p) {
        //buscar de los que menor fin tenga el que menor diferencia tenga
        if (p.fin>fin){
            return -1;
        }
        else if (p.fin<fin){
            return 1;
        }else{
            if((p.fin==fin)&&(p.dif>dif)){
               return -1; 
            }
            else if ((p.fin==fin)&&(p.dif<dif)){
               return 1;
            }else{
                return 0;
            }
        }
    }
    }
    public static boolean Feasible (ArrayList <Pareja> l, Pareja p){
        if (!l.isEmpty()){
                return ((p.ini) >= ((l.get((l.size()-1))).fin));
            }
        return false;
    }
    
    public static int BackPack( ArrayList <Pareja> act){
        ArrayList <Pareja> solucion = new ArrayList <>();
        int ay = 0;
        for (int i=0; i< act.size(); i++){
            if (solucion.isEmpty()){
                solucion.add(act.get(i));
                ay++;
            }else if(Feasible(solucion,act.get(i))){
                solucion.add(act.get(i));
                ay++;
            }
            
        }
        return ay;  
    }
    
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int tandas = s.nextInt();
        for (int i =0;i<tandas;i++){
            int grupos = s.nextInt();
            ArrayList <Pareja> ar= new ArrayList<>();
            for (int j=0; j< grupos; j++){
                int x0= s.nextInt();
                int xf= s.nextInt();
                Pareja p = new Pareja(x0, xf);
                ar.add(p);
            }
            Collections.sort(ar);
            int sol = BackPack(ar);
            System.out.println(sol);
        }
    }
    
}
