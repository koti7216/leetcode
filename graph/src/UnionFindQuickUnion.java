public class UnionFindQuickUnion {
    private int root[];
    UnionFindQuickUnion(int N){
        root = new int[N];
        for(int i=0;i<N;i++){
            root[i]=i;
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
         root[ry] = rx;
        }
    }
    public boolean connected(int x,int y){
        return (find(x)==find(y));
    }

    public static void main(String[] args) {
        UnionFindQuickUnion uf = new UnionFindQuickUnion(10);
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
