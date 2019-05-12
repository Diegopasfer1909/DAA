//si me piden una solucion no va a ser branch and bound y si me piden
// la mejor solucion sera B&B
package BranchBound;

import java.util.*;

public class BranchBound {
    private class Solution{
        private int [] sol;
        private int[][] costs;
        private int cost;
        private int nextAgent;
        private boolean [] candidates;
        private int lowerBound;
        private int[] minCostVector;

        public Solution(int[][] costs) {
            this.costs = costs;
            this.sol= new int [costs.length];
            this.cost = 0;
            this.nextAgent =0;
            this.candidates=new boolean [costs.length];
            Arrays.fill(this.candidates, true);
            this.minCostVector = new int [costs.length];
            for (int a =0;a< costs.length;a++){
                int min = Integer.MAX_VALUE;
                for (int t =0; t<costs.length;t++){
                    min = Math.min(min,costs[a][t]);
                }
                this.minCostVector[a]= min;
                this.lowerBound +=min;
            }
        }

        public Solution(Solution sol) {
            this.sol = sol.sol.clone();
            this.costs = sol.costs;
            this.cost= sol.cost;
            this.nextAgent= sol.nextAgent;
            this.candidates= sol.candidates.clone();
            this.lowerBound= sol.lowerBound;
            this.minCostVector = sol.minCostVector.clone();
            
        }
        public void addTask(int task){
            sol[nextAgent]= task;
            candidates[task]= false;
            cost +=costs[nextAgent][task];
            updateLowerBound(task);
            nextAgent++;
        }
        
        public void updateLowerBound (int task) {
            lowerBound -=minCostVector[nextAgent];
            lowerBound +=costs[nextAgent][task];
            
        }
        public int getCost(){
            return cost;
        }
        
        public int getLowerBound(){
            return lowerBound;
        }
        
        
    }
    public static void main(String[] args) {
        PriorityQueue <Solution> pq = new PriorityQueue<>((s1,s2)->
            s1.getLowerBound()= s2.getLowerBound());
    }
    
}
