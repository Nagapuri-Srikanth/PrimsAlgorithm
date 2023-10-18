public class Main {
    private static final int V = 7;

    private int minKey(int[] key, boolean[] mstSet) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int v = 0; v < V; v++) {
            if (!mstSet[v] && key[v] < min) {
                min = key[v];
                minIndex = v;
            }
        }

        return minIndex;
    }

    private void printMST(int[] parent, int[][] graph) {
        System.out.println("Edge \tWeight");

        int sum = 0;
        for (int i = 1; i < V; i++) {
            System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
            sum=sum+graph[i][parent[i]];
        }
        System.out.println("The Mst Weight is:" + sum);
    }

    private void primMST(int[][] graph) {
        int[] parent = new int[V];
        int[] key = new int[V];
        boolean[] mstSet = new boolean[V];

        for (int i = 0; i < V; i++) {
            key[i] = Integer.MAX_VALUE;
            mstSet[i] = false;
        }

        key[0] = 0;
        parent[0] = -1;

        for (int count = 0; count < V - 1; count++) {
            int u = minKey(key, mstSet);
            mstSet[u] = true;

            for (int v = 0; v < V; v++) {
                if (graph[u][v] != 0 && !mstSet[v] && graph[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
            }
        }

        printMST(parent, graph);
    }

    public static void main(String[] args) {
        Main prim = new Main();
        int[][] graph = {
                {0, 9, 0, 0, 0, 1, 0},
                {9, 0, 4, 0, 0, 0, 3},
                {0, 4, 0, 2, 0, 0, 0},
                {0, 0, 2, 0, 6, 0, 5},
                {0, 0, 0, 6, 0, 8, 7},
                {1, 0, 0, 0, 8, 0, 0},
                {0, 3, 0, 5, 7, 0, 0}
        };

        prim.primMST(graph);
    }
}
