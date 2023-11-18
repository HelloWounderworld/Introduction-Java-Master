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

    public static List<Object> insertLeft(List<Object> root, Object newBranch) {
        List<Object> t = (List<Object>) root.get(1);
        if (t.size() > 1) {
            root.set(1, createBinaryTree(newBranch, t, new ArrayList<>()));
        } else {
            root.set(1, createBinaryTree(newBranch, new ArrayList<>(), new ArrayList<>()));
        }
        return root;
    }

    public static List<Object> insertRight(List<Object> root, Object newBranch) {
        List<Object> t = (List<Object>) root.get(2);
        if (t.size() > 1) {
            root.set(2, createBinaryTree(newBranch, new ArrayList<>(), t));
        } else {
            root.set(2, createBinaryTree(newBranch, new ArrayList<>(), new ArrayList<>()));
        }
        return root;
    }

    public static Object getRootVal(List<Object> root) {
        return root.get(0);
    }

    public static void setRootVal(List<Object> root, Object newVal) {
        root.set(0, newVal);
    }

    public static List<Object> getLeftChild(List<Object> root) {
        return (List<Object>) root.get(1);
    }

    public static List<Object> getRightChild(List<Object> root) {
        return (List<Object>) root.get(2);
    }

    private static List<Object> createBinaryTree(Object r, List<Object> left, List<Object> right) {
        List<Object> tree = new ArrayList<>();
        tree.add(r);
        tree.add(left);
        tree.add(right);
        return tree;
    }
}