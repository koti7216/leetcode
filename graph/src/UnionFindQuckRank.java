public class UnionFindQuckRank {
    private int root[];
    private int rank[];
    UnionFindQuckRank(int N){
        root = new int[N];
        for(int i=0;i<N;i++){
            root[i]=i;
            rank[i]=1;
        }
    }
    // time complexity is O(N)
    public int find(int x){
        while(root[x]!=x)
            x = root[x];
        return x;
    }
    // time complexity is O(N)
    public void union(int x,int y){
        int rx=find(x);
        int ry=find(y);
        if(rx!=ry){
            if(rank[rx]>rank[ry])
                root[ry] = rx;
           else if(rank[ry]>rank[rx])
                root[rx] = ry;
           else{
               root[ry]=rx;
               rank[rx]++;
            }
        }
    }
    public boolean connected(int x,int y){
        return (find(x)==find(y));
    }

    public static void main(String[] args) {
        UnionFindQuckRank uf = new UnionFindQuckRank(10);
        uf.union(1, 2);
        uf.union(2, 5);
        uf.union(5, 6);
        uf.union(6, 7);
        uf.union(3, 8);
        uf.union(8, 9);
        System.out.println(uf.connected(1, 5)); // true
        System.out.println(uf.connected(5, 7)); // true
        System.out.println(uf.connected(4, 9)); // false
        // 1-2-5-6-7 3-8-9-4
        uf.union(9, 4);
        System.out.println(uf.connected(4, 9)); // true
    }
}
