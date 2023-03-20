import java.util.*;
//You are given a string s, and an array of pairs of indices in the string pairs where pairs[i] = [a, b]
// indicates 2 indices(0-indexed) of the string.
//
//You can swap the characters at any pair of indices in the given pairs any number of times.
//
//Return the lexicographically smallest string that s can be changed to after using the swaps.
public class SmallestStringSwaps {
        public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
            int a = s.length();
            UnionFind uf = new UnionFind(a);
            for(List<Integer> e:pairs){
                uf.union(e.get(0),e.get(1));
            }
            Map<Integer,List<Integer>> rootComp = new HashMap<>();
            for(int i=0;i<a;i++){
                int root = uf.find(i);
                rootComp.putIfAbsent(root,new ArrayList<>());
                rootComp.get(root).add(i);
            }
            char[] s1 = new char[a];
            for(List<Integer> l:rootComp.values()){
                List<Character> c = new ArrayList<>();
                for(int i:l){
                    c.add(s.charAt(i));
                }
                Collections.sort(c);
                for(int i=0;i<c.size();i++){
                    s1[l.get(i)]=c.get(i);
                }
            }
            return new String(s1);
        }
        class UnionFind{
            private int[] root;
            private int[] rank;
            UnionFind(int s){
                root=new int[s];
                rank=new int[s];
                for(int i=0;i<s;i++){
                    root[i]=i;
                    rank[i]=1;
                }
            }
            public int find(int x){
                if(root[x]==x){
                    return x;
                }
                else{
                    return root[x]=find(root[x]);
                }
            }
            public void union(int x,int y){
                int rx = find(x);
                int ry = find(y);
                if(rx!=ry){
                    if(rank[rx]>rank[ry]){
                        root[ry]=rx;
                    }
                    else if(rank[rx]<rank[ry]){
                        root[rx]=ry;
                    }
                    else{
                        root[ry]=rx;
                        rank[rx]++;
                    }
                }
            }
        }

}
