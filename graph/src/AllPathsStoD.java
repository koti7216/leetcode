import java.util.*;
public class AllPathsStoD {
        public static boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
            HashMap<Integer,ArrayList<Integer>> h = new HashMap<>();
            for(int[] e:edges){
                h.putIfAbsent(e[0],new ArrayList<>());
                h.get(e[0]).add(e[1]);
            }
            int[] path = new int[n];
            return dfs(h,source,destination,source,path);

        }
        public static boolean dfs(HashMap<Integer,ArrayList<Integer>> h, int s, int d, int node,int[] path){
            if(path[node]!=0){
                 return path[node]==2;
            }
            ArrayList<Integer> arr = h.get(node);
            if(arr==null || arr.isEmpty()){
                if(node!=d)
                    return node==d;
            }

            path[node]=1;

                for(int i=0;i<arr.size();i++){
                    if(!dfs(h,s,d,arr.get(i),path))
                        return false;
                }
            path[node]=2;
            return true;

        }


    public static void main(String[] args) {
        int[][] e = {{0,1},{0,3},{1,2},{2,1}};
        System.out.println(leadsToDestination(4,e,0,3));
    }
}
