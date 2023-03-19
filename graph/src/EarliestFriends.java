import java.util.Arrays;
import java.util.Comparator;
//There are n people in a social group labeled from 0 to n - 1.
// You are given an array logs where logs[i] = [timestampi, xi, yi] indicates that xi and yi will be friends at the time timestampi.
//Friendship is symmetric. That means if a is friends with b, then b is friends with a.
// Also, person a is acquainted with a person b if a is friends with b, or a is a friend of someone acquainted with b.
//Return the earliest time for which every person became acquainted with every other person.
// If there is no such earliest time, return -1.
public class EarliestFriends {
        public int earliestAcq(int[][] logs, int n) {
            UnionFind uf = new UnionFind(n);
            Arrays.sort(logs, Comparator.comparingInt(o->o[0]));
            for(int i=0;i<logs.length;i++){
                uf.union(logs[i][1],logs[i][2]);
                if(uf.r ==0){
                    return logs[i][0];
                }
            }

            return -1;
        }
        class UnionFind{
            private int[] root;
            private int[] rank;
            private int[] rank1;
            private int r;
            private int d;
            UnionFind(int s){
                root = new int[s];
                rank = new int[s];
                rank1 = new int[s];
                for(int i=0;i<s;i++){
                    root[i]=i;
                    rank[i]=1;
                    rank1[i]=1;
                }
                r = 1;
                d = s;
            }
            public int find(int x){
                if(x==root[x]){
                    return x;
                }
                else{
                    return root[x]=find(root[x]);
                }
            }
            public void union(int x, int y){
                int rootX=find(x);
                int rootY=find(y);
                if(rootX!=rootY){
                    if(rank[rootX]>rank[rootY]){
                        root[rootY]=rootX;
                        rank1[rootX]+=rank1[rootY];
                        if(rank1[rootX]==d)
                            r = 0;
                    }
                    else if(rank[rootX]<rank[rootY]){
                        root[rootX]=rootY;
                        rank1[rootY]+=rank1[rootX];
                        if(rank1[rootY]==d)
                            r = 0;
                    }
                    else{
                        root[rootX]=rootY;
                        rank[rootY]++;
                        rank1[rootY]+=rank1[rootX];
                        if(rank1[rootY]==d)
                            r = 0;
                    }
                }
            }
        }
}
