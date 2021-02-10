package visualizer;

import CDecl.CDeclParser;
import com.mxgraph.layout.mxCompactTreeLayout;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;

import javax.swing.*;

public class CDeclVisualizer extends JFrame {
    private static int SIZE = 50;


    private static void recursiveDraw(mxGraph graph, Object preParent, CDeclParser.Node tree, Object parent) {
        for (CDeclParser.Node child : tree.getChildren()) {
            Object childNode = graph.insertVertex(preParent, null, child.getName(), 0, 0, SIZE, SIZE);
            graph.insertEdge(preParent, null, null, parent, childNode);
            recursiveDraw(graph, preParent, child, childNode);
        }
    }

    public static void show(CDeclParser.Node tree) {
        CDeclVisualizer frame = new CDeclVisualizer();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1300, 1000);

        frame.draw(tree);

        frame.setVisible(true);
    }

    private void draw(CDeclParser.Node tree) {
        mxGraph graph = new mxGraph();

        Object preParent = graph.getDefaultParent();
        graph.setAutoSizeCells(true);
        graph.updateCellSize(preParent);

        Object rootNode = graph.insertVertex(preParent, null, tree.getName(), 0, 0, SIZE, SIZE);
        recursiveDraw(graph, preParent, tree, rootNode);

        new mxCompactTreeLayout(graph, false).execute(preParent);
        getContentPane().add(new mxGraphComponent(graph));
    }
}
