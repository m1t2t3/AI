package Lab9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Node {
	private List<Integer> data = new ArrayList<Integer>();
    private int move; // Added field to track the move

	public void add(Integer val) {
		this.data.add(val);
	}

	public void addAll(List<Integer> data) {
		this.data.addAll(data);
	}
// task2
	// Get children of the current node
    public List<Node> getSuccessors() {
    	data.sort(DESCOMPARATOR);       
    	List<Node> successors = new ArrayList<>();

        for (int i = 0; i < data.size(); i++) {
        	int count = data.get(i);
            for (int j = 1; j <= count/2; j++) {
            	if (j!= (count - j)) {
            		Node n = new Node();
            		n.add(j);
            		n.add(count - j);
            		for (int k = 0; k < data.size(); k++) {
						if(k!=i) {
							n.add(data.get(k));
						}
					}
            		  successors.add(n);
            	}

            }
        }

        return successors;
    }
// task1
	  public boolean isTerminal() {
	        
	        for (int tokens : data) {
	            if (tokens > 1) {
	                return false; 
	            }
	        }
	        return true; 
	    }

	public static final Comparator<Integer> DESCOMPARATOR = new Comparator<Integer>() {

		@Override
		public int compare(Integer o1, Integer o2) {
			return o2.compareTo(o1);
		}
	};
	 public void setMove(int move1, int move2) {
	        this.move = move1 * 10 + move2; // Combine move1 and move2 into a single integer for simplicity
	    }

	    public int getMove() {
	        return this.move;
	    }
	@Override
	public boolean equals(Object obj) {
	    if (this == obj) {
	        return true;
	    }
	    if (obj == null || getClass() != obj.getClass()) {
	        return false;
	    }
	    Node otherNode = (Node) obj;
	    return this.data.equals(otherNode.data);
	}

	@Override
	public String toString() {
		Collections.sort(this.data, DESCOMPARATOR);
		return this.data.toString();
	}

}
