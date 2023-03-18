public class GraphValidTree {
   //You have a graph of n nodes labeled from 0 to n - 1.
   // You are given an integer n and a list of edges where edges[i] = [ai, bi]
   // indicates that there is an undirected edge between nodes ai and bi in the graph.
   //Return true if the edges of the given graph make up a valid tree, and false otherwise.
        public boolean validTree(int n, int[][] edges) {
            UnionFind uf = new UnionFind(n);
            int l = edges.length;
            for(int i=0;i<l;i++){
                for(int j=0;j<2;j++){
                    int a = edges[i][j];
                    j++;
                    int b = edges[i][j];
                    uf.union(a,b);
                }
            }
            if(uf.r==1 && uf.c==1)
                return true;
            else
                return false;
        }
        class UnionFind {
            private int[] root;
            // Use a rank array to record the height of each vertex, i.e., the "rank" of each vertex.
            private int[] rank;
            private int r;
            private int c;

            public UnionFind(int size) {
                root = new int[size];
                rank = new int[size];
                for (int i = 0; i < size; i++) {
                    root[i] = i;
                    rank[i] = 1; // The initial "rank" of each vertex is 1, because each of them is
                    // a standalone vertex with no connection to other vertices.
                }
                r = 1;
                c = size;
            }

            // The find function here is the same as that in the disjoint set with path compression.
            public int find(int x) {
                if (x == root[x]) {
                    return x;
                }
                return root[x] = find(root[x]);
            }

            // The union function with union by rank
            public void union(int x, int y) {
                int rootX = find(x);
                int rootY = find(y);
                if (rootX != rootY) {
                    // if(rank[rootX]!=1 && rank[rootY]!=1)
                    //   r=0;
                    if (rank[rootX] > rank[rootY]) {
                        root[rootY] = rootX;
                    } else if (rank[rootX] < rank[rootY]) {
                        root[rootX] = rootY;
                    } else {
                        root[rootY] = rootX;
                        rank[rootX] += 1;
                    }
                    c--;
                }
                else{
                    r = 0;
                }
            }
        }
}
