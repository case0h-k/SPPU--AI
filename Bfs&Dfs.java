import java.util.*;

public class BFSGraph {

    // Function to add edge (undirected)
    static void addEdge(ArrayList<ArrayList<Integer>> graph, int u, int v) {
        graph.get(u).add(v);
        graph.get(v).add(u);
    }

    // BFS function
    static void bfs(ArrayList<ArrayList<Integer>> graph, int start, int V) {

        boolean[] visited = new boolean[V];   // visited array
        Queue<Integer> q = new LinkedList<>(); // queue

        visited[start] = true;
        q.add(start);

        while (!q.isEmpty()) {
            int node = q.poll();
            System.out.print(node + " ");

            for (int neighbor : graph.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    q.add(neighbor);
                }
            }
        }
    }

    public static void main(String[] args) {

        int V = 5; // number of vertices

        // create adjacency list
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < V; i++)
            graph.add(new ArrayList<>());

        // add edges
        addEdge(graph, 0, 1);
        addEdge(graph, 0, 2);
        addEdge(graph, 1, 3);
        addEdge(graph, 2, 4);

        System.out.println("BFS Traversal:");
        bfs(graph, 0, V);
    }
}
