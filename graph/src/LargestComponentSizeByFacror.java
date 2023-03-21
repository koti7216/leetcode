import java.util.HashMap;
import java.util.Map;
//You are given an integer array of unique positive integers nums. Consider the following graph:
//There are nums.length nodes, labeled nums[0] to nums[nums.length - 1],
//There is an undirected edge between nums[i] and nums[j] if nums[i] and nums[j] share a common factor greater than 1.
//Return the size of the largest connected component in the graph.
public class LargestComponentSizeByFacror {
        public int largestComponentSize(int[] nums) {
            int m1 = 0;
            int max = 0;
            for(int i =0;i<nums.length;i++){
                m1 = Math.max(nums[i],m1);
            }
            UnionFind uf = new UnionFind(m1+1);
            for(int i=0;i<nums.length;i++){
                for(int j=2;j*j<=nums[i];j++){
                    if(nums[i]%j==0){
                        uf.union(nums[i],j);
                        uf.union(nums[i],nums[i]/j);
                    }
                }
            }
            Map<Integer,Integer> m = new HashMap<>();
            for(int num:nums){
                int root = uf.find(num);
                m.putIfAbsent(root,0);
                m.put(root,m.get(root)+1);
                max = Math.max(max,m.get(root));
            }
            return max;
        }
        class UnionFind{
            private int[] root;
            private int[] rank1;
            UnionFind(int s){
                root = new int[s];
                rank1 = new int[s];
                for(int i=0;i<s;i++){
                    root[i]=i;
                    rank1[i]=1;
                }
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
                int rx = find(x);
                int ry = find(y);
                if(rx!=ry){
                    if(rank1[rx]>rank1[ry]){
                        root[ry]=rx;

                    }
                    else if(rank1[rx]<rank1[ry]){
                        root[rx]=ry;

                    }
                    else{
                        root[ry]=rx;

                        rank1[rx]++;

                    }
                }
            }
        }

}
