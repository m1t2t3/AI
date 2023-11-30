package Lab9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Node {
	private List<Integer> data = new ArrayList<Integer>();

	public void add(Integer val) {
		this.data.add(val);
	}

	public void addAll(List<Integer> data) {
		this.data.addAll(data);
	}

	// Get children of the current node
    public List<Node> getSuccessors() {
        List<Node> successors = new ArrayList<>();

        for (int i = 0; i < data.size(); i++) {
            for (int j = i + 1; j < data.size(); j++) {
                // Generate successors by dividing the pile into two non-empty piles
                List<Integer> childData = new ArrayList<>(data);
                int pile1 = childData.remove(j);
                int pile2 = childData.remove(i);
                childData.add(pile1 + pile2);

                Node childNode = new Node();
                childNode.addAll(childData);

                // Check if the successor is not identical to any existing successor
                if (!successors.contains(childNode)) {
                    successors.add(childNode);
                }
            }
        }

        return successors;
    }

	  public boolean isTerminal() {
	        // A node is terminal if the tokens of each pile cannot be divided
	        for (int tokens : data) {
	            if (tokens > 1) {
	                return false; // If there is any pile with more than one token, it can be divided
	            }
	        }
	        return true; // All piles have one or zero tokens, so cannot be divided further
	    }

	public static final Comparator<Integer> DESCOMPARATOR = new Comparator<Integer>() {

		@Override
		public int compare(Integer o1, Integer o2) {
			return o2.compareTo(o1);
		}
	};

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
