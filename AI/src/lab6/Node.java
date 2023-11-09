package lab6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Node {
	public static final int N = 8;
	private Queen[] state;

	public Node() {
		// generateBoard();
		state = new Queen[N];
	}

	public Node(Queen[] state) {
		this.state = new Queen[N];
		for (int i = 0; i < state.length; i++) {
			this.state[i] = new Queen(state[i].getRow(), state[i].getColumn());
		}
	}

	public Node(Node n) {
		this.state = new Queen[N];
		for (int i = 0; i < N; i++) {
			Queen qi = n.state[i];
			this.state[i] = new Queen(qi.getRow(), qi.getColumn());
		}
	}

	public void generateBoard() {
		Random random = new Random();
		for (int i = 0; i < N; i++) {
			state[i] = new Queen(random.nextInt(N), i);
		}
	}
//task2
    public int getH() {
        int heuristic = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (state[i].isConflict(state[j])) {
                    heuristic++;
                }
            }
        }
        return heuristic;
    }
//task2
    public List<Node> generateAllCandidates() {
        List<Node> result = new ArrayList<Node>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (j != state[i].getColumn()) {
                    // Create a copy of the current state and move the queen to a new column
                    Queen[] newState = new Queen[N];
                    for (int k = 0; k < N; k++) {
                        newState[k] = new Queen(state[k].getRow(), state[k].getColumn());
                    }
                    newState[i].setRow(j);
                    result.add(new Node(newState));
                }
            }
        }
        return result;
    }
// task4
    public Node selectNextRandomCandidate(double temperature) {
        List<Node> candidates = generateAllCandidates();

        if (candidates.isEmpty()) {
            return null;
        }

        // Select a random neighbor from the candidates
        int randomIndex = (int) (Math.random() * candidates.size());
        Node neighbor = candidates.get(randomIndex);

        // Calculate the change in heuristic (deltaH) between the neighbor and the current state
        int deltaH = neighbor.getH() - this.getH();

        if (deltaH < 0 || Math.random() < Math.exp(-deltaH / temperature)) {
            return neighbor; // Accept the neighbor
        } else {
            return this; // Stay in the current state
        }
    }


	public void displayBoard() {
		int[][] board = new int[N][N];
		// set queen position on the board
		for (int i = 0; i < N; i++) {
			board[state[i].getRow()][state[i].getColumn()] = 1;
		}
		// print board
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (board[i][j] == 1) {
					System.out.print("Q" + " ");
				} else {
					System.out.print("-" + " ");
				}
			}
			System.out.println();
		}
	}
	
	// task 3 
	 public Node execute(Node initialState) {
	        Node current = initialState;

	        while (current.getH() != 0) {
	            List<Node> candidates = current.generateAllCandidates();
	            Node bestNeighbor = current;
	            
	            for (Node neighbor : candidates) {
	                if (neighbor.getH() <= bestNeighbor.getH()) {
	                    bestNeighbor = neighbor;
	                }
	            }

	            if (bestNeighbor.getH() >= current.getH()) {
	                // Hill climbing reached a peak, no better solution found
	                break;
	            }

	            current = bestNeighbor;
	        }

	        return current;
	    }
	
	 public Node executeHillClimbingWithRandomRestart(Node initialState) {
	        Node bestSolution = null;
	        int maxRestarts = 100; // You can adjust the number of random restarts as needed

	        while (maxRestarts > 0) {
	            Node solution = execute(initialState);

	            if (solution.getH() == 0) {
	                // Solution found
	                return solution;
	            }

	            // Random Restart
	            initialState.generateBoard();
	            maxRestarts--;
	        }

	        return bestSolution; // If no solution found after all restarts
	    }

}
