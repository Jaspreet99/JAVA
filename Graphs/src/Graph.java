public class Graph
{
    private int[][] adjacencyMatrix;
    private int size; // number of nodes in the graph
    private State[] states;
    private Queue queue;
    public Graph(int size)
    {
        this.size = size;
        adjacencyMatrix = new int[size][size];// Initialized with all 0s
        states = new State[size];
        for (int i = 0; i < size; i++)
        {
            states[i] = State.NEW;
        }
        queue = new Queue(size);
    }
    /* © Jaspreet Singh */
    public void addEdge(int sourceName, int destinationName)
    {
        int sourceIndex = sourceName - 1;
        int destinationIndex = destinationName - 1;
        adjacencyMatrix[sourceIndex][destinationIndex] = 1;
        // The Graph is Non Directional so if from Source, Destination is reachable, then Vice Versa is also True.//
        adjacencyMatrix[destinationIndex][sourceIndex] = 1;
    }

    public void traverseGraph()
    {
        System.out.println("Using BFS Traversing the Graph");

        for (int i = 0; i < size; i++) {
            if (states[i] != State.VISITED) {
                bfs(i+1);
            }
        }
    }

    private void bfs(int currentNodeName)
    {
        queue.add(currentNodeName);
        states[currentNodeName-1] = State.IN_Q;
        while(!queue.isEmpty())
        {
            int visitedNodeName = queue.remove();
            states[visitedNodeName-1] = State.VISITED;
            System.out.println(visitedNodeName);
            for(int i = 0; i < size; i++)
            {
                if(adjacencyMatrix[visitedNodeName-1][i] != 0)
                {
                    if(states[i] == State.NEW)
                    {
                        queue.add((i+1));
                        states[i] = State.IN_Q;
                    }
                }
            }
        }
    }

    public enum State
    {
        NEW, IN_Q, VISITED
    }

    public class Queue
    {
        Integer[] queue;
        int maxSize;
        int front = -1,rear = -1;

        Queue(int maxSize)
        {
            this.maxSize = maxSize;
            queue = new Integer[maxSize];
        }

        public void add(int node)
        {
            queue[++rear] = node;
        }

        public int remove()
        {
            int node = queue[++front];
            queue[front] = null;
            return node;
        }

        public boolean isEmpty()
        {
            return front == rear;
        }
    }

    public static void main(String[] args)
    {
        Graph graph = new Graph(14);

        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);
        graph.addEdge(3, 6);
        graph.addEdge(3, 7);
        graph.addEdge(9, 10);
        graph.addEdge(9, 11);
        graph.addEdge(9, 12);
        graph.addEdge(9, 13);
        graph.addEdge(10, 11);
        graph.addEdge(11, 14);
        graph.addEdge(12, 14);
        graph.traverseGraph();
    }
}