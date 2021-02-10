package visualizer;

import Calc.CalcParser;
import com.mxgraph.layout.mxCompactTreeLayout;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;

import javax.swing.*;


public class CalcVisualizer extends JFrame {
    private static int SIZE = 50;


    private static void recursiveDraw(mxGraph graph, Object preParent, CalcParser.Node tree, Object parent) {
        for (CalcParser.Node child : tree.getChildren()) {
            Object childNode = graph.insertVertex(preParent, null, child.getName(), 0, 0, SIZE, SIZE);
            graph.insertEdge(preParent, null, null, parent, childNode);
            recursiveDraw(graph, preParent, child, childNode);
        }
    }

    public static void show(CalcParser.Node tree) {
        CalcVisualizer frame = new CalcVisualizer();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1300, 1000);

        frame.draw(tree);

        frame.setVisible(true);
    }

    private void draw(CalcParser.Node tree) {
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
