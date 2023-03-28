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
            System.out.println("---------");
            System.out.println(node);
            if(path[node]!=0){
                 return path[node]==2;
            }
            ArrayList<Integer> arr = h.get(node);
            if(arr==null || arr.isEmpty()){
                if(node!=d)
                    return node==d;
            }
            else{

            path[node]=1;

     //       System.out.println(Arrays.toString(path));
                for(int i=0;i<arr.size();i++){
                    if(!dfs(h,s,d,arr.get(i),path))
                        return false;
               //     System.out.println(Arrays.toString(path));
                //  path[node]=2;
                 //   System.out.println(Arrays.toString(path));
                }}
             path[node]=2;
            System.out.println(Arrays.toString(path));
            return true;

        }


    public static void main(String[] args) {
        int[][] e = {{0,1},{0,2},{2,1},{1,3},{2,3},{3,4}};
        System.out.println(leadsToDestination(5,e,0,4));
    }
}
