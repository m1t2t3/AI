package k21;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class UniformCostSearchAlgo implements ISearchAlgo {

	   @Override
	    public Node execute(Node root, String goal) {
	        PriorityQueue<Node> frontier  = new PriorityQueue<>(new NodeComparator());
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
	                    if(!explored.contains(n) || frontier.contains(n)) {
	                        frontier.add(n);
	                        n.setParent(current);
	                        n.setPathCost(current.getPathCost() + child.getWeight());
	                    } else if(frontier.contains(n) && n.getPathCost() > (current.getPathCost() + child.getWeight()) ) {
	                        n.setPathCost(current.getPathCost() + child.getWeight());
	                        n.setParent(current);
	                    }
	                }
	            }
	        }
	        return null;
	    }



	@Override
	public Node execute(Node root, String start, String goal) {
		PriorityQueue<Node> frontier = new PriorityQueue<Node>(new NodeComparator());
        frontier.add(root);
        List<Node> explored = new ArrayList<>();
        boolean started = false;
        while (!frontier.isEmpty()) {
            Node currentNode = frontier.poll();

            if (currentNode.getLabel().equals(goal)) {
                return currentNode;
       
            }
            else { 
            	   explored.add(currentNode);
            List<Edge> children = currentNode.getChildren();

            for (Edge child : children) {
                Node n = child.getEnd();
                double pathCost = currentNode.getPathCost() + child.getWeight();

                if (!frontier.contains(n) && pathCost < n.getPathCost()) {
                    n.setParent(currentNode);
                    n.setPathCost(currentNode.getPathCost()+ child.getWeight());
                    frontier.add(n);
                
                	}
                else if (frontier.contains(n)&& (n.getPathCost()> currentNode.getPathCost())) { 
                	n.setPathCost(currentNode.getPathCost());
                	n.setParent(currentNode);
                }
                
                else if (currentNode.getLabel().equals(start)&& started) {
                    // Mark that we've started the search
                	return currentNode;
                } 
                else  { 
                	  
                           explored.clear();
                           frontier.clear();
                           currentNode.setParent(null);
                }
            	}
            
            }
      
            
        }

        return null;
	}

	 public static void main(String[] args) {
	        // Create nodes and add edges as described in your example
	    	Node nodeS = new Node("S");
	    	Node nodeA = new Node("A"); Node nodeB = new Node("B");
	    	Node nodeC = new Node("C"); Node nodeD = new Node("D");
	    	Node nodeE = new Node("E"); Node nodeF = new Node("F");
	    	Node nodeG = new Node("G"); Node nodeH = new Node("H");
	    	nodeS.addEdge(nodeA, 5); nodeS.addEdge(nodeB, 2);
	    	nodeS.addEdge(nodeC, 4); nodeA.addEdge(nodeD, 9);
	    	nodeA.addEdge(nodeE, 4); nodeB.addEdge(nodeG, 6);
	    	nodeC.addEdge(nodeF, 2); nodeD.addEdge(nodeH, 7);
	    	nodeE.addEdge(nodeG, 6); nodeF.addEdge(nodeG, 1);
//	         Perform BFS
	        ISearchAlgo algo = new UniformCostSearchAlgo();
	        Node result = algo.execute(nodeS, "G");
	        List<String> path = NodeUtils.printPath(result);
	        System.out.println("Path from S to G: " + path);
	 }

	@Override
	public Node execute(Node root, String goal, int limitedDepth) {
		// TODO Auto-generated method stub
		return null;
	}
}
