import java.util.*;

public class Graph {
    // Adjacency matrix to represent the graph.
    private int[][] adjacencyMatrix;

    // Map to associate vertex names with their indices in the matrix.
    private Map<String, Integer> vertexIndexMap;

    // Constructor initializes the adjacency matrix and the vertex-to-index map.
    public Graph(String[] vertices) {
        int size = vertices.length;
        adjacencyMatrix = new int[size][size];
        vertexIndexMap = new HashMap<>();

        for (int i = 0; i < size; i++) {
            vertexIndexMap.put(vertices[i], i);

            // Initializing matrix with max values, indicating no connections.
            Arrays.fill(adjacencyMatrix[i], Integer.MAX_VALUE);
        }
    }

    // Method to add an edge between two vertices with a specific weight.
    public void addEdge(String vertex1, String vertex2, int weight) {
        int index1 = vertexIndexMap.get(vertex1);
        int index2 = vertexIndexMap.get(vertex2);
        adjacencyMatrix[index1][index2] = weight;
        adjacencyMatrix[index2][index1] = weight;
    }

    // Method to get the distance between two vertices.
    public int getDistance(String vertex1, String vertex2) {
        int index1 = vertexIndexMap.get(vertex1);
        int index2 = vertexIndexMap.get(vertex2);
        return adjacencyMatrix[index1][index2];
    }

    // Method to get neighboring vertices of a given vertex.
    public List<String> getNeighbors(String vertex) {
        List<String> neighbors = new ArrayList<>();
        int index = vertexIndexMap.get(vertex);
        for (Map.Entry<String, Integer> entry : vertexIndexMap.entrySet()) {
            if (adjacencyMatrix[index][entry.getValue()] != Integer.MAX_VALUE) {
                neighbors.add(entry.getKey());
            }
        }
        return neighbors;
    }

    // Method to print the adjacency matrix.
    public void print() {
        for (int[] row : adjacencyMatrix) {
            for (int weight : row) {
                System.out.print((weight == Integer.MAX_VALUE ? "INF" : weight) + "\t");
            }
            System.out.println();
        }
    }

    // Test method for the Graph class.
    public static void main(String[] args) {
        String[] vertices = { "Mohave", "Coconino", "Navajo", "Apache", "Greenlee", "Cochise", "Santa Cruz", "Pima",
                "Pinal", "Graham", "Gila", "Yavapai", "La Paz", "Yuma", "Maricopa" };
        Graph graph = new Graph(vertices);

        // Adding edges based on the provided image.
        graph.addEdge("Mohave", "Coconino", 1);
        graph.addEdge("Mohave", "Yavapai", 14);
        graph.addEdge("Mohave", "La Paz", 12);
        graph.addEdge("Coconino", "Navajo", 15);
        graph.addEdge("Coconino", "Yavapai", 11);
        graph.addEdge("Coconino", "Yuma", 13);
        graph.addEdge("Navajo", "Apache", 20);
        graph.addEdge("Navajo", "Gila", 19);
        graph.addEdge("Apache", "Greenlee", 25);
        graph.addEdge("Greenlee", "Graham", 4);
        graph.addEdge("Greenlee", "Cochise", 16);
        graph.addEdge("Cochise", "Graham", 5);
        graph.addEdge("Cochise", "Pima", 6);
        graph.addEdge("Cochise", "Santa Cruz", 6);
        graph.addEdge("Santa Cruz", "Pima", 7);
        graph.addEdge("Pima", "Pinal", 8);
        graph.addEdge("Pinal", "Graham", 9);
        graph.addEdge("Pinal", "Gila", 10);
        graph.addEdge("Pinal", "Maricopa", 14);
        graph.addEdge("Graham", "Gila", 9);
        graph.addEdge("Gila", "Yavapai", 18);
        graph.addEdge("Gila", "Maricopa", 10);
        graph.addEdge("Yavapai", "Maricopa", 14);
        graph.addEdge("La Paz", "Yuma", 15);
        graph.addEdge("Yuma", "Maricopa", 13);

        // Testing the getDistance and getNeighbors methods.
        System.out.println("Distance between Mohave and Coconino: " + graph.getDistance("Mohave", "Coconino"));
        System.out.println("Neighbors of Coconino: " + graph.getNeighbors("Coconino"));

        // Printing the adjacency matrix.
        System.out.println("Adjacency Matrix:");
        graph.print();
    }
}
