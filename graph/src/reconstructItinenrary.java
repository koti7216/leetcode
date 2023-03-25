import java.util.*;
//You are given a list of airline tickets where tickets[i] = [fromi, toi] represent the departure
// and the arrival airports of one flight. Reconstruct the itinerary in order and return it.
//
//All of the tickets belong to a man who departs from "JFK", thus, the itinerary must begin with "JFK".
// If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order
// when read as a single string.
//
//For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
//You may assume all tickets form at least one valid itinerary. You must use all the tickets once and only once.
//
//

public class reconstructItinenrary {
    class Solution {
        public List<String> findItinerary(List<List<String>> tickets) {
            LinkedList<String> res = new LinkedList<>();

            Map<String, PriorityQueue<String>> graph = new HashMap<>();
            for (List<String> flight: tickets) {
                String dep = flight.get(0);
                String arr = flight.get(1);

                if (!graph.containsKey(dep)) {
                    graph.put(dep, new PriorityQueue<>());
                }
                graph.get(dep).add(arr);
            }
            dfs(res, graph, "JFK");
            return res;
        }

        private void dfs(LinkedList<String> res, Map<String, PriorityQueue<String>> graph, String source) {
            PriorityQueue<String> arrivals = graph.get(source);
            while(arrivals!=null && !arrivals.isEmpty()){
                String next = arrivals.poll();
                dfs(res, graph, next);
            }
            res.addFirst(source);
        }
    }
}
