class Graph {
    private int[][] adjacencyMatrix;
    private int size; // number of nodes in the graph
    private boolean[] visited;

    public Graph(int size) {
        this.size = size;
        adjacencyMatrix = new int[size][size];// Initialized with all 0s
        visited = new boolean[size];
    }

    public void addEdge(int sourceName, int destinationName) {
        int sourceIndex = sourceName - 1;
        int destinationIndex = destinationName - 1;
        adjacencyMatrix[sourceIndex][destinationIndex] = 1;
        /* © Jaspreet Singh */
        /* The Graph is Non Directional so if from Source, Destination is Reachable then Vice Versa is also True.*/
        adjacencyMatrix[destinationIndex][sourceIndex] = 1;
    }

    public void traverseGraph() {
        System.out.println("Using DFS Traversing the Graph");
        /*If graph contains disconnected nodes or sub graphs then below loops makes sure that all such nodes or sub graphs are also visited In a single connected graph below loop is not needed and simply dfs(1); can be called and the graph will be visited. */
        for (int i = 1; i <= size; i++) {
            if (!visited[i - 1]) {
                dfs(i);
            }
        }
    }

    private void dfs(int currentNodeName) {
        visited[currentNodeName - 1] = true;
        System.out.println(currentNodeName);
        for (int i = 0; i < size; i++) {
            if (adjacencyMatrix[currentNodeName - 1][i] != 0) {
                if (!visited[i]) {
                    dfs(i + 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(11);

        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 5);
        graph.addEdge(3, 6);
        graph.addEdge(4, 5);
        graph.addEdge(4, 7);
        graph.addEdge(9, 11);
        graph.addEdge(10, 11);
        graph.traverseGraph();
    }

}