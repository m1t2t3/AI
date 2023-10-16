package k21;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public interface ISearchAlgo {
	public Node execute(Node root, String goal);// find the path from root node to the goal node

//	public Node execute(Node root, String start, String goal); // find the path from start node to the goal node

	public Node execute(Node root, String start, String goal);
	
	public Node execute(Node root, String goal, int limitedDepth);
}
