package org.example;

import org.graphstream.graph.DepthFirstIterator;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;

import java.util.ArrayList;
import java.util.List;

public class DFS {
    public  void runDfs(Graph graph, String startNode) {
        System.out.println("\nExecutando DFS a partir de " + startNode + ":");

        DepthFirstIterator<Node> dfs = new DepthFirstIterator<>(graph.getNode(startNode));
        List<Node> path = new ArrayList<>();


        while (dfs.hasNext()) {
            Node node = dfs.next();
            path.add(node);

            System.out.println("Nó " + node.getId() + " - Profundidade: " + (path.size() - 1));
            System.out.println("   Caminho: " + getPathIds(path));
        }
    }

    private List<String> getPathIds(List<Node> path) {
        List<String> pathIds = new ArrayList<>();
        for (Node node : path) {
            pathIds.add(node.getId());
        }
        return pathIds;
    }


}

