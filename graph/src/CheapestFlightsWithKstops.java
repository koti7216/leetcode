import java.util.*;
//There are n cities connected by some number of flights. You are given an array flights where
// flights[i] = [fromi, toi, pricei] indicates that there is a flight from city fromi to city toi with cost pricei.
//
//You are also given three integers src, dst, and k, return the cheapest price from src to dst with at most k stops.
// If there is no such route, return -1.
public class CheapestFlightsWithKstops {
    class Solution {
        public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
            int[][] temp = new int[k+2][n];
            HashMap<Integer,ArrayList<Edges>> h = new HashMap<>();
            for(int i=0;i<n;i++){
                if(i!=src){
                    temp[0][i]=1000001;
                    temp[1][i]=1000001;

                }
                else{
                    temp[0][i]=0;
                }
            }
            for(int i=0;i<flights.length;i++){
                if(flights[i][0]!=src){
                    if(flights[i][1]!=src){
                        h.putIfAbsent(flights[i][1],new ArrayList<Edges>());
                        h.get(flights[i][1]).add(new Edges(flights[i][0],flights[i][2]));}}
                else{
                    temp[1][flights[i][1]]= flights[i][2];
                }
            }
            if(!h.containsKey(dst) && temp[1][dst]==1000001){
                return -1;
            }
            int t = 2;
            while(t<=k+1){
                for(int i=0;i<n;i++){
                    if(i!=src){
                        int m = temp[t-1][i];
                        //  System.out.println(i);
                        //System.out.println(m);
                        if(h.containsKey(i)){
                            for(Edges g: h.get(i)){
                                m = Math.min(m,temp[t-1][g.d]+g.c);
                                System.out.println(i);
                                System.out.println(g.d);
                                System.out.println(temp[t-1][g.d]+g.c);
                            }
                            temp[t][i]=m;
                            System.out.println(i);
                            System.out.println(m);
                        }
                        else{
                            temp[t][i]=temp[t-1][i];
                        }}
                }
                t++;
            }
            if(temp[k+1][dst]>1000000 || temp[k+1][dst]==0)
                return -1;
            else
                return temp[k+1][dst];
        }
        class Edges{
            private int d;
            private int c;
            Edges(int d,int c){
                this.d = d;
                this.c = c;
            }
        }
    }
}
