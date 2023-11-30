package Lab9;

import java.util.Arrays;
import java.util.List;

//public class TestNode {
//	public static void main(String[] args) {
//		Node node = new Node();
//		Integer[] data = { 7 };
//		node.addAll(Arrays.asList(data));
//
//		MinimaxAlgo algo = new MinimaxAlgo();
//		algo.execute(node);
//	}
//}
public class TestNode {
    public static void main(String[] args) {
        // Test with initial configuration having 7 tokens
        testAlgorithm(new Integer[]{7});

        // Test with initial configuration having 8 tokens
        testAlgorithm(new Integer[]{8});

        // Test with initial configuration having 9 tokens
        testAlgorithm(new Integer[]{9});
    }

    private static void testAlgorithm(Integer[] initialConfiguration) {
        Node node = new Node();
        node.addAll(Arrays.asList(initialConfiguration));

        MinimaxAlgo algo = new MinimaxAlgo();
        algo.execute(node);
        System.out.println("Initial Configuration: " + node);
        System.out.println();
    }
}
