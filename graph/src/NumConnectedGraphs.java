public class NumConnectedGraphs {
    //You have a graph of n nodes. You are given an integer n and an array edges where edges[i] = [ai, bi]
    // indicates that there is an edge between ai and bi in the graph.
    //Return the number of connected components in the graph.
    public int countComponents(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        for(int i=0;i<edges.length;i++){
            uf.union(edges[i][0],edges[i][1]);
        }
        return uf.c;
    }
    class UnionFind{
        private int[] root;
        private int[] rank;
        private int c;
        UnionFind(int s){
            root = new int[s];
            rank = new int[s];
            for(int i=0;i<s;i++){
                root[i]=i;
                rank[i]=1;
            }
            c = s;
        }
        public int find(int x){
            if(x==root[x])
                return x;
            else{
                return root[x] =find(root[x]);
            }
        }
        public void union(int x, int y){
            int rootX=find(x);
            int rootY=find(y);
            if(rootX!=rootY){
                if(rank[rootX]>rank[rootY]){
                    root[rootY]=rootX;}
                else if(rank[rootX]<rank[rootY]){
                    root[rootX]=rootY;
                }
                else{
                    root[rootY]=rootX;
                    rank[rootX]++;
                }
                c--;
            }
        }
    }
}
