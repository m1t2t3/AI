package lab6;

import java.util.List;

public class HillClimbingSearchNQueen {
    int stepClimbed = 0;
    int stepClimbedAfterRandomRestart = 0;
    int randomRestarts = 0;


    public Node execute(Node initialState) {
        Node current = initialState;

        while (current.getH() != 0) {
            List<Node> candidates = current.generateAllCandidates();
            Node bestNeighbor = current;
            
            for (Node neighbor : candidates) {
                stepClimbed++;
                if (neighbor.getH() <= bestNeighbor.getH()) {
                    bestNeighbor = neighbor;
                }
            }

            if (bestNeighbor.getH() >= current.getH()) {
                break;
            }

            current = bestNeighbor;
        }

        return current;
    }

    public Node executeHillClimbingWithRandomRestart(Node initialState) {
        Node bestSolution = null;
        int maxRestarts = 100;
        while (maxRestarts > 0) {
            randomRestarts++;
            Node solution = execute(initialState);

            if (solution.getH() == 0) {
       
                return solution;
            }

     
            initialState.generateBoard();
            maxRestarts--;
        }

        return bestSolution; 
    }

}

