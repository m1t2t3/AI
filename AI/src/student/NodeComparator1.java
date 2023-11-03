package student;

import java.util.Comparator;

public class NodeComparator1 implements Comparator<Node> {

    @Override
    public int compare(Node o1, Node o2) {
        if(o1.getH() == o2.getH()) {
            return (int) (o1.getLabel().compareTo(o2.getLabel()));
        }

        return (int) (o1.getH()+ o1.getG() - o2.getH()-o2.getG());
    }
}
