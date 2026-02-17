import java.util.*;

public class DFSExample {

    static void dfs(int node, ArrayList<ArrayList<Integer>> adj,
                    boolean[] visited, Vector<Integer> result) {

        visited[node] = true;
        result.add(node);

        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, adj, visited, result);
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int n = sc.nextInt();

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        System.out.print("Enter number of edges: ");
        int e = sc.nextInt();

        System.out.println("Enter edges (u v):");
        for (int i = 0; i < e; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u); // remove for directed graph
        }

        System.out.print("Enter starting vertex: ");
        int start = sc.nextInt();

        boolean[] visited = new boolean[n + 1];
        Vector<Integer> result = new Vector<>();

        dfs(start, adj, visited, result);

        System.out.println("DFS Traversal: " + result);

        sc.close();
    }
}

output:

Enter number of vertices: 8
Enter number of edges: 8
Enter edges (u v):
1 2
2 5
2 6
1 3
3 4
4 8
8 7
3 7
Enter starting vertex: 1

DFS Traversal: [1, 2, 5, 6, 3, 4, 8, 7]
