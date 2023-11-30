package Lab9;

public class MinimaxAlgo {
	 private int bestMove;
	 
	 public void execute(Node node) {
	        int v = maxValue(node);
	        System.out.println("Optimal Value at root node: " + v);
	        System.out.println("Best Move for MIN player: " + bestMove);
	    }
	// function MAX-VALUE(state) returns a utility value
	// if TERMINAL-TEST(state) then return UTILITY(state)
	// v <- Integer.MIN_VALUE
	// for each s in SUCCESSORS(state) do
	// v <- MAX(v, MIN-VALUE(s))
	// return v
	 private int maxValue(Node node) {
	        if (isTerminal(node)) {
	            return utility(node);
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
	 private int minValue(Node node) {
	        if (isTerminal(node)) {
	            return utility(node);
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
	private boolean isTerminal(Node node) {
        return node.isTerminal();
    }
	private int utility(Node node) {
        // Assign values based on the outcome of the game
        return (node.isTerminal()) ? 1 : 0;
    }
}
