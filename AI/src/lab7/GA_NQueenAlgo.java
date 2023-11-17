package lab7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class GA_NQueenAlgo {
	public static final int POP_SIZE = 100;//Population size
	public static final double MUTATION_RATE = 0.03;
	public static final int MAX_ITERATIONS = 1000;
	List<Node> population = new ArrayList<Node>();
	Random rd = new Random();
	
	public void initPopulation() {
		for (int i = 0; i < POP_SIZE; i++) {
			Node ni = new Node();
			ni.generateBoard();
			population.add(ni);
		}
	}
	
	 public Node execute() {
		 initPopulation();
		 int k = 0;
		 while( k++ < MAX_ITERATIONS) {
			 List<Node> newPopulation = new ArrayList<>();
		 for (int i = 0; i< POP_SIZE; i++) {
			 Node x = getParentByRandomSelection();
			 Node y = getParentByRandomSelection();
			 Node child = reproduce(x, y);
			 if ( rd.nextDouble() < MUTATION_RATE) {
				 mutate(child);
			 }
			 if ( child.getH()==0) { 
				 return child;
			 }
			 newPopulation.add(child);
		 }
		 	population = newPopulation;
		 }
		 Collections.sort(population);
		 return population.get(0);
		 }
		 
		 
//	        for (int iteration = 0; iteration < MAX_ITERATIONS; iteration++) {
//	            List<Node> newPopulation = new ArrayList<>();
//
//	            Node bestIndividual = getBestIndividual();
//	            newPopulation.add(bestIndividual);
//
//	            while (newPopulation.size() < POP_SIZE) {
//	                Node parent1 = getParentByTournamentSelection();
//	                Node parent2 = getParentByTournamentSelection();
//
//	                Node child = reproduce(parent1, parent2);
//
//	                if (rd.nextDouble() < MUTATION_RATE) {
//	                    mutate(child);
//	                }
//
//	                newPopulation.add(child);
//	            }
//
//	            population = newPopulation;
//
//	            if (bestIndividual.getH() == 0) {
//	                break;
//	            }
//	        }
//
//	        return getBestIndividual();
	
	 
	 public void mutate(Node node) {
	        int randomQueenIndex = rd.nextInt(Node.N);
	        int randomRow = rd.nextInt(Node.N);
	        node.setRow(randomQueenIndex, randomRow);
	    }
	
	
	 public Node reproduce(Node x, Node y) {
//	        int crossoverPoint = rd.nextInt(Node.N);
//	        Queen[] childState = new Queen[Node.N];
//
//	        for (int i = 0; i < crossoverPoint; i++) {
//	            Queen queen = x.getState()[i];
//	            childState[i] = new Queen(queen.getRow(), queen.getColumn());
//	        }
//
//	        for (int i = crossoverPoint; i < Node.N; i++) {
//	            Queen queen = y.getState()[i];
//	            childState[i] = new Queen(queen.getRow(), queen.getColumn());
//	        }
//
//	        return new Node(childState);
		 Node child = new Node(); 
		 child.generateBoard();
		 int c = rd.nextInt(Node.N);
		 for (int i = 0; i < c; i++) {
			child.setRow(i, x.getRow(i));
		}
		 for (int i = c; i < Node.N; i++) {
			 child.setRow(i, y.getRow(i));			
		}
		return child;
}

	 public Node getParentByTournamentSelection() {
	        int tournamentSize = 5;
	        Node bestIndividual = null;

	        for (int i = 0; i < tournamentSize; i++) {
	            Node randomIndividual = population.get(rd.nextInt(POP_SIZE));

	            if (bestIndividual == null || randomIndividual.getH() < bestIndividual.getH()) {
	                bestIndividual = randomIndividual;
	            }
	        }

	        return bestIndividual;
	    }
	 
	  public Node getParentByRandomSelection() {
	        return population.get(rd.nextInt(POP_SIZE));
	    }
	  
	  
	  private Node getBestIndividual() {
	        Node bestIndividual = population.get(0);

	        for (Node individual : population) {
	            if (individual.getH() < bestIndividual.getH()) {
	                bestIndividual = individual;
	            }
	        }

	        return bestIndividual;
	    }
	}
