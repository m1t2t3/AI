package Lab9;

public class MinimaxAlgo {
	 public int bestMove;
	 
	 public void execute(Node node) {
		 int v = minValue(node);
	        System.out.println("Minimax Value: " + v);
	        System.out.println("Best Move: " + bestMove);
	    }
	// function MAX-VALUE(state) returns a utility value
	// if TERMINAL-TEST(state) then return UTILITY(state)
	// v <- Integer.MIN_VALUE
	// for each s in SUCCESSORS(state) do
	// v <- MAX(v, MIN-VALUE(s))
	// return v
	 public int maxValue(Node node) {
	        if (isTerminal(node)) {
	            return 1;
	        }

	        int v = Integer.MIN_VALUE;
	        for (Node child : node.getSuccessors()) {
	            int minValue = minValue(child);
	            if (minValue > v) {
	                v = minValue;
	                bestMove = child.getMove(); // Track the best move
	            }
	        }
	        return v;
	    }
	// function MIN-VALUE(state) returns a utility value
	// if TERMINAL-TEST(state) then return UTILITY(state)
	// v <- Integer.MAX_VALUE
	// for each s in SUCCESSORS(state) do
	// v <- MIN(v, MAX-VALUE(s))
	// return v
	 public int minValue(Node node) {
	        if (isTerminal(node)) {
	            return 0;
	        }

	        int v = Integer.MAX_VALUE;
	        for (Node child : node.getSuccessors()) {
	            int maxValue = maxValue(child);
	            if (maxValue < v) {
	                v = maxValue;
	                bestMove = child.getMove(); // Track the best move
	            }
	        }
	        return v;
	    }
	public boolean isTerminal(Node node) {
        return node.isTerminal();
    }

}
