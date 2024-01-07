package org.example;
import org.graphstream.graph.Edge;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.ui.swingViewer.View;
import org.graphstream.ui.swingViewer.Viewer;
import org.graphstream.ui.swingViewer.util.Camera;
import java.util.Random;


public class Main {


    public static void main(String[] args) {

        DFS dfs = new DFS();

        System.setProperty("org.graphstream.ui.renderer", "org.graphstream.ui.j2dviewer.J2DGraphRenderer");
        Graph graph = generateRandomGraph(15, 40);


        Random random = new Random();
        int randomNodeIndex = random.nextInt(graph.getNodeCount());
        Node randomNode = graph.getNode(randomNodeIndex);
        dfs.runDfs(graph, randomNode.getId());


        Viewer viewer = graph.display();
        viewer.setCloseFramePolicy(Viewer.CloseFramePolicy.CLOSE_VIEWER);
        View view = viewer.getDefaultView();


        while (true) {
            rotateGraph(view.getCamera());
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    private static void rotateGraph(Camera camera) {
        double rotationSpeed = 0.8;
        double currentRotation = camera.getViewRotation();
        camera.setViewRotation(currentRotation + rotationSpeed);
    }

    private static Graph generateRandomGraph(int numNodes, int numEdges) {
        Graph graph = new SingleGraph("randomGraph");

        for (int i = 0; i < numNodes; i++) {
            graph.addNode(String.valueOf(i)).setAttribute("xy", Math.random() * 10, Math.random() * 10);
        }


        Random random = new Random();
        for (int i = 0; i < numEdges; i++) {
            int sourceIndex = random.nextInt(numNodes);
            int targetIndex = random.nextInt(numNodes);

            // para nao adicionar arestas para o mesmo no e areastas duplicadas
            while (sourceIndex == targetIndex || graph.getEdge(sourceIndex + "-" + targetIndex) != null) {
                targetIndex = random.nextInt(numNodes);
            }

            try {

                Edge edge = graph.addEdge(sourceIndex + "-" + targetIndex, String.valueOf(sourceIndex), String.valueOf(targetIndex));
                edge.setAttribute("ui.label", "Edge " + sourceIndex + "--------" + targetIndex);
            } catch (org.graphstream.graph.EdgeRejectedException e) {
                System.out.println("Aresta rejeitada: " + e.getMessage());
            }
        }

        return graph;
    }


}
