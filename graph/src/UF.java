import java.util.*;

  public class UF {
        private int[] parent;
        private int[] rank;

        public UF(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int leader(int x) {
            if (parent[x] == x) {
                return x;
            }
            return parent[x] = leader(parent[x]);
        }

        public boolean unite(int x, int y) {
            x = leader(x);
            y = leader(y);
            if (x == y) {
                return false;
            }
            if (rank[y] > rank[x]) {
                int tmp = x;
                x = y;
                y = tmp;
            }
            parent[y] = x;
            if (rank[y] == rank[x]) {
                rank[x]++;
            }
            return true;
        }
    }


    class Pair<K, V> {
        private final K key;
        private final V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }

