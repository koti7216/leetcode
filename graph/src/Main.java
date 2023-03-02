import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void solve(int[] on, int[] dist) {
        int n = on.length, OK = n, ans = 0;
        UF uf = new UF(n+1);
        List<Pair<Integer, Pair<Integer, Integer>>> all = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            all.add(new Pair<>(dist[i]-dist[i-1], new Pair<>(i-1, i)));
            if (on[i] == 1) {
                uf.unite(i, OK);
            }
        }
        Collections.sort(all, Comparator.comparing(Pair::getKey));
        for (Pair<Integer, Pair<Integer, Integer>> p : all) {
            int cost = p.getKey();
            int x = p.getValue().getKey();
            int y = p.getValue().getValue();
            if (uf.unite(x, y)) {
                ans += cost;
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        int[] on = {1,0,0};
        int[] dist = {1,5,6};
        solve(on, dist);
    }
}

