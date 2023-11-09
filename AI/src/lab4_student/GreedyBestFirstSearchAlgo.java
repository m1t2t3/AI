	package lab4_student;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class GreedyBestFirstSearchAlgo implements IInformedSearchAlgo {
	 public Node execute(Node root, String goal) {
	        PriorityQueue<Node> frontier  = new PriorityQueue<>(new NodeComparatorByHn());
	        frontier.add(root);
	        List<Node> explored = new ArrayList<>();
	        while (!frontier.isEmpty()) {
	            Node current = frontier.poll();
	            if(current.getLabel().equals(goal)) {
	                return current;
	            } else {
	                explored.add(current);
	                List<Edge> childEdges = current.getChildren();
	                for (Edge child : childEdges) {
	                    Node n = child.getEnd();
	                    if(!explored.contains(n) && !frontier.contains(n)) {
	                        frontier.add(n);
	                        n.setParent(current);
	                        n.setG(current.getG() + child.getWeight());
	                    } else if(frontier.contains(n) && n.getG() > (current.getG() + child.getWeight()) ) {
	                        n.setG(current.getG() + child.getWeight());
	                        n.setParent(current);
	                    }
	                }
	            }
	        }
	        return null;
	    }
	
	public boolean isAdmissibleH(Node root, String goal) {
		return false;
		
	}
	
	public Node execute(Node root, String start, String goal) {
		return root;
	
	}
}
