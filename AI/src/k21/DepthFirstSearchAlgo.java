package k21;

import java.util.Stack;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DepthFirstSearchAlgo implements ISearchAlgo {
	 @Override
	    public Node execute(Node root, String goal) {
	        Stack<Node> frontier = new Stack<>();
	        frontier.add(root);
	        Set<Node> explored = new HashSet<>();
	        int state = 1;

	        while (!frontier.isEmpty()) {
	            Node current = frontier.pop();

	            if (current.getLabel().equals(goal)) {
	                return current;
	            }

	            explored.add(current);
	            List<Node> childNodes = current.getChildrenNodes();

	            // Sắp xếp các nút con theo thứ tự ngược lại
	            if(state == 1) {
	                Collections.sort(childNodes, new Comparator<Node>() {
	                    @Override
	                    public int compare(Node node1, Node node2) {
	                        return node2.getLabel().compareTo(node1.getLabel());
	                    }
	                });
	                state++;
	            }

	            for (Node child : childNodes) {
	                if (!explored.contains(child) && !frontier.contains(child)) {
	                    frontier.add(child);
	                    child.setParent(current);
	                }
	            }
	        }

	        return null;
	    }



	    @Override
	    public Node execute(Node root, String start, String goal) {
	        Stack<Node> frontier = new Stack<>();
	        frontier.add(root);
	        Set<Node> explored = new HashSet<>();
	        int state = 1;
	        boolean started =false;
	        while (!frontier.isEmpty()) {
	            Node current = frontier.pop();

	            if(current.getLabel().equals(start)) {
	                started = true;
	                current.setParent(null);
	            }
	            if (current.getLabel().equals(goal) ) {
	                return current;
	            } else {

	                if(started) {
	                    started = false;
	                    explored.clear();
	                    frontier.clear();
	                }

	                explored.add(current);
	                List<Node> childNodes = current.getChildrenNodes();

	                // Sắp xếp các nút con theo thứ tự ngược lại
	                if(state == 1) {
	                    Collections.sort(childNodes, new Comparator<Node>() {
	                        @Override
	                        public int compare(Node node1, Node node2) {
	                            return node2.getLabel().compareTo(node1.getLabel());
	                        }
	                    });
	                    state++;
	                }

	                for (Node child : childNodes) {
	                    if (!explored.contains(child) && !frontier.contains(child)) {
	                        frontier.add(child);
	                        child.setParent(current);
	                    }
	                }
	            }
	        }

	        return null;
	    }
    
//    //task3 ( tree search)
//	@Override
//	public Node execute(Node root, String goal) {
//		// TODO Auto-generated method stub
//		Stack<Node> frontier = new Stack<Node>();
//		frontier.push(root);
//
//		while (!frontier.isEmpty()) {
//			Node currentNode = frontier.pop();
//			if (currentNode.getLabel().equals(goal))
//				return currentNode;
//
//			List<Edge> edges = currentNode.getChildren();
//			Collections.sort(edges);
//			for (Edge edge : edges) {
//				Node childNode = (Node) edge.getEnd().clone();
//				childNode.setParent(currentNode);
//				childNode.setPathCost(currentNode.getPathCost() + edge.getWeight());
//				frontier.push(childNode);
//			}
//		}
//		return null;
//	}
////task 2
//	@Override
//	public Node execute(Node root, String start, String goal) {
//		// TODO Auto-generated method stub
//		Stack<Node> frontier = new Stack<Node>();
//		frontier.push(root);
//
//		while (!frontier.isEmpty()) {
//			Node currentNode = frontier.pop();
//			if (currentNode.getLabel().equals(goal))
//				return currentNode;
//			if (currentNode.getLabel().equals(start)) {
//				frontier.clear();
//				currentNode.setParent(null);
//				currentNode.setPathCost(0);
//			}
//			List<Edge> edges = currentNode.getChildren();
//			Collections.sort(edges);
//			for (Edge edge : edges) {
//				Node childNode = (Node) edge.getEnd().clone();
//				childNode.setParent(currentNode);
//				childNode.setPathCost(currentNode.getPathCost() + edge.getWeight());
//				frontier.push(childNode);
//			}
//		}
//		return null;
//	}

    public static void main(String[] args) {
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
        // Perform DFS
        ISearchAlgo algo1 = new DepthFirstSearchAlgo();
        Node result = algo1.execute(nodeS, "G");
        
        ISearchAlgo algo2 = new BreadthFirstSearchAlgo();
        Node result2 = algo2.execute(nodeS, "S", "G");

        // Print the path from start node to the goal node
        List<String> path = NodeUtils.printPath(result);
        List<String> path2 = NodeUtils.printPath(result2);

        System.out.println("Path from S to G: " + path);
        System.out.println("Path from S to G: " + path2);
    }


	@Override
	public Node execute(Node root, String goal, int limitedDepth) {
		// TODO Auto-generated method stub
		return null;
	}
 


}
