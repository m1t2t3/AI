package lab7;

public class test {
	 public static void main(String[] args) {
	        GA_NQueenAlgo ga = new GA_NQueenAlgo();

	        ga.initPopulation();

	        Node solution = ga.execute();

	        solution.displayBoard();
	        System.out.println("H: " + solution.getH());
	    }
}
