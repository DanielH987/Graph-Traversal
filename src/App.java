import java.util.*;

class Graph {
    private List<String> nodes;
    private List<List<String>> edges;

    // Constructor to initialize the graph with nodes and edges
    public Graph(List<String> nodes, List<List<String>> edges) {
        this.nodes = nodes;
        this.edges = edges;
    }

    // Get neighbors of a given node
    public List<String> getNeighbors(String node) {
        int index = nodes.indexOf(node);
        if (index == -1) {
            return Collections.emptyList(); // Return an empty list if the node is not found
        }
        List<String> neighbors = new ArrayList<>();
        for (List<String> edge : edges) {
            if (edge.get(0).equals(node)) {
                neighbors.add(edge.get(1));
            } else if (edge.get(1).equals(node)) {
                neighbors.add(edge.get(0));
            }
        }
        Collections.sort(neighbors); // Sort neighbors alphabetically
        return neighbors;
    }

    // Perform depth-first search starting from a given node
    public void depthFirstSearch(String startNode) {
        Set<String> visited = new HashSet<>();
        System.out.println("Depth-First Search:");
        depthFirst(startNode, visited);
        System.out.println();
    }

    // Helper function for depth-first search
    private void depthFirst(String node, Set<String> visited) {
        visited.add(node);
        System.out.print(node + " ");
        List<String> neighbors = getNeighbors(node);
        for (String neighbor : neighbors) {
            if (!visited.contains(neighbor)) {
                depthFirst(neighbor, visited);
            }
        }
    }

    // Perform breadth-first search starting from a given node
    public void breadthFirstSearch(String startNode) {
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        System.out.println("Breadth-First Search:");
        visited.add(startNode);
        System.out.print(startNode + " ");
        queue.add(startNode);

        while (!queue.isEmpty()) {
            String currentNode = queue.poll();
            List<String> neighbors = getNeighbors(currentNode);
            for (String neighbor : neighbors) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    System.out.print(neighbor + " ");
                    queue.add(neighbor);
                }
            }
        }
        System.out.println();
    }
}

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read nodes
        String[] nodesArray = scanner.nextLine().split(" ");
        List<String> nodes = Arrays.asList(nodesArray);

        // Read start node
        String startNode = scanner.nextLine().trim();

        // Read edges
        List<List<String>> edges = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if (line.equals("***")) {
                break; // Stop reading edges when "***" is encountered
            }
            String[] edge = line.split(" ");
            edges.add(Arrays.asList(edge[0], edge[1]));
        }

        Graph graph = new Graph(nodes, edges);

        // Print node neighbors
        System.out.println("Node Neighbors:");
        for (String node : nodes) {
            List<String> neighbors = graph.getNeighbors(node);
            System.out.print(node + ": ");
            for (String neighbor : neighbors) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }

        // Depth-First Search
        graph.depthFirstSearch(startNode);

        // Breadth-First Search
        graph.breadthFirstSearch(startNode);

        scanner.close();
    }
}
