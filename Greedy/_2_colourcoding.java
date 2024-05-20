import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Edge {
    int src, dest;

    Edge(int src, int dest) {
        this.src = src;
        this.dest = dest;
    }
}

class Graph {
    List<List<Integer>> adjList;

    Graph(List<Edge> edges, int n) {
        adjList = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (Edge edge : edges) {
            int src = edge.src;
            int dest = edge.dest;

            adjList.get(src).add(dest);
            adjList.get(dest).add(src);
        }
    }
}
public class _2_colourcoding {
     private static final String[] colors = {
            "", "BLUE", "GREEN", "RED", "YELLOW", "ORANGE", "PINK",
            "BLACK", "BROWN", "WHITE", "PURPLE", "VIOLET"};

    public static void colorGraph(Graph graph, int n) {
        Map<Integer, Integer> result = new HashMap<>();

        for (int u = 0; u < n; u++) {
            Set<Integer> assigned = new HashSet<>();

            for (int i : graph.adjList.get(u)) {
                if (result.containsKey(i)) {
                    assigned.add(result.get(i));
                }
            }

            int color = 1;
            for (int c : assigned) {
                if (color != c) {
                    break;
                }
                color++;
            }

            result.put(u, color);
        }

        for (int v = 0; v < n; v++) {
            System.out.println("The color assigned to vertex " + v + " is " + colors[result.get(v)]);
        }
    }

    public static void main(String[] args) {
        List<Edge> edges = Arrays.asList(
                new Edge(0, 1), new Edge(0, 4), new Edge(0, 5), new Edge(4, 5),
                new Edge(1, 4), new Edge(1, 3), new Edge(2, 3), new Edge(2, 4));

        int n = 6;

        Graph graph = new Graph(edges, n);

        colorGraph(graph, n);
    }
}
