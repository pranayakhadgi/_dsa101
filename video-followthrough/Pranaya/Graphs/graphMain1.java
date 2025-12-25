package Pranaya.Graphs;

public class graphMain1 {
    public static void main(String[] args) {
        var graph = new Graphs();
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.traverseDepthFirst("R");
        graph.addEdge("B", "C");
        graph.print();

    }
}
