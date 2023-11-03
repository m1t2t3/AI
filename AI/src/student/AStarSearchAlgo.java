package student;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class AStarSearchAlgo implements IInformedSearchAlgo {
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
	                List<Edge> children = current.getChildren();
	                for (Edge e : children) {
	                    Node child = e.getEnd();
	                    if(!explored.contains(child) && !frontier.contains(child)) {
	                        frontier.add(child);
	                        child.setParent(current);
	                        child.setG(current.getG() + e.getWeight());
	                    } else if(frontier.contains(child) && child.getG() > (current.getG() + e.getWeight()) ) {
	                    	frontier.remove(child);
	                    	child.setG(current.getG() + e.getWeight());
	                    	child.setParent(current);
	                    	frontier.add(child);	                    }
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

