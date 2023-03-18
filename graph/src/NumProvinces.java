public class NumProvinces {
    //There are n cities. Some of them are connected, while some are not.
    // If city a is connected directly with city b, and city b is connected directly with city c,
    // then city a is connected indirectly with city c.
    //A province is a group of directly or indirectly connected cities and no other cities outside of the group.
    //You are given an n x n matrix isConnected where isConnected[i][j] = 1
    // if the ith city and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.
    //Return the total number of provinces.
        public int findCircleNum(int[][] isConnected) {
            UnionFind uf = new UnionFind(isConnected.length);
            for(int i=0;i<isConnected.length;i++){
                for(int j=0;j<isConnected[0].length;j++){
                    if(isConnected[i][j]==1)
                        uf.union(i,j);
                }
            }
            return uf.r;
        }
        public class UnionFind{
            private int[] root;
            // Use a rank array to record the height of each vertex, i.e., the "rank" of each vertex.
            private int[] rank;
            private int r;

            public UnionFind(int size) {
                root = new int[size];
                rank = new int[size];
                for (int i = 0; i < size; i++) {
                    root[i] = i;
                    rank[i] = 1; // The initial "rank" of each vertex is 1, because each of them is
                    // a standalone vertex with no connection to other vertices.
                }
                r=size;
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
                    if (rank[rootX] > rank[rootY]) {
                        root[rootY] = rootX;
                    } else if (rank[rootX] < rank[rootY]) {
                        root[rootX] = rootY;
                    } else {
                        root[rootY] = rootX;
                        rank[rootX] += 1;
                    }
                    r--;
                }
            }
        }
}
