import java.util.ArrayList;
import java.util.List;

public class BinaryTree {
    public static List<Object> createBinaryTree(Object r) {
        List<Object> tree = new ArrayList<>();
        tree.add(r);
        tree.add(new ArrayList<>());
        tree.add(new ArrayList<>());
        return tree;
    }

    private static List<Object> createBinaryTree(Object r, List<Object> left, List<Object> right) {
        List<Object> tree = new ArrayList<>();
        tree.add(r);
        tree.add(left);
        tree.add(right);
        return tree;
    }
}