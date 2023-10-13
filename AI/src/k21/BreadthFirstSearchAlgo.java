package k21;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.List;

public class BreadthFirstSearchAlgo implements ISearchAlgo {
	
    @Override
    public Node execute(Node root, String goal) {
        Queue<Node> frontier = new LinkedList<Node>();
        frontier.add(root);
        List<Node> explored = new ArrayList<Node> ();
        while (!frontier.isEmpty()) {
            Node currentNode = frontier.poll();

            if (currentNode.getLabel().equals(goal)) {
                return currentNode;
            }
            else 
            { 
            	explored.add(currentNode);
            }
            List<Node> children = currentNode.getChildrenNodes();
       
            for (Node child : children) {
                if (!explored.contains(child) && !frontier.contains(child)) {
                    child.setParent(currentNode);
                    frontier.add(child);
                }
            }
        }

        return null;
    }
    
    @Override
    public Node execute(Node root, String start, String goal) {
        Queue<Node> frontier = new LinkedList<>();
        List<Node> explored = new ArrayList<>();
        frontier.add(root);
        boolean started = false; // Initialize the started flag

        while (!frontier.isEmpty()) {
            Node currentNode = frontier.poll();

            if (currentNode.getLabel().equals(goal)) {
                return currentNode;
            }
            else { 
            	explored.add(currentNode);
            }
      

            List<Node> children = currentNode.getChildrenNodes();

            for (Node child : children) {
                if (!explored.contains(child) && !frontier.contains(child)) {
                    child.setParent(currentNode);
                    frontier.add(child);
                }
            }

            // Check if the current node is the start node
            if (currentNode.getLabel().equals(start)&& started) {
                // Mark that we've started the search
            	return currentNode;
            } 
            else { 
            	  
                       explored.clear();
                       frontier.clear();
                       currentNode.setParent(null);
            }
        }

        return null;
    }
    
    //task 3 
    @Override
	public Node execute(Node root, String goal) {
		// TODO Auto-generated method stub
		Queue<Node> frontier = new LinkedList<Node>();
		frontier.add(root);

		while (!frontier.isEmpty()) {
			Node currentNode = frontier.poll();
			if (currentNode.getLabel().equals(goal))
				return currentNode;

			List<Edge> edges = currentNode.getChildren();
			for (Edge edge : edges) {
				Node childNode = (Node) edge.getEnd().clone();
				childNode.setParent(currentNode);
				childNode.setPathCost(currentNode.getPathCost() + edge.getWeight());
				frontier.add(childNode);
			}
		}
		return null;
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		// TODO Auto-generated method stub
		Queue<Node> frontier = new LinkedList<Node>();
		frontier.add(root);

		while (!frontier.isEmpty()) {
			Node currentNode = frontier.poll();
			if (currentNode.getLabel().equals(goal))
				return currentNode;

			if (currentNode.getLabel().equals(start)) {
				frontier.clear();
				currentNode.setParent(null);
				currentNode.setPathCost(0);
			}

			List<Edge> edges = currentNode.getChildren();
			for (Edge edge : edges) {
				Node childNode = (Node) edge.getEnd().clone();
				childNode.setParent(currentNode);
				childNode.setPathCost(currentNode.getPathCost() + edge.getWeight());
				frontier.add(childNode);
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
//         Perform BFS
        ISearchAlgo algo1 = new BreadthFirstSearchAlgo();
        Node result = algo1.execute(nodeS, "G");
        List<String> path = NodeUtils.printPath(result);
        System.out.println("Path from S to G: " + path);
        
        
        
        
        
        ISearchAlgo algo2 = new BreadthFirstSearchAlgo();
        Node result2 = algo2.execute(nodeS, "S", "G");

        // Print the path from start node to the goal node
        List<String> path2 = NodeUtils.printPath(result2);

        System.out.println("Path from A to G: " + path2);

    }

	
}

