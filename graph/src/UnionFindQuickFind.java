public class UnionFindQuickFind {
    private int root[];
    UnionFindQuickFind(int N){
        root = new int[N];
        for(int i=0;i<N;i++){
            root[i]=i;
        }
    }
    // time complexity is O(1)
    public int find(int x){
        return root[x];
    }
    // time complexity is O(N)
    public void union(int x,int y){
        int rx=root[x];
        int ry=root[y];
        if(rx!=ry){
        for(int i=0;i< root.length;i++){
            if(root[i]==ry){
                root[i]=rx;
            }
        }
        }
    }
    public boolean connected(int x,int y){
        return (root[x]==root[y]);
    }

    public static void main(String[] args) {
        UnionFindQuickFind uf = new UnionFindQuickFind(10);
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
