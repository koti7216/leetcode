

import java.util.*;

// You are given an array of variable pairs equations and an array of real numbers values,
// where equations[i] = [Ai, Bi] and values[i] represent the equation Ai / Bi = values[i].
// Each Ai or Bi is a string that represents a single variable.
//
//You are also given some queries, where queries[j] = [Cj, Dj] represents the jth query where you must
// find the answer for Cj / Dj = ?.
//
//Return the answers to all queries. If a single answer cannot be determined, return -1.0.
//
//Note: The input is always valid. You may assume that evaluating the queries will not result in division by zero
// and that there is no contradiction.

public class EvaluateDivison {

        public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
            UnionFind uf = new UnionFind();
            double[] result = new double[queries.size()];
            for(int i=0; i < equations.size();i++){
                String divd = equations.get(i).get(0);
                String divs = equations.get(i).get(1);
                uf.union(divd,divs,values[i]);
            }
            for(int i=0;i<queries.size();i++){
                String divd = queries.get(i).get(0);
                String divs = queries.get(i).get(1);
                if(!(uf.m.containsKey(divd)) || !(uf.m.containsKey(divs)))
                    result[i]=-1.0;
                else if(!(uf.connected(divd,divs)))
                    result[i] = -1.0;
                else{
                    result[i] = uf.m.get(divd).getValue() / uf.m.get(divs).getValue();
                }
            }

            return result;
        }
        class UnionFind{
            private HashMap<String,Pair<String,Double>> m;
            UnionFind(){
                m = new HashMap<>();
            }
            public Pair<String,Double> find(String x){
                m.putIfAbsent(x,new Pair<String,Double>(x,1.0));
                Pair<String,Double> p = m.get(x);
                if(!p.getKey().equals(x)){
                    Pair<String,Double> p1 = find(p.getKey());
                    m.put(x,new Pair<String,Double>(p1.getKey(),p.getValue()*p1.getValue()));
                }
                return m.get(x);
            }
            public void union(String x, String y, Double z){
                Pair<String,Double> rx = find(x);
                Pair<String,Double> ry = find(y);
                String divd = rx.getKey();
                String divs = ry.getKey();
                Double weightdivd = rx.getValue();
                Double weightdivs = ry.getValue();
                if(!divd.equals(divs)){
                    m.put(divd,new Pair<String,Double>(divs,(weightdivs*z)/weightdivd));
                }

            }
            public boolean connected(String x,String y){
                Pair<String,Double> rx = find(x);
                Pair<String,Double> ry = find(y);
                String divd = rx.getKey();
                String divs = ry.getKey();
                return (divs.equals(divd));
            }
        }



}
