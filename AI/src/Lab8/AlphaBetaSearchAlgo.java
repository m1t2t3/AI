package Lab8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AlphaBetaSearchAlgo implements ISearchAlgo {

    @Override
    public void execute(Node node) {
        int v = maxValue(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
        System.out.println("Value at node " + node.getLabel() + ": " + v);

        // For each child node, obtain and print the value
        for (Node child : node.getChildren()) {
            int childValue = minValue(child, Integer.MIN_VALUE, Integer.MAX_VALUE);
            System.out.println("Value at node " + child.getLabel() + ": " + childValue);
        }
    }

    public int maxValue(Node node, int alpha, int beta) {
        if (node.isTerminal()) {
            return node.getValue();
        }

        int v = Integer.MIN_VALUE;
        // Sort children alphabetically using the defined comparator
		List<Node> sortedChildren = new ArrayList<>(node.getChildren());
		Collections.sort(sortedChildren, Node.LabelComparator);
        for (Node successor : node.getChildren()) {
            v = Math.max(v, minValue(successor, alpha, beta));
            if (v >= beta) {
                System.out.println("Pruned at node " + successor.getLabel());
                return v;
            }
            alpha = Math.max(alpha, v);
        }
        return v;
    }

    public int minValue(Node node, int alpha, int beta) {
        if (node.isTerminal()) {
            return node.getValue();
        }

        int v = Integer.MAX_VALUE;
        // Sort children alphabetically using the defined comparator
		List<Node> sortedChildren = new ArrayList<>(node.getChildren());
		Collections.sort(sortedChildren, Node.LabelComparator);

        for (Node successor : node.getChildren()) {
            v = Math.min(v, maxValue(successor, alpha, beta));
            if (v <= alpha) {
                System.out.println("Pruned at node " + successor.getLabel());
                return v;
            }
            beta = Math.min(beta, v);
        }
        return v;
    }
}
