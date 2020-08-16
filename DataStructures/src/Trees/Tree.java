package Trees;

public class Tree {

    private  TreeNode root;

    public void insert(int value) {
        if (root == null) {
            root = new TreeNode(value);
        }
        else {
            root.insert(value);
        }
    }

    public void traverseInOrder() {
        if (root != null) {
            root.traverseInOrder();
        }
    }

    public void traversePreOrder() {
        if (root != null) {
            root.traversePreOrder();
        }
    }

    public TreeNode get(int value) {
        if (root != null) {
            return root.get(value);
        }

        return null;
    }

    public void delete(int value) {
        root = delete(root, value);
    }

    private TreeNode delete(TreeNode subtreeRoot, int value) {
        if (subtreeRoot == null ){
            return null;
        }
        if (value < subtreeRoot.getData()) {
            subtreeRoot.setLeftChild(delete(subtreeRoot.getLeftChild(), value));
        }
        else if (value > subtreeRoot.getData()) {
            subtreeRoot.setRightChild(delete(subtreeRoot.getRightChild(), value));
        }
        else {
            // CASE where node has max 1 child
            if (subtreeRoot.getLeftChild() == null ) {
                return subtreeRoot.getRightChild();
            }
            else if (subtreeRoot.getRightChild() == null ) {
                return subtreeRoot.getLeftChild();
            }
            // Case where node has 2 children
            // Replace the value in the subtree node with the smallest value
            subtreeRoot.setData(subtreeRoot.getRightChild().min());
            // Delete the node that has the smallest value in the right subtree
            subtreeRoot.setRightChild(delete(subtreeRoot.getRightChild(), subtreeRoot.getData()));
        }
        return subtreeRoot;
    }

    public int min () {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        else {
            return root.min();
        }
    }
    public int max () {
        if (root == null) {
            return Integer.MAX_VALUE;
        }
        return root.max();
    }

}
